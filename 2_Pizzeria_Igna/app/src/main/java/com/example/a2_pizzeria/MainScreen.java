package com.example.a2_pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;

import com.example.a2_pizzeria.databinding.ActivityMainBinding;
import com.example.a2_pizzeria.databinding.ActivityMainScreenBinding;

public class MainScreen extends AppCompatActivity {

    private SharedPreferences currentUserPreferences;
    private ActivityMainScreenBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.txtLogOut.setVisibility(View.INVISIBLE);

        currentUserPreferences = getSharedPreferences("currentUser", Context.MODE_PRIVATE);
        String username = currentUserPreferences.getString("username", null);
        binding.txtUsername.setText(username);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.setScreenBackgroundColor(binding.getRoot());
    }

    public void visitWebsite(View view) {
        String url = "http://mammamiapizzeria.es";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void toggleLogOut (View view) {
        if (binding.txtLogOut.getVisibility() == View.VISIBLE) {
            binding.txtLogOut.setVisibility(View.INVISIBLE);
        }
        else {
            binding.txtLogOut.setVisibility(View.VISIBLE);
        }
    }

    public void openSettingsScreen(View view) {
        startActivity(new Intent(this, SettingsScreen.class));
    }

    public void openOrderScreen(View view) {
        startActivity(new Intent(this, OrderScreen.class));
    }

    public void logOut(View view) {
        finish();
    }

    public void exit(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Salir");
        alertDialogBuilder.setMessage("¿Desea salir?");

        alertDialogBuilder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });

        alertDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}