package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ColorFondo extends AppCompatActivity {

    private SharedPreferences preferencias;
    private CheckBox[] checkBoxSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_fondo);

        Button botonVolver = findViewById(R.id.btnVolverConfig);
        botonVolver.setBackgroundColor(getResources().getColor(R.color.grey));

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorActual = obtenerColorActual();
                guardarColorSeleccionado(colorActual);
                Intent intent = new Intent(ColorFondo.this, Configuracion.class);
                startActivity(intent);
                finish();
            }
        });

        preferencias = getSharedPreferences("preferencia", MODE_PRIVATE);

        checkBoxSeleccionado = new CheckBox[]{
                findViewById(R.id.cbGris),
                findViewById(R.id.cbRojo),
                findViewById(R.id.cbVerde),
                findViewById(R.id.cbAzul),
                findViewById(R.id.cbBlanco)
        };

        for (CheckBox checkBox : checkBoxSeleccionado) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        for (CheckBox cb : checkBoxSeleccionado) {
                            if (cb != buttonView) {
                                cb.setChecked(false);
                            }
                        }
                        int color = obtenerColorSeleccionado(buttonView);
                        guardarColorSeleccionado(color);
                        aplicarColor(color);
                    }
                }
            });
        }
        ActivityHeredar.agregarActivity(this);

        int colorGuardado = preferencias.getInt("colorSeleccionado", Color.WHITE);
        ActivityHeredar.aplicarColorEnTodas(colorGuardado);

    }

    private int obtenerColorSeleccionado(CompoundButton buttonView) {
        int color = Color.WHITE;
        if (buttonView.getId() == R.id.cbGris) {
            color = Color.GRAY;
        } else if (buttonView.getId() == R.id.cbRojo) {
            color = Color.RED;
        } else if (buttonView.getId() == R.id.cbVerde) {
            color = Color.GREEN;
        } else if (buttonView.getId() == R.id.cbAzul) {
            color = Color.CYAN;
        } else if (buttonView.getId() == R.id.cbBlanco) {
            color = Color.WHITE;
        }
        return color;
    }

    private void guardarColorSeleccionado(int color) {
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt("colorSeleccionado", color);
        editor.apply();
    }

    private void aplicarColor( int color) {
        getWindow().getDecorView().setBackgroundColor(color);
    }

    private int obtenerColorActual() {
        int colorActual = Color.WHITE; // color predeterminado si no se puede obtener el color actual
        Drawable background = getWindow().getDecorView().getBackground();
        if (background instanceof ColorDrawable) {
            colorActual = ((ColorDrawable) background).getColor();
        }
        return colorActual;
    }
}