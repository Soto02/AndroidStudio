package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

public class ActivityPasoPaso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso_paso);

        ActivityHeredar.agregarActivity(this);
        SharedPreferences preferencias = getSharedPreferences("preferencia", MODE_PRIVATE);
        int colorGuardado = preferencias.getInt("colorSeleccionado", Color.WHITE);
        ActivityHeredar.aplicarColorEnTodas(colorGuardado);
    }
}