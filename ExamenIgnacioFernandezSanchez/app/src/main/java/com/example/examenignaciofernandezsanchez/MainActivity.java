package com.example.examenignaciofernandezsanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examenignaciofernandezsanchez.dbHelpers.DbHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnJugar;
    private Button btnPuntuaciones;
    private Button btnConfigurar;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJugar = findViewById(R.id.btnJugar);
        btnPuntuaciones = findViewById(R.id.btnPuntuaciones);
        btnConfigurar = findViewById(R.id.btnConfigurar);
        btnSalir = findViewById(R.id.btnSalir);
    }

    public void irPantallaJugar(View view) {
        startActivity(new Intent(this, PantallaJugar.class));
    }

    public void verPuntuacion(View view) {
        startActivity(new Intent(this, PantallaVerPuntuacion.class));
    }

    public void salir(View view) {
        finish();
    }
}