package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Modelo.Servicio;
import Modelo.Usuario;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener  {
    Button btnRealizarPedido, btnAtras, btnConfiguracion, btnLLamar;
    TextView textoBienvenida, textoWeb;
    String nombreUsuario;
    ConstraintLayout layoutDeAqui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnRealizarPedido =  findViewById(R.id.btnPedirPizza);
        textoBienvenida = findViewById(R.id.textoBinevnida);
        btnAtras = findViewById(R.id.btnAtras);
        btnConfiguracion = findViewById(R.id.btnConfiguracion);
        btnLLamar = findViewById(R.id.btnLLamar);
        textoWeb = findViewById(R.id.textoWeb);
        if (getIntent().getStringExtra("usuario").equals("") == false){
            nombreUsuario = getIntent().getStringExtra("usuario");
            textoBienvenida.setText("Bienvenido/a " + nombreUsuario);
        }else{
            textoBienvenida.setText("Gracias por elegirnos");
        }

        layoutDeAqui = findViewById(R.id.layout3);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.white){
            btnRealizarPedido.setTextColor(Color.WHITE);
            btnRealizarPedido.setBackgroundColor(Color.rgb(200, 0, 0));
            textoBienvenida.setTextColor(Color.BLACK);
            btnConfiguracion.setTextColor(Color.WHITE);
            btnConfiguracion.setBackgroundColor(Color.rgb(200, 0, 0));
            btnAtras.setTextColor(Color.WHITE);
            btnAtras.setBackgroundColor(Color.rgb(200, 0, 0));
            btnLLamar.setTextColor(Color.WHITE);
            btnLLamar.setBackgroundColor(Color.rgb(200, 0, 0));
            textoWeb.setTextColor(Color.BLACK);
        }else if(ActivityAHeredar.colorFondo == android.R.color.black){
            btnRealizarPedido.setTextColor(Color.WHITE);
            btnRealizarPedido.setBackgroundColor(Color.rgb(200, 0, 0));
            textoBienvenida.setTextColor(Color.WHITE);
            btnConfiguracion.setTextColor(Color.WHITE);
            btnConfiguracion.setBackgroundColor(Color.rgb(200, 0, 0));
            btnAtras.setTextColor(Color.WHITE);
            btnAtras.setBackgroundColor(Color.rgb(200, 0, 0));
            btnLLamar.setTextColor(Color.WHITE);
            btnLLamar.setBackgroundColor(Color.rgb(200, 0, 0));
            textoWeb.setTextColor(Color.WHITE);
        }else{
            btnRealizarPedido.setTextColor(Color.WHITE);
            btnRealizarPedido.setBackgroundColor(Color.BLACK);
            textoBienvenida.setTextColor(Color.BLACK);
            btnConfiguracion.setTextColor(Color.WHITE);
            btnConfiguracion.setBackgroundColor(Color.BLACK);
            btnAtras.setTextColor(Color.WHITE);
            btnAtras.setBackgroundColor(Color.BLACK);
            btnLLamar.setTextColor(Color.WHITE);
            btnLLamar.setBackgroundColor(Color.BLACK);
            textoWeb.setTextColor(Color.BLACK);
        }

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == textoWeb.getId()) {
            Uri uri = Uri.parse("https://www.dominospizza.es/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        if(v.getId() == btnLLamar.getId()) {
            Uri number = Uri.parse("tel:647 28 33 23");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        }

        if(v.getId() == btnRealizarPedido.getId()){

            Intent i = new Intent(ActivityMenu.this, ActivityElegirTipoPizza.class);
            startActivity(i);
            finish();

        }
        if(v.getId() == btnConfiguracion.getId()){

            Intent i = new Intent(ActivityMenu.this, ActivityConfiguracion.class);
            startActivity(i);
            finish();

        }

        if(v.getId() == btnAtras.getId()){
            Intent i = new Intent(ActivityMenu.this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    @Override
    public  void onBackPressed(){



    }
}