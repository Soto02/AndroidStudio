package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PaginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ImageView logo = findViewById(R.id.logoConfig);
        logo.setImageResource(R.drawable.pizzalogo);

        Button botonPedir = (Button) findViewById(R.id.btnColorFondo);
        botonPedir.setBackgroundColor(getResources().getColor(R.color.red));

        Button botonConfigurar = (Button) findViewById(R.id.btnPasoAPaso);
        botonConfigurar.setBackgroundColor(getResources().getColor(R.color.white));

        Button botonSalir = (Button) findViewById(R.id.btnUltimoPedido);
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