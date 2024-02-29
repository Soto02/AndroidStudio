package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityConfiguracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        Button botonDificultad = (Button) findViewById(R.id.btnDificultad);
        botonDificultad.setBackgroundColor(getResources().getColor(R.color.blue));

        Button botonListar = (Button) findViewById(R.id.btnListar);
        botonListar.setBackgroundColor(getResources().getColor(R.color.blue));

        Button botonVolver = (Button) findViewById(R.id.btnVolverConfig);
        botonVolver.setBackgroundColor(getResources().getColor(R.color.blue));

        botonDificultad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent =new Intent(MainActivity.this, ActivityJugar.class);
                //startActivity(intent);
                //finish();
            }
        });
        botonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, ActivityConfiguracion.class);
                //startActivity(intent);
                //finish();
            }
        });
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityConfiguracion.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}