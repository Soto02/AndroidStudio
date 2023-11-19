package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PaginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ImageView logo = findViewById(R.id.logoPizza);
        logo.setImageResource(R.drawable.pizzalogo);

        Button botonPedir = (Button) findViewById(R.id.btnElegirPizza);
        botonPedir.setBackgroundColor(getResources().getColor(R.color.red));

        Button botonConfigurar = (Button) findViewById(R.id.btnConfiguracion);
        botonConfigurar.setBackgroundColor(getResources().getColor(R.color.white));

        Button botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setBackgroundColor(getResources().getColor(R.color.green));

        botonPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(PaginaPrincipal.this, PedirPizza.class);
                startActivity(intent);
                finish();
            }
        });

        botonConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(PaginaPrincipal.this, Configuracion.class);
                startActivity(intent);
                finish();
            }
        });

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(PaginaPrincipal.this, IniciarSesion.class);
                startActivity(intent);
                finish();
            }
        });

        botonConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(PaginaPrincipal.this, Configuracion.class);
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











/*
Button botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(NewActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
 */