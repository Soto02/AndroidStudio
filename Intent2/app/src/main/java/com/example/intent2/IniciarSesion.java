package com.example.intent2;

import static com.example.intent2.R.id.btnIniciarSesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IniciarSesion extends AppCompatActivity {

    EditText nombreEdit, contrasenaEdit;
    Button login, registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEdit = (EditText) findViewById(R.id.introNombre);
        contrasenaEdit = (EditText) findViewById(R.id.introContrasena);
        login = (Button) findViewById(R.id.btnIniciarSesion);
        registrar = (Button) findViewById(R.id.btnRegistrarse);

        login.setBackgroundColor(getResources().getColor(R.color.grey));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPreferencias();
                Intent intent = new Intent(IniciarSesion.this, PaginaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        registrar.setBackgroundColor(getResources().getColor(R.color.grey));
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPreferencias();
            }
        });
    }
    private void guardarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user = nombreEdit.getText().toString();
        String pass = contrasenaEdit.getText().toString();

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user", user);
        editor.putString("pass", pass);

        editor.commit();
    }
    private void cargarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String user = preferencias.getString("user", "No existe");
        String pass = preferencias.getString("pass", "No existe");
    }

}