package com.example.examenignaciofernandezsanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PantallaResultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultados);

        SharedPreferences numeroAciertosPreferences = getSharedPreferences("numeroAciertosActual", Context.MODE_PRIVATE);
        SharedPreferences maxNumeroAciertosPreferences = getSharedPreferences("maximoNumeroAciertos", Context.MODE_PRIVATE);

        int numAciertos = numeroAciertosPreferences.getInt("numeroAciertos", 0);

        TextView txtResultados = findViewById(R.id.txtResultados);
        txtResultados.setText("Ha acertado " + numAciertos + " palabras");

        int maxNumAciertos = maxNumeroAciertosPreferences.getInt("maximoNumeroAciertos", 0);

        if (numAciertos > maxNumAciertos) {
            txtResultados.setText(txtResultados.getText() + ". Enhorabuena, es su máxima puntuación");

            SharedPreferences.Editor editor = maxNumeroAciertosPreferences.edit();
            editor.putInt("maximoNumeroAciertos", numAciertos);
            editor.apply();
        }
    }

    public void volverInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}