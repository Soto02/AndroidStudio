package com.example.proyectaso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import Pojo.Persona;
import Pojo.Servicio;

public class ActivityInfo extends AppCompatActivity {

    private TextView txtId, txtNombre, txtEdad;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Servicio.getInstance();
        persona = (Persona) getIntent().getSerializableExtra("persona");

        txtId = findViewById(R.id.txtIdInfo);
        txtNombre = findViewById(R.id.txtNombreInfo);
        txtEdad = findViewById(R.id.txtEdadInfo);

        txtId.setText(persona.getId() + "");
        txtNombre.setText(persona.getNombre() + "");
        txtEdad.setText(persona.getEdad() + "");

        Button btnAtras = (Button) findViewById(R.id.btnPatra);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearVentanaModal().show();
            }
        });
    }

    public AlertDialog.Builder crearVentanaModal() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Ventana confirmacion");
        dialogo.setMessage("Desea salir?");
        dialogo.setPositiveButton("si?", ((dialog, which) -> {
            Intent i = new Intent(ActivityInfo.this, MainActivity.class);
            startActivity(i);
        }));
        dialogo.setNegativeButton("no?", null);
        return dialogo;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        crearVentanaModal().show();
    }

    public void clickRb(View v) {
        RadioButton rbpulsado = (RadioButton) v;

        if (rbpulsado.getId() == R.id.rbTodos) {
            SharedPreferences preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("lista", "todos");
            editor.commit();
        } else {
            SharedPreferences preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("lista", "cinco");
            editor.commit();
        }
    }
}