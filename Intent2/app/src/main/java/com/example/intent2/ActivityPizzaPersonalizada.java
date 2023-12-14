package com.example.intent2;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Modelo.Pizza;
import Modelo.Servicio;


public class ActivityPizzaPersonalizada extends AppCompatActivity implements View.OnClickListener{

    Servicio servicio;
    Button btnAñadirPizza, btnFinalizarPedido;
    RadioButton rbPizza1, rbPizza2, rbPizza3, rbPizza4, rbPizza5, rbPizza6, rbButtonMediana, rbGrande, rbFamiliar;
    ArrayList<Pizza> arrayPizzasPedidas;
    ConstraintLayout layoutDeAqui;
    TextView ingredientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_personalizada);

        ActivityHeredar.agregarActivity(this);
        SharedPreferences preferencias = getSharedPreferences("preferencia", MODE_PRIVATE);
        int colorGuardado = preferencias.getInt("colorSeleccionado", Color.WHITE);
        ActivityHeredar.aplicarColorEnTodas(colorGuardado);

        servicio = new Servicio(this);
        rbPizza1 = findViewById(R.id.rdBBQ);
        rbPizza2 = findViewById(R.id.rbCarbonara);
        rbPizza3 = findViewById(R.id.rbQuesos);
        rbPizza4 = findViewById(R.id.rbPeperoni);
        rbPizza5 = findViewById(R.id.rbAlejandrina);
        rbPizza6 = findViewById(R.id.rbMileurista);

        rbPizza1.setText(servicio.getServicioPizzas().get(0).getNombre());
        rbPizza2.setText(servicio.getServicioPizzas().get(1).getNombre());
        rbPizza3.setText(servicio.getServicioPizzas().get(2).getNombre());
        rbPizza4.setText(servicio.getServicioPizzas().get(3).getNombre());
        rbPizza5.setText(servicio.getServicioPizzas().get(4).getNombre());
        rbPizza6.setText(servicio.getServicioPizzas().get(5).getNombre());

        ingredientes = findViewById(R.id.txtMostrarIngredientes);
        btnAñadirPizza = findViewById(R.id.btnAñadirPizza);
        btnFinalizarPedido = findViewById(R.id.btnFinalizarPrdido);
        rbButtonMediana = findViewById(R.id.rbMediana);
        rbGrande = findViewById(R.id.rbGrande);
        rbFamiliar = findViewById(R.id.rbFamiliar);
        arrayPizzasPedidas = new ArrayList<Pizza>();
        layoutDeAqui = findViewById(R.id.layoutPizzas);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == rbPizza1.getId()) {

            for (Pizza pizza: servicio.getServicioPizzas()) {

                if(pizza.getNombre().equals(rbPizza1.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }
            }
        }
        if(v.getId() == rbPizza2.getId()) {

            for (Pizza pizza: servicio.getServicioPizzas()) {

                if(pizza.getNombre().equals(rbPizza2.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }
            }
        }
        if(v.getId() == rbPizza3.getId()) {

            for (Pizza pizza: servicio.getServicioPizzas()) {

                if(pizza.getNombre().equals(rbPizza3.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }
            }
        }
        if(v.getId() == rbPizza4.getId()) {

            for (Pizza pizza: servicio.getServicioPizzas()) {

                if(pizza.getNombre().equals(rbPizza4.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }
            }
        }
        if(v.getId() == rbPizza5.getId()) {

            for (Pizza pizza: servicio.getServicioPizzas()) {

                if(pizza.getNombre().equals(rbPizza5.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }
            }
        }
        if(v.getId() == rbPizza6.getId()) {

            for (Pizza pizza: servicio.getServicioPizzas()) {

                if(pizza.getNombre().equals(rbPizza6.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }
            }
        }

        if(v.getId() == btnAñadirPizza.getId()) {

            if(rbPizza1.isChecked() && (rbButtonMediana.isChecked() || rbGrande.isChecked() || rbFamiliar.isChecked())) {
                añadirPizzas(0);
                ingredientes.setText("");
                rbPizza1.clearFocus();
                rbPizza2.clearFocus();
                rbPizza3.clearFocus();
                rbPizza4.clearFocus();
                rbPizza5.clearFocus();
                rbPizza6.clearFocus();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();
            }
            if(rbPizza2.isChecked() && (rbButtonMediana.isChecked() || rbGrande.isChecked() || rbFamiliar.isChecked())){
                añadirPizzas(1);
                ingredientes.setText("");
                rbPizza1.clearFocus();
                rbPizza2.clearFocus();
                rbPizza3.clearFocus();
                rbPizza4.clearFocus();
                rbPizza5.clearFocus();
                rbPizza6.clearFocus();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();
            }
            if(rbPizza3.isChecked() && (rbButtonMediana.isChecked() || rbGrande.isChecked() || rbFamiliar.isChecked())){
                añadirPizzas(2);
                ingredientes.setText("");
                rbPizza1.clearFocus();
                rbPizza2.clearFocus();
                rbPizza3.clearFocus();
                rbPizza4.clearFocus();
                rbPizza5.clearFocus();
                rbPizza6.clearFocus();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();
            }
            if(rbPizza4.isChecked() && (rbButtonMediana.isChecked() || rbGrande.isChecked() || rbFamiliar.isChecked())){
                añadirPizzas(3);
                ingredientes.setText("");
                rbPizza1.clearFocus();
                rbPizza2.clearFocus();
                rbPizza3.clearFocus();
                rbPizza4.clearFocus();
                rbPizza5.clearFocus();
                rbPizza6.clearFocus();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();
            }
            if(rbPizza5.isChecked() && (rbButtonMediana.isChecked() || rbGrande.isChecked() || rbFamiliar.isChecked())){
                añadirPizzas(4);
                ingredientes.setText("");
                rbPizza1.clearFocus();
                rbPizza2.clearFocus();
                rbPizza3.clearFocus();
                rbPizza4.clearFocus();
                rbPizza5.clearFocus();
                rbPizza6.clearFocus();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();
            }
            if(rbPizza6.isChecked() && (rbButtonMediana.isChecked() || rbGrande.isChecked() || rbFamiliar.isChecked())){
                añadirPizzas(5);
                ingredientes.setText("");
                rbPizza1.clearFocus();
                rbPizza2.clearFocus();
                rbPizza3.clearFocus();
                rbPizza4.clearFocus();
                rbPizza5.clearFocus();
                rbPizza6.clearFocus();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();
            }
        }

        if(v.getId() == btnFinalizarPedido.getId()) {
            servicio.añadirPedido(arrayPizzasPedidas);
            arrayPizzasPedidas = new ArrayList<Pizza>();
            Intent intent = new Intent(ActivityPizzaPersonalizada.this, ActivityFinalizarPedido.class);
            intent.putExtra("pedido", "normal");
            startActivity(intent);
            finish();
        }

    }

    private void añadirPizzas(int id) {
        if(rbButtonMediana.isChecked()){
            arrayPizzasPedidas.add(servicio.getServicioPizzas().get(id));
            arrayPizzasPedidas.get(arrayPizzasPedidas.size()-1).setTamaño(rbButtonMediana.getText().toString());
            rbButtonMediana.clearFocus();
        }else if(rbGrande.isChecked()){
            arrayPizzasPedidas.add(servicio.getServicioPizzas().get(id));
            arrayPizzasPedidas.get(arrayPizzasPedidas.size()-1).setTamaño(rbGrande.getText().toString());
            rbGrande.clearFocus();
        }else if(rbFamiliar.isChecked()) {
            arrayPizzasPedidas.add(servicio.getServicioPizzas().get(id));
            arrayPizzasPedidas.get(arrayPizzasPedidas.size()-1).setTamaño(rbFamiliar.getText().toString());
            rbFamiliar.clearFocus();
        }
    }
}