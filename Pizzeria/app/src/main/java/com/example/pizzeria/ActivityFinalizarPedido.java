package com.example.pizzeria;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Modelo.Servicio;

public class ActivityFinalizarPedido extends AppCompatActivity implements View.OnClickListener {
    TextView textViewFinalizarPedido;
    Button btnConfirmarPedido;
    Servicio servicio;
    ConstraintLayout layoutDeAqui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_pedido);
        servicio = new Servicio(this);
        textViewFinalizarPedido = findViewById(R.id.textViewFinalizarPedido);
        textViewFinalizarPedido.setText("");
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);
        String texto = "";
        int precioTotal = 0;
        layoutDeAqui = findViewById(R.id.layout7);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.black){
            textViewFinalizarPedido.setTextColor(Color.WHITE);
            btnConfirmarPedido.setBackgroundColor(Color.rgb(200, 0, 0));
            btnConfirmarPedido.setTextColor(Color.WHITE);
        } else if(ActivityAHeredar.colorFondo == android.R.color.white) {
            textViewFinalizarPedido.setTextColor(Color.BLACK);
            btnConfirmarPedido.setBackgroundColor(Color.rgb(200, 0, 0));
            btnConfirmarPedido.setTextColor(Color.WHITE);
        }else{
            textViewFinalizarPedido.setTextColor(Color.BLACK);
            btnConfirmarPedido.setBackgroundColor(Color.BLACK);
            btnConfirmarPedido.setTextColor(Color.WHITE);
        }

        if(getIntent().getStringExtra("pedido").equals("normal")) {
            for (int i = 0; i < servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).size(); i++) {

                if (servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño().equals("Mediana")) {

                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getNombre() + "  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño() + "  \n";
                    texto += "Precio = 8\n";
                    precioTotal += 8;
                } else if (servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño().equals("Grande")) {
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getNombre() + "  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño() + "  \n";
                    texto += "Precio = 9\n";
                    precioTotal += 9;
                } else if (servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño().equals("Familiar")) {
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getNombre() + "  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño() + "  \n";
                    texto += "Precio = 10\n";
                    precioTotal += 10;
                }

            }
            texto += "---------------------------------\n";
            texto += "Precio total: " + precioTotal;

            textViewFinalizarPedido.setText(texto);
        }else if(getIntent().getStringExtra("pedido").equals("ultimo")){
            SharedPreferences prefe = getSharedPreferences("ultimoPedido"+servicio.obtenerUltimoUsuarioIniciado().getUsuario(), Context.MODE_PRIVATE);

            textViewFinalizarPedido.setText(prefe.getString("ultimoPedido"+servicio.obtenerUltimoUsuarioIniciado().getUsuario(),""));
        }else if(getIntent().getStringExtra("pedido").equals("pers")){

            for (int i = 0; i < servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).size(); i++) {

                if (servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño().equals("Mediana")) {

                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getNombre() + "  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño() + "  \n";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(0) + ",  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(1) + "\n";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(2) + " y ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(3) + "\n";
                    texto += "Precio = 8\n";
                    precioTotal += 8;
                } else if (servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño().equals("Grande")) {
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getNombre() + "  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño() + "  \n";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(0) + ",  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(1) + "\n";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(2) + " y ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(3) + "\n";
                    texto += "Precio = 9\n";
                    precioTotal += 9;
                } else if (servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño().equals("Familiar")) {
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getNombre() + "  ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getTamaño() + "  \n";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(0) + ", ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(1) + "\n";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(2) + " y ";
                    texto += servicio.getServicioPedido().get(servicio.obtenerUltimoIndice()).get(i).getIngredientes().get(3) + "\n";
                    texto += "Precio = 10\n";
                    precioTotal += 10;
                }

            }
            texto += "---------------------------------\n";
            texto += "Precio total: " + precioTotal;

            textViewFinalizarPedido.setText(texto);
        }

    }

    @Override
    public void onClick(View v) {

        if(btnConfirmarPedido.getId() == v.getId()){

           if(textViewFinalizarPedido.getText().equals("") == false){
               AlertDialog.Builder dialogo = crearDialogo();
               dialogo.show();
           }else{
               Intent a = new Intent(ActivityFinalizarPedido.this, ActivityMenu.class);
               a.putExtra("usuario", "");
               startActivity(a);
               finish();
           }

        }

    }

    @Override
    public  void onBackPressed(){

        AlertDialog.Builder dialogo = crearDialogoAtras();
        dialogo.show();


    }

    public AlertDialog.Builder crearDialogo(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Confirmacion");
        dialogo1.setMessage("Se va a realizar el pedido, ¿Esta de acuerdo?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {

                SharedPreferences preferencias = getSharedPreferences("ultimoPedido"+servicio.obtenerUltimoUsuarioIniciado().getUsuario(), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoPedido"+servicio.obtenerUltimoUsuarioIniciado().getUsuario(), textViewFinalizarPedido.getText().toString());
                editor.commit();

                Toast t = Toast.makeText(getApplicationContext(), "Pedido en camino a su direccion", Toast.LENGTH_LONG);
                t.show();
                Intent a = new Intent(ActivityFinalizarPedido.this, ActivityMenu.class);
                a.putExtra("usuario", "");
                startActivity(a);
                finish();
            }
        });

        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {


            }
        });


        return dialogo1;
    }

    public AlertDialog.Builder crearDialogoAtras(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Confirmacion");
        dialogo1.setMessage("Su pedido se borrara, ¿Estas seguro?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {

                Intent a = new Intent(ActivityFinalizarPedido.this, ActivityElegirTipoPizza.class);

                startActivity(a);
                finish();
            }
        });

        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {


            }
        });


        return dialogo1;
    }
}