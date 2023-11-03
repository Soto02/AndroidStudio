package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Configuracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        ImageView logo = findViewById(R.id.logoConfig);
        logo.setImageResource(R.drawable.configuracionlogo);

        Button botonElegir = (Button) findViewById(R.id.btnColorFondo);
        botonElegir.setBackgroundColor(getResources().getColor(R.color.grey));

        Button botonGuardar = (Button) findViewById(R.id.btnGuardar);
        botonGuardar.setBackgroundColor(getResources().getColor(R.color.grey));

        Button botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setBackgroundColor(getResources().getColor(R.color.grey));

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent intent = new Intent(Configuracion.this, PaginaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}