package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonJugar = (Button) findViewById(R.id.btnJugar);
        botonJugar.setBackgroundColor(getResources().getColor(R.color.blue));

        Button botonPuntuacion = (Button) findViewById(R.id.btnPuntuacion);
        botonPuntuacion.setBackgroundColor(getResources().getColor(R.color.blue));

        Button botonConfiguracion = (Button) findViewById(R.id.btnConfiguracion);
        botonConfiguracion.setBackgroundColor(getResources().getColor(R.color.blue));

        Button botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setBackgroundColor(getResources().getColor(R.color.blue));

        botonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ActivityJugar.class);
                startActivity(intent);
                finish();
            }
        });
        botonConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityConfiguracion.class);
                startActivity(intent);
                finish();
            }
        });
        botonPuntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityPuntuacion.class);
                startActivity(intent);
                finish();
            }
        });
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeContextMenu();
                finish();
            }
        });
    }
}