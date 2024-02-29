package com.example.examenrecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class PantallaConfiguracion extends AppCompatActivity {

    private SharedPreferences preferences;
    private Button btnVolver;
    private CheckBox cbUno, cbDos, cbTres;
    private CheckBox[]  cbSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_configuracion);

        btnVolver = (Button) findViewById(R.id.btnVolverConfig);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaConfiguracion.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cbUno = findViewById(R.id.cbUno);
        cbDos = findViewById(R.id.cbDos);
        cbTres = findViewById(R.id.cbTres);

        cbUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { elegirUno(cbUno); }
        });
        cbDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirUno(cbDos);
            }
        });
        cbTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirUno(cbTres);
            }
        });

        preferences = getSharedPreferences("numCitas", MODE_PRIVATE);

        cbSeleccionado = new CheckBox[] {
                cbUno,
                cbDos,
                cbTres
        };

        for(CheckBox checkBox : cbSeleccionado) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(cbUno.isChecked()) {
                        guardarNumeroCitas(0);
                    } else if(cbDos.isChecked()) {
                        guardarNumeroCitas(1);
                    } else if(cbTres.isChecked()) {
                        guardarNumeroCitas(2);
                    }
                }
            });
        }
    }

    private void guardarNumeroCitas(int cita) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("cita", cita);
        editor.apply();
    }

    private void elegirUno(CheckBox selectedCheckBox) {
        if(selectedCheckBox != cbUno) {
            cbUno.setChecked(false);
        }
        if(selectedCheckBox != cbDos) {
            cbDos.setChecked(false);
        }
        if(selectedCheckBox != cbTres) {
            cbTres.setChecked(false);
        }
    }

}