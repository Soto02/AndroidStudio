package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Configuracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        ImageView logo = findViewById(R.id.logoConfiguracion);
        logo.setImageResource(R.drawable.configuracionlogo);

        Button botonElegir = (Button) findViewById(R.id.btnColor);
        botonElegir.setBackgroundColor(getResources().getColor(R.color.grey));

        Button botonGuardar = (Button) findViewById(R.id.btnGuardar);
        botonGuardar.setBackgroundColor(getResources().getColor(R.color.grey));

        Button botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setBackgroundColor(getResources().getColor(R.color.grey));

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(Configuracion.this, IniciarSesion.class);
                startActivity(intent);
                finish();
            }
        });

        botonElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action;
                Intent intent = new Intent(Configuracion.this, ColorFondo.class);
                startActivity(intent);
                finish();
            }
        });

        ActivityHeredar.agregarActivity(this);
        SharedPreferences preferencias = getSharedPreferences("preferencia", MODE_PRIVATE);
        int colorGuardado = preferencias.getInt("colorSeleccionado", Color.WHITE);
        ActivityHeredar.aplicarColorEnTodas(colorGuardado);

    }
}