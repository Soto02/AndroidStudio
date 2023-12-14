package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PedirPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_pizza);

        ImageView logo = findViewById(R.id.logoPizza);
        logo.setImageResource(R.drawable.pizzalogo);

        Button botonVolver = (Button) findViewById(R.id.btnVolver);
        botonVolver.setBackgroundColor(getResources().getColor(R.color.grey));

        Button botonPersonalizada = (Button) findViewById(R.id.btnPizzaPersonalizada);
        botonPersonalizada.setBackgroundColor(getResources().getColor(R.color.red));

        Button botonPasoPaso = (Button) findViewById(R.id.btnPasoAPaso);
        botonPasoPaso.setBackgroundColor(getResources().getColor(R.color.white));

        Button botonUltimoPedido = (Button) findViewById(R.id.btnUltimoPedido);
        botonUltimoPedido.setBackgroundColor(getResources().getColor(R.color.green));

        botonPersonalizada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PedirPizza.this, ActivityPizzaPersonalizada.class);
                startActivity(intent);
                finish();
            }
        });

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action;
                Intent intent = new Intent(PedirPizza.this, PaginaPrincipal.class);
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