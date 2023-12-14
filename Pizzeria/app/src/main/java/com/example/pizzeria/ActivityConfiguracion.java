package com.example.pizzeria;

import androidx.annotation.XmlRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.RelativeLayout;
import android.widget.TextView;

import org.intellij.lang.annotations.Identifier;

import java.util.ArrayList;

import Modelo.Servicio;

public class ActivityConfiguracion extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout layoutDeAqui;
    RelativeLayout layoutDeLaLista;
    ArrayList arrayColores;
    Servicio servicio;
    TextView textoSeleccionaFondo;
    RecyclerView mRecyclerView;
    MyAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        textoSeleccionaFondo = findViewById(R.id.textoSeleccionaFondo);
        servicio = new Servicio(this);
        arrayColores = new ArrayList<>();
        arrayColores.add("Rojo");
        arrayColores.add("Azul");
        arrayColores.add("Verde");
        arrayColores.add("Blanco");
        arrayColores.add("Morado");
        arrayColores.add("Negro");




        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        /*
         * Si la colección de datos tiene un tamaño fijo utiliza:
         *  mRecyclerView.setHasFixedSize(true);
         *  para mejorar el rendimiento
         * */

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(this);


        //Precarga de datos de ejemplo
        for (int i = 0; i < arrayColores.size(); i++) {
            mAdapter.add(new Item(getResources().getDrawable(R.mipmap.ic_launcher), arrayColores.get(i).toString()));
        }
        mRecyclerView.setAdapter(mAdapter);


        layoutDeAqui = findViewById(R.id.layout1);
        layoutDeLaLista = findViewById(R.id.relativeLayout);
        layoutDeAqui.setBackgroundColor(Color.DKGRAY);


        //layoutDeAqui.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        //Log.i("info", "" + android.R.color.holo_red_dark);
    }


    @Override
    public void onClick(View view) {


    }

    @Override
    public void onBackPressed(){

        Intent i = new Intent(ActivityConfiguracion.this, ActivityMenu.class);
        i.putExtra("usuario", servicio.obtenerUltimoUsuarioIniciado().getUsuario());
        startActivity(i);
        finish();

    }


}