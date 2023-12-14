package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pizzeria.databinding.ActivityMainBinding;

import Modelo.AdaptadorBD;
import Modelo.Servicio;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ConstraintLayout layoutDeAqui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        //SharedPreferences.Editor editor = getSharedPreferences("ultimoColor", MODE_PRIVATE).edit();
        //editor.clear().apply();

        try {
            SharedPreferences prefe = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);

            if(prefe.getString("ultimoColor","Blanco").equals("Rojo")){
                //layoutDeAqui.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_light));
                ActivityAHeredar.colorFondo = android.R.color.holo_red_dark;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
            }
            if(prefe.getString("ultimoColor","Blanco").equals("Verde")){
                ActivityAHeredar.colorFondo = android.R.color.holo_green_dark;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
            }
            if(prefe.getString("ultimoColor","Blanco").equals("Azul")){
                ActivityAHeredar.colorFondo = android.R.color.holo_blue_dark;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
            }
            if(prefe.getString("ultimoColor","Blanco").equals("Negro")){
                ActivityAHeredar.colorFondo = android.R.color.black;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
            }
            if(prefe.getString("ultimoColor","Blanco").equals("Morado")){
                ActivityAHeredar.colorFondo = android.R.color.holo_purple;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
            }

            //if(prefe.getString("ultimoColor","Negro").equals("Naranja")){
               // ActivityAHeredar.colorFondo = android.R.color.holo_orange_dark;
               // ActivityAHeredar.cambiaColor(layoutDeAqui, this);
            //}
        }catch (Exception e){

        }
        Intent i = new Intent(MainActivity.this, ActivityInicioSesion.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {




    }
}