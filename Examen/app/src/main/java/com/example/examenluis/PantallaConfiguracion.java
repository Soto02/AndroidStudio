package com.example.examenluis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class PantallaConfiguracion extends AppCompatActivity {

    private SharedPreferences preferences;
    private CheckBox cbFacil, cbMedio, cbDificil;
    private CheckBox[]  cbSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_configuracion);

        cbFacil = findViewById(R.id.cbFacil);
        cbMedio = findViewById(R.id.cbMedia);
        cbDificil = findViewById(R.id.cbDificil);

        cbFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckAllExcept(cbFacil);
            }
        });
        cbMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckAllExcept(cbMedio);
            }
        });
        cbDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckAllExcept(cbDificil);
            }
        });

        Button btnVolver = (Button) findViewById(R.id.btnVolverConfig);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaConfiguracion.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnListarPalabras = (Button) findViewById(R.id.btnListarPalabrasConfig);

        btnListarPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaConfiguracion.this, PantallaListadoPalabras.class);
                startActivity(intent);
                finish();
            }
        });

        //tabla de mi sharedPreferences
        preferences = getSharedPreferences("dificultad", MODE_PRIVATE);

        cbSeleccionado = new CheckBox[] {
                cbFacil,
                cbMedio,
                cbDificil
        };

        for(CheckBox checkBox : cbSeleccionado) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(cbFacil.isChecked()) {
                        guardarDificultad(0);
                    } else if(cbMedio.isChecked()) {
                        guardarDificultad(1);
                    } else if(cbDificil.isChecked()) {
                        guardarDificultad(2);
                    }
                }
            });
        }

    }

    private void guardarDificultad(int dificultad) {
        SharedPreferences.Editor editor = preferences.edit();
        //nombre de cada columna
        editor.putInt("dificultad", dificultad);
        editor.apply();
    }

    private void uncheckAllExcept(CheckBox selectedCheckBox) {
        if(selectedCheckBox != cbFacil) {
            cbFacil.setChecked(false);
        }
        if(selectedCheckBox != cbMedio) {
            cbMedio.setChecked(false);
        }
        if(selectedCheckBox != cbDificil) {
            cbDificil.setChecked(false);
        }
    }
}