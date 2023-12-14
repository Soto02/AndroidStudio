package com.example.pizzeria;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Modelo.Servicio;
import Modelo.Usuario;

public class ActivityRegistrarse extends AppCompatActivity implements View.OnClickListener{
    Button btnRegistrar;
    EditText textBoxUsuario, textBoxContraseña;
    Servicio servicio;
    TextView textViewUsuario, textViewContraseña;
    ConstraintLayout layoutDeAqui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        btnRegistrar  = findViewById(R.id.btnRegistrar);
        textBoxUsuario = findViewById(R.id.textBoxUsuario);
        textBoxContraseña = findViewById(R.id.textBoxContraseña);
        textViewUsuario = findViewById(R.id.textViewUsuario);
        textViewContraseña = findViewById(R.id.textViewContraseña);
        servicio = new Servicio(this);
        layoutDeAqui = findViewById(R.id.layout5);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.white){
            btnRegistrar.setTextColor(Color.WHITE);
            btnRegistrar.setBackgroundColor(Color.rgb(200, 0, 0));

            textBoxUsuario.setTextColor(Color.BLACK);
            textBoxContraseña.setTextColor(Color.BLACK);

            textViewUsuario.setTextColor(Color.BLACK);
            textViewContraseña.setTextColor(Color.BLACK);

        }else if(ActivityAHeredar.colorFondo == android.R.color.black){
            btnRegistrar.setTextColor(Color.WHITE);
            btnRegistrar.setBackgroundColor(Color.rgb(200, 0, 0));

            textBoxUsuario.setTextColor(Color.WHITE);
            textBoxContraseña.setTextColor(Color.WHITE);

            textViewUsuario.setTextColor(Color.WHITE);
            textViewContraseña.setTextColor(Color.WHITE);
        }else{
            btnRegistrar.setTextColor(Color.WHITE);
            btnRegistrar.setBackgroundColor(Color.BLACK);

            textBoxUsuario.setTextColor(Color.BLACK);
            textBoxContraseña.setTextColor(Color.BLACK);

            textViewUsuario.setTextColor(Color.BLACK);
            textViewContraseña.setTextColor(Color.BLACK);
        }

    }

    @Override
    public void onClick(View v) {



        if(v.getId() == btnRegistrar.getId()){

            if(textBoxUsuario.getText().length() >= 3 && textBoxContraseña.getText().length() >= 3){

                servicio.añadirUsuario(new Usuario(String.valueOf(textBoxUsuario.getText()),String.valueOf(textBoxContraseña.getText()) ));
                Toast t = Toast.makeText(getApplicationContext(), "Se ha registrado correctamente", LENGTH_SHORT);
                t.show();

                boolean flag = false;
                for(Usuario usuario: servicio.getUsuarios()){

                    if(usuario.getUsuario().equals(textBoxUsuario.getText().toString()) && usuario.getContraseña().equals(textBoxContraseña.getText().toString())){

                        flag = true;

                        servicio.añadirAlHistorial(usuario);

                        Intent i = new Intent(ActivityRegistrarse.this, ActivityMenu.class);

                        i.putExtra("usuario", usuario.getUsuario());

                        startActivity(i);
                        finish();

                    }

                }
                if(flag == false){
                    textBoxUsuario.setText("");
                    textBoxContraseña.setText("");
                    AlertDialog.Builder dialogo = crearDialogo();
                    dialogo.show();
                }
            }else{
                AlertDialog.Builder dialogo = crearDialogo();
                dialogo.show();
            }


        }


    }

    public AlertDialog.Builder crearDialogo(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("ERROR");
        dialogo1.setMessage("Debes escribir al menos 3 caracteres en cada campo");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {


            }
        });


        return dialogo1;
    }

    @Override
    public  void onBackPressed(){

        Intent i = new Intent(ActivityRegistrarse.this, MainActivity.class);

        startActivity(i);
        finish();

    }
}