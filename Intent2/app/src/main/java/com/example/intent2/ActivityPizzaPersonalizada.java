package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

public class ActivityPizzaPersonalizada extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_personalizada);

        ActivityHeredar.agregarActivity(this);
        SharedPreferences preferencias = getSharedPreferences("preferencia", MODE_PRIVATE);
        int colorGuardado = preferencias.getInt("colorSeleccionado", Color.WHITE);
        ActivityHeredar.aplicarColorEnTodas(colorGuardado);
    }
}