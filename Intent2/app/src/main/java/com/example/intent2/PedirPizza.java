package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PedirPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_pizza);

        ImageView logo = findViewById(R.id.logoConfig);
        logo.setImageResource(R.drawable.pizzalogo);

        Button botonVolver = (Button) findViewById(R.id.btnVolver);

        Button botonPersonalizada = (Button) findViewById(R.id.btnColorFondo);
        botonPersonalizada.setBackgroundColor(getResources().getColor(R.color.red));

        Button botonPasoPaso = (Button) findViewById(R.id.btnPasoAPaso);
        botonPasoPaso.setBackgroundColor(getResources().getColor(R.color.white));

        Button botonUltimoPedido = (Button) findViewById(R.id.btnUltimoPedido);
        botonUltimoPedido.setBackgroundColor(getResources().getColor(R.color.green));

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action;
                Intent intent = new Intent(PedirPizza.this, PaginaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

    }
}