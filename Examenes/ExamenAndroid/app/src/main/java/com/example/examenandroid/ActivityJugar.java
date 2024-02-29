package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import Modelo.Servicio;

public class ActivityJugar extends AppCompatActivity {

    TextView tvPalabras;
    Button botonContinuar;
    Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        Button botonVolver = (Button) findViewById(R.id.btnVolverJugar);
        botonVolver.setBackgroundColor(getResources().getColor(R.color.blue));

        botonContinuar = (Button) findViewById(R.id.btnContinuar);
        botonContinuar.setBackgroundColor(getResources().getColor(R.color.blue));

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityJugar.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityJugar.this, ActivityEscribirPalabras.class);
                startActivity(intent);
                finish();
            }
        });

        servicio = new Servicio(this);
        tvPalabras = findViewById(R.id.tvPalabras);
        tvPalabras.setText("");
        String texto = "";

        /*for(int i = 0; i<servicio.getServicioPalabras().size(); i++) {
            texto +=servicio.getServicioPalabras().get(i).getPalabras();
        }*/
    }

}