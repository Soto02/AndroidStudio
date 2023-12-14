package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Modelo.Servicio;

public class ActivityElegirTipoPizza extends AppCompatActivity implements View.OnClickListener{
    Button btnNuestrasPizzas, btnRepetirUltimoPedido, btnCreaPizza;
    Servicio servicio;
    ConstraintLayout layoutDeAqui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tipo_pizza);
        btnNuestrasPizzas = findViewById(R.id.btnNuestrasPizzas);
        btnRepetirUltimoPedido = findViewById(R.id.btnUltPizza);
        btnCreaPizza = findViewById(R.id.btnCreaPizza);
        servicio = new Servicio(this);
        layoutDeAqui = findViewById(R.id.layout8);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.black){

            btnCreaPizza.setTextColor(Color.WHITE);
            btnCreaPizza.setBackgroundColor(Color.rgb(200, 0, 0));

            btnNuestrasPizzas.setTextColor(Color.WHITE);
            btnNuestrasPizzas.setBackgroundColor(Color.rgb(200, 0, 0));

            btnRepetirUltimoPedido.setTextColor(Color.WHITE);
            btnRepetirUltimoPedido.setBackgroundColor(Color.rgb(200, 0, 0));

        }else if(ActivityAHeredar.colorFondo == android.R.color.white){

            btnCreaPizza.setTextColor(Color.WHITE);
            btnCreaPizza.setBackgroundColor(Color.rgb(200, 0, 0));

            btnNuestrasPizzas.setTextColor(Color.WHITE);
            btnNuestrasPizzas.setBackgroundColor(Color.rgb(200, 0, 0));

            btnRepetirUltimoPedido.setTextColor(Color.WHITE);
            btnRepetirUltimoPedido.setBackgroundColor(Color.rgb(200, 0, 0));

        }else{

            btnCreaPizza.setTextColor(Color.WHITE);
            btnCreaPizza.setBackgroundColor(Color.BLACK);

            btnNuestrasPizzas.setTextColor(Color.WHITE);
            btnNuestrasPizzas.setBackgroundColor(Color.BLACK);

            btnRepetirUltimoPedido.setTextColor(Color.WHITE);
            btnRepetirUltimoPedido.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == btnNuestrasPizzas.getId()){

            Intent i = new Intent(ActivityElegirTipoPizza.this, ActivityNuestrasPizzas.class);
            startActivity(i);
            finish();

        }

        if(v.getId() == btnRepetirUltimoPedido.getId()){
            Intent i = new Intent(ActivityElegirTipoPizza.this, ActivityFinalizarPedido.class);
            i.putExtra("pedido", "ultimo");
            startActivity(i);
            finish();

        }

        if(v.getId() == btnCreaPizza.getId()){
            Intent i = new Intent(ActivityElegirTipoPizza.this, AcrivityPizzaPersonalizada.class);
            startActivity(i);
            finish();
        }

    }

    @Override
    public void onBackPressed(){

        Intent i = new Intent(ActivityElegirTipoPizza.this, ActivityMenu.class);
        i.putExtra("usuario", servicio.obtenerUltimoUsuarioIniciado().getUsuario());
        startActivity(i);
        finish();

    }
}