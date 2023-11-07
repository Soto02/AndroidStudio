package com.example.intent2;

import static com.example.intent2.R.id.btnIniciarSesion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {

    EditText nombreEdit, contrasenaEdit;
    Button login, registrar, config;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEdit = (EditText) findViewById(R.id.introNombre);
        contrasenaEdit = (EditText) findViewById(R.id.introContrasena);
        login = (Button) findViewById(R.id.btnIniciarSesion);
        registrar = (Button) findViewById(R.id.btnRegistrarse);
        config = (Button) findViewById(R.id.btnConf);

        preferencias = getSharedPreferences("user", MODE_PRIVATE);

        login.setBackgroundColor(getResources().getColor(R.color.grey));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreGuardado = preferencias.getString("nombre", "");
                String contrasenaGuardada = preferencias.getString("contrasena", "");

                String nombre = nombreEdit.getText().toString();
                String contrasena = contrasenaEdit.getText().toString();

                if(nombre.equals(nombreGuardado) && contrasena.equals(contrasenaGuardada)) {
                    Toast.makeText(IniciarSesion.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT);
                    Intent intent = new Intent(IniciarSesion.this, PaginaPrincipal.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(IniciarSesion.this, "Ha habido un error", Toast.LENGTH_SHORT);
                }

            }
        });

        registrar.setBackgroundColor(getResources().getColor(R.color.grey));
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEdit.getText().toString();
                String contrasena = contrasenaEdit.getText().toString();

                if(nombre.isEmpty() && contrasena.isEmpty()) {
                    Toast.makeText(IniciarSesion.this, "Tiene que registrarse", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("nombre", nombre);
                    editor.putString("contrasena", contrasena);
                    editor.apply();

                    Toast.makeText(IniciarSesion.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                }


            }
        });

        config.setBackgroundColor(getResources().getColor(R.color.grey));
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IniciarSesion.this, Configuracion.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
