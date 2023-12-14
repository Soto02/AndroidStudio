package com.example.pizzeria;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class ActivityNuestrasPizzas extends AppCompatActivity implements View.OnClickListener{
    Servicio servicio;
    RadioGroup grupoPizzas, grupoTamaños;
    TextView ingredientes, tvPizzas, tvTamaños, textViewIngrediente;
    Button btnAñadirPizza, btnFinalizarPedido;
    RadioButton radioButtonPizza1, radioButtonPizza2, radioButtonPizza3, radioButtonPizza4, radioButtonPizza5, radioButtonPizza6, radioButtonMediana, radioButtonGrande, radioButtonFamiliar;
    ArrayList<Pizza> arrayPizzasPedidas;
    ConstraintLayout layoutDeAqui;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuestras_pizzas);
        servicio =  new Servicio(this);
        radioButtonPizza1 =  findViewById(R.id.radioButtonPizza1);
        radioButtonPizza2 =  findViewById(R.id.radioButtonPizza2);
        radioButtonPizza5 =  findViewById(R.id.radioButtonPizza5);
        radioButtonPizza3 =  findViewById(R.id.radioButtonPizza3);
        radioButtonPizza6 =  findViewById(R.id.radioButtonPizza6);
        radioButtonPizza4 =  findViewById(R.id.radioButtonPizza4);

        radioButtonPizza1.setText(servicio.getServicioPizzas().get(0).getNombre());
        radioButtonPizza2.setText(servicio.getServicioPizzas().get(1).getNombre());
        radioButtonPizza3.setText(servicio.getServicioPizzas().get(2).getNombre());
        radioButtonPizza4.setText(servicio.getServicioPizzas().get(3).getNombre());
        radioButtonPizza5.setText(servicio.getServicioPizzas().get(4).getNombre());
        radioButtonPizza6.setText(servicio.getServicioPizzas().get(5).getNombre());

        ingredientes = findViewById(R.id.textViewIngrSeleccionado);
        tvPizzas = findViewById(R.id.textViewPizzas);
        tvTamaños = findViewById(R.id.textViewTamaños);
        textViewIngrediente = findViewById(R.id.textViewIngredientes);
        btnAñadirPizza = findViewById(R.id.btnAñadirPizza);
        radioButtonMediana = findViewById(R.id.radioButtonMediana);
        radioButtonGrande = findViewById(R.id.radioButtonGrande);
        radioButtonFamiliar = findViewById(R.id.radioButtonFamiliar);
        btnFinalizarPedido = findViewById(R.id.btnFinalizarPrdido);
        arrayPizzasPedidas =  new ArrayList<Pizza>();
        grupoPizzas =  findViewById(R.id.GrupoPizzas);
        grupoTamaños = findViewById(R.id.GrupoTamaños);
        layoutDeAqui = findViewById(R.id.layout6);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.black){

            btnAñadirPizza.setTextColor(Color.WHITE);
            btnAñadirPizza.setBackgroundColor(Color.rgb(200, 0, 0));
            btnFinalizarPedido.setTextColor(Color.WHITE);
            btnFinalizarPedido.setBackgroundColor(Color.rgb(200, 0, 0));

            radioButtonMediana.setTextColor(Color.WHITE);
            radioButtonGrande.setTextColor(Color.WHITE);
            radioButtonFamiliar.setTextColor(Color.WHITE);

            radioButtonPizza1.setTextColor(Color.WHITE);
            radioButtonPizza2.setTextColor(Color.WHITE);
            radioButtonPizza3.setTextColor(Color.WHITE);
            radioButtonPizza4.setTextColor(Color.WHITE);
            radioButtonPizza5.setTextColor(Color.WHITE);
            radioButtonPizza6.setTextColor(Color.WHITE);

            ingredientes.setTextColor(Color.WHITE);
            tvPizzas.setTextColor(Color.WHITE);
            tvTamaños.setTextColor(Color.WHITE);
            textViewIngrediente.setTextColor(Color.WHITE);

        }else if (ActivityAHeredar.colorFondo == android.R.color.white){
            btnAñadirPizza.setTextColor(Color.WHITE);
            btnAñadirPizza.setBackgroundColor(Color.rgb(200, 0, 0));
            btnFinalizarPedido.setTextColor(Color.WHITE);
            btnFinalizarPedido.setBackgroundColor(Color.rgb(200, 0, 0));

            radioButtonMediana.setTextColor(Color.BLACK);
            radioButtonGrande.setTextColor(Color.BLACK);
            radioButtonFamiliar.setTextColor(Color.BLACK);

            radioButtonPizza1.setTextColor(Color.BLACK);
            radioButtonPizza2.setTextColor(Color.BLACK);
            radioButtonPizza3.setTextColor(Color.BLACK);
            radioButtonPizza4.setTextColor(Color.BLACK);
            radioButtonPizza5.setTextColor(Color.BLACK);
            radioButtonPizza6.setTextColor(Color.BLACK);

            ingredientes.setTextColor(Color.BLACK);
            tvPizzas.setTextColor(Color.BLACK);
            tvTamaños.setTextColor(Color.BLACK);
            textViewIngrediente.setTextColor(Color.BLACK);
        }else{
            btnAñadirPizza.setTextColor(Color.WHITE);
            btnAñadirPizza.setBackgroundColor(Color.BLACK);
            btnFinalizarPedido.setTextColor(Color.WHITE);
            btnFinalizarPedido.setBackgroundColor(Color.BLACK);

            radioButtonMediana.setTextColor(Color.BLACK);
            radioButtonGrande.setTextColor(Color.BLACK);
            radioButtonFamiliar.setTextColor(Color.BLACK);

            radioButtonPizza1.setTextColor(Color.BLACK);
            radioButtonPizza2.setTextColor(Color.BLACK);
            radioButtonPizza3.setTextColor(Color.BLACK);
            radioButtonPizza4.setTextColor(Color.BLACK);
            radioButtonPizza5.setTextColor(Color.BLACK);
            radioButtonPizza6.setTextColor(Color.BLACK);

            ingredientes.setTextColor(Color.BLACK);
            tvPizzas.setTextColor(Color.BLACK);
            tvTamaños.setTextColor(Color.BLACK);
            textViewIngrediente.setTextColor(Color.BLACK);
        }


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == radioButtonPizza1.getId()){

            for (Pizza pizza: servicio.getServicioPizzas())

                if(pizza.getNombre().equals(radioButtonPizza1.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }

        }

        if(v.getId() == radioButtonPizza2.getId()){

            for (Pizza pizza: servicio.getServicioPizzas())

                if(pizza.getNombre().equals(radioButtonPizza2.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }

        }
        if(v.getId() == radioButtonPizza3.getId()){

            for (Pizza pizza: servicio.getServicioPizzas())

                if(pizza.getNombre().equals(radioButtonPizza3.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }

        }
        if(v.getId() == radioButtonPizza4.getId()){

            for (Pizza pizza: servicio.getServicioPizzas())

                if(pizza.getNombre().equals(radioButtonPizza4.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }

        }
        if(v.getId() == radioButtonPizza5.getId()){

            for (Pizza pizza: servicio.getServicioPizzas())

                if(pizza.getNombre().equals(radioButtonPizza5.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }

        }
        if(v.getId() == radioButtonPizza6.getId()){

            for (Pizza pizza: servicio.getServicioPizzas())

                if(pizza.getNombre().equals(radioButtonPizza6.getText())) {
                    ingredientes.setText( pizza.obtenerStringIngredientes());
                }

        }
        if(v.getId() == btnAñadirPizza.getId()){

            if(radioButtonPizza1.isChecked() && (radioButtonMediana.isChecked() || radioButtonGrande.isChecked() || radioButtonFamiliar.isChecked())){

                añadirPizzas(0);
                ingredientes.setText("");
                grupoPizzas.clearCheck();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

            }
            if(radioButtonPizza2.isChecked() && (radioButtonMediana.isChecked() || radioButtonGrande.isChecked() || radioButtonFamiliar.isChecked())){

                añadirPizzas(1);
                ingredientes.setText("");
                grupoPizzas.clearCheck();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

            }
            if(radioButtonPizza3.isChecked() && (radioButtonMediana.isChecked() || radioButtonGrande.isChecked() || radioButtonFamiliar.isChecked())){

                añadirPizzas(2);
                ingredientes.setText("");
                grupoPizzas.clearCheck();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

            }
            if(radioButtonPizza4.isChecked() && (radioButtonMediana.isChecked() || radioButtonGrande.isChecked() || radioButtonFamiliar.isChecked())){

                añadirPizzas(3);
                ingredientes.setText("");
                grupoPizzas.clearCheck();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

            }
            if(radioButtonPizza5.isChecked() && (radioButtonMediana.isChecked() || radioButtonGrande.isChecked() || radioButtonFamiliar.isChecked())){

                añadirPizzas(4);
                ingredientes.setText("");
                grupoPizzas.clearCheck();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

            }
            if(radioButtonPizza6.isChecked() && (radioButtonMediana.isChecked() || radioButtonGrande.isChecked() || radioButtonFamiliar.isChecked())){

                añadirPizzas(5);
                ingredientes.setText("");
                grupoPizzas.clearCheck();
                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

            }



        }

        if(v.getId() == btnFinalizarPedido.getId()){

            servicio.añadirPedido(arrayPizzasPedidas);
            arrayPizzasPedidas =  new ArrayList<Pizza>();
            Intent i = new Intent(ActivityNuestrasPizzas.this, ActivityFinalizarPedido.class);
            i.putExtra("pedido", "normal");
            startActivity(i);
            finish();

        }

    }

    public void añadirPizzas(int idPizza){

        if(radioButtonMediana.isChecked()){
            arrayPizzasPedidas.add(servicio.getServicioPizzas().get(idPizza));
            arrayPizzasPedidas.get(arrayPizzasPedidas.size()-1).setTamaño(radioButtonMediana.getText().toString());
            grupoTamaños.clearCheck();
        }else if(radioButtonGrande.isChecked()){
            arrayPizzasPedidas.add(servicio.getServicioPizzas().get(idPizza));
            arrayPizzasPedidas.get(arrayPizzasPedidas.size()-1).setTamaño(radioButtonGrande.getText().toString());
            grupoTamaños.clearCheck();
        }else if(radioButtonFamiliar.isChecked()) {
            arrayPizzasPedidas.add(servicio.getServicioPizzas().get(idPizza));
            arrayPizzasPedidas.get(arrayPizzasPedidas.size()-1).setTamaño(radioButtonFamiliar.getText().toString());
            grupoTamaños.clearCheck();
        }
        //grupoTamaños.clearCheck();
    }

    @Override
    public  void onBackPressed(){

        Intent i = new Intent(ActivityNuestrasPizzas.this, ActivityElegirTipoPizza.class);

        startActivity(i);
        finish();

    }


}
