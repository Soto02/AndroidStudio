package com.example.examenluis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PantallaRespuesta extends AppCompatActivity {

    private EditText setPalabras;
    private TextView txtPalabrasAcertadas, txtAciertos;
    private List<String> palabras;
    private List<String> palabrasAcertadas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_respuesta);

        setPalabras = findViewById(R.id.txtInsertarPalabra);
        txtPalabrasAcertadas = findViewById(R.id.txtRespuesta);
        txtAciertos = findViewById(R.id.txtAciertos);

        SharedPreferences palabrasPreferencias = getSharedPreferences("palabras", Context.MODE_PRIVATE);
        palabras = new ArrayList<>(palabrasPreferencias.getStringSet("palabras", null));

        Button btnSalir = (Button) findViewById(R.id.btnVolverInicio);
        Button btnComprobar = (Button) findViewById(R.id.btnComprobarPalabra);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaRespuesta.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarPalabras(v);
            }
        });

    }

    public void comprobarPalabras(View view) {
        String palabra = String.valueOf(setPalabras.getText());
        int aciertos = 0;

        if(!palabra.isEmpty()) {
            if(palabras.contains(palabra) && !palabrasAcertadas.contains(palabra)) {
                palabrasAcertadas.add(palabra);
                txtPalabrasAcertadas.setText(txtPalabrasAcertadas.getText() + ", " + palabra);
                aciertos++;
                txtAciertos.setText("Aciertos: " + aciertos);
            }
        }
    }
}