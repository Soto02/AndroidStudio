package com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombreEdit = findViewById(R.id.introNombre);
        EditText contrasenaEdit = findViewById(R.id.introContrasena);
        Button login = (Button) findViewById(R.id.btnIniciarSesion);

        login.setBackgroundColor(getResources().getColor(R.color.green));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = "Alejandro";
                String contrasena = "Soto";

                nombre = nombreEdit.getText().toString();
                contrasena = contrasenaEdit.getText().toString();

                if(esValido(nombre, contrasena)) {
                    String action;
                    Intent intent = new Intent(MainActivity.this, NewActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                }
            }
        });

        ActivityHeredar.agregarActivity(this);
        SharedPreferences preferencias = getSharedPreferences("preferencia", MODE_PRIVATE);
        int colorGuardado = preferencias.getInt("colorSeleccionado", Color.WHITE);
        ActivityHeredar.aplicarColorEnTodas(colorGuardado);
    }
    private boolean esValido(String nombre, String contraseña) {
        if(nombre.equals("Alejandro") && contraseña.equals("Soto")) {
            return true;
        } else {
            return false;
        }
    }
}

