package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a2_pizzeria.databinding.ActivityMainBinding;
import com.example.a2_pizzeria.dbHelpers.DbHelper;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences currentUserPreferences;
    private static SharedPreferences screensColorPreferences;
    private ActivityMainBinding binding;

    private DbHelper dbHelper = new DbHelper(this);

    public static void setScreenBackgroundColor(ConstraintLayout screen) {
        int color = screensColorPreferences.getInt("color", 0);
        screen.setBackgroundColor(color);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        currentUserPreferences = getSharedPreferences("currentUser", Context.MODE_PRIVATE);
        screensColorPreferences = getSharedPreferences("screensColor", Context.MODE_PRIVATE);

        if (!currentUserPreferences.getAll().isEmpty()) {
            if (currentUserPreferences.getBoolean("remember", false)) {
                String user = currentUserPreferences.getString("username", "");
                String password = currentUserPreferences.getString("password", "");

                binding.edtName.setText(user);
                binding.edtPassword.setText(password);
                binding.cbRemember.setChecked(true);
            }
            else {
                SharedPreferences.Editor editor = currentUserPreferences.edit();
                editor.clear();
                editor.apply();
            }
        }

        int color = Color.parseColor("#F6ECCC");

        if (screensColorPreferences.getAll().isEmpty()) {
            SharedPreferences.Editor editor = screensColorPreferences.edit();
            editor.putInt("color", color);
            editor.apply();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setScreenBackgroundColor(binding.getRoot());
    }

    public void signUpUser(View view) {
        String username = binding.edtName.getText().toString();
        String password = binding.edtPassword.getText().toString();

        if (!username.isEmpty() && !password.isEmpty()) {
            if (!dbHelper.signUpUser(username, password)) {
                showUserExistsMessage();
            }
            else {
                binding.edtName.setText("");
                binding.edtPassword.setText("");
                binding.cbRemember.setChecked(false);
            }
        }
        else {
            showIncorrectSignUpMessage();
        }
    }

    public void logInUser(View view) {
        boolean isCorrect = false;
        String username = binding.edtName.getText().toString();
        String password = binding.edtPassword.getText().toString();

        isCorrect = dbHelper.logInUser(username, password);

        if (isCorrect) {
            boolean remember = binding.cbRemember.isChecked();

            SharedPreferences.Editor editor = currentUserPreferences.edit();
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putBoolean("remember", remember);
            editor.apply();

            startActivity(new Intent(this, MainScreen.class));

            if (!remember) {
                binding.edtName.setText("");
                binding.edtPassword.setText("");
                binding.cbRemember.setChecked(false);
            }
        }
        else {
            showIncorrectLogInMessage();
        }
    }

    public void showUserExistsMessage() {
        Toast.makeText(this, "Este usuario ya existe.", Toast.LENGTH_SHORT).show();
    }

    public void showIncorrectSignUpMessage() {
        Toast.makeText(this, "Todos los campos deben estar rellenos.", Toast.LENGTH_SHORT).show();
    }

    public void showUserSignedUpMessage() {
        Toast.makeText(this, "Usuario resgitrado correctamente.", Toast.LENGTH_SHORT).show();
    }

    public void showIncorrectLogInMessage() {
        Toast.makeText(this, "Usuario y/o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
    }
}