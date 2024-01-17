package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.a2_pizzeria.databinding.ActivitySettingsScreenBinding;

import yuku.ambilwarna.AmbilWarnaDialog;

public class SettingsScreen extends AppCompatActivity {

    private SharedPreferences screensColorPreferences;
    private SharedPreferences favoritePreferences;
    private ActivitySettingsScreenBinding binding;

    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        binding = ActivitySettingsScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        screensColorPreferences = getSharedPreferences("screensColor", Context.MODE_PRIVATE);
        color = screensColorPreferences.getInt("color", 0);
        binding.getRoot().setBackgroundColor(color);

        favoritePreferences = getSharedPreferences("favorite", Context.MODE_PRIVATE);
        if (favoritePreferences.getAll().isEmpty()) {
            SharedPreferences.Editor editor = favoritePreferences.edit();
            editor.putBoolean("showFavorite", false);
            editor.apply();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.swFavorite.setChecked(favoritePreferences.getBoolean("showFavorite", false));
    }

    public void changeBackgroundColor(View view) {
        try {
            AmbilWarnaDialog colorDialog = new AmbilWarnaDialog(this, color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    SharedPreferences.Editor editor = screensColorPreferences.edit();
                    editor.putInt("color", color);
                    editor.apply();
                    MainActivity.setScreenBackgroundColor(binding.getRoot());
                }
            });

            colorDialog.show();
        } catch (Exception e) {
            Log.e("ErrorMessage", e.getStackTrace().toString());
        }
    }

    public void toggleShowFavorite(View view) {
        SharedPreferences.Editor editor = favoritePreferences.edit();
        editor.putBoolean("showFavorite", binding.swFavorite.isChecked());
        editor.apply();
    }

    public void goBack(View view) {
        finish();
    }
}