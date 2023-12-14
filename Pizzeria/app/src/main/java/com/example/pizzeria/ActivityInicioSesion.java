package com.example.pizzeria;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Modelo.AdaptadorBD;
import Modelo.Servicio;
import Modelo.Usuario;

public class ActivityInicioSesion extends AppCompatActivity implements View.OnClickListener{
    Servicio servicio;
    Button btnConfirmarInicio;
    EditText textBoxInicioUsuario, textBoxInicioContraseña;
    TextView textViewUsuario, textViewContraseña, tvIrRegistrarse;
    ConstraintLayout layoutDeAqui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);


        servicio =  new Servicio(this);
        btnConfirmarInicio = findViewById(R.id.btnConfirmarCuenta);
        textBoxInicioUsuario = findViewById(R.id.textBoxInicioUsuario);
        textBoxInicioContraseña = findViewById(R.id.textBoxInicioContraseña);
        textViewUsuario = findViewById(R.id.textViewInicioUsuario);
        textViewContraseña = findViewById(R.id.textViewInicioContraseña);
        tvIrRegistrarse = findViewById(R.id.tvIRregistrarse);
        layoutDeAqui = findViewById(R.id.layout4);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);



            if(ActivityAHeredar.colorFondo == android.R.color.white){

                textBoxInicioUsuario.setTextColor(Color.BLACK);
                textBoxInicioContraseña.setTextColor(Color.BLACK);
                textViewUsuario.setTextColor(Color.BLACK);
                textViewContraseña.setTextColor(Color.BLACK);
                btnConfirmarInicio.setBackgroundColor(Color.rgb(200, 0, 0));
                btnConfirmarInicio.setTextColor(Color.WHITE);
                tvIrRegistrarse.setTextColor(Color.BLACK);

            }else if(ActivityAHeredar.colorFondo == android.R.color.black){

                textBoxInicioUsuario.setTextColor(Color.WHITE);
                textBoxInicioContraseña.setTextColor(Color.WHITE);
                textViewUsuario.setTextColor(Color.WHITE);
                textViewContraseña.setTextColor(Color.WHITE);
                btnConfirmarInicio.setBackgroundColor(Color.rgb(200, 0, 0));
                btnConfirmarInicio.setTextColor(Color.WHITE);
                tvIrRegistrarse.setTextColor(Color.WHITE);

            }else{

                textBoxInicioUsuario.setTextColor(Color.BLACK);
                textBoxInicioContraseña.setTextColor(Color.BLACK);
                textViewUsuario.setTextColor(Color.BLACK);
                textViewContraseña.setTextColor(Color.BLACK);
                btnConfirmarInicio.setBackgroundColor(Color.BLACK);
                btnConfirmarInicio.setTextColor(Color.WHITE);
                tvIrRegistrarse.setTextColor(Color.BLACK);

            }


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == btnConfirmarInicio.getId() ){
            boolean flag = false;
            for(Usuario usuario: servicio.getUsuarios()){

                if(usuario.getUsuario().equals(textBoxInicioUsuario.getText().toString()) && usuario.getContraseña().equals(textBoxInicioContraseña.getText().toString())){

                    flag = true;

                    servicio.añadirAlHistorial(usuario);

                    Intent i = new Intent(ActivityInicioSesion.this, ActivityMenu.class);

                    i.putExtra("usuario", usuario.getUsuario());

                    startActivity(i);
                    finish();

                }

            }



            if(flag == false){
                textBoxInicioUsuario.setText("");
                textBoxInicioContraseña.setText("");
                AlertDialog.Builder dialogo = crearDialogo();
                dialogo.show();
            }

        }
        if(tvIrRegistrarse.getId() == v.getId()){
            Intent i = new Intent(ActivityInicioSesion.this, ActivityRegistrarse.class);
            startActivity(i);
            finish();
        }
    }
    public AlertDialog.Builder crearDialogo(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("ERROR");
        dialogo1.setMessage("Usuario o contraseña incorrectos");
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

        Intent i = new Intent(ActivityInicioSesion.this, MainActivity.class);

        startActivity(i);
        finish();

    }

}