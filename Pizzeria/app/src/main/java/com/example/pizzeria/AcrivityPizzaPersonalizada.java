package com.example.pizzeria;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Modelo.Pizza;
import Modelo.Servicio;

public class AcrivityPizzaPersonalizada extends AppCompatActivity implements View.OnClickListener {
    CheckBox cbBacon, cbExtraQueso, cbCebolla, cbSalsaBarbacoa, cbTernera, cbPimientoVerde, cbPollo, cbJamonYork, cbPimientoChili, cbAtun;
    Button btnCrearPizza, btnFinalizarPedido;
    ArrayList<String> arrayIngrediente;
    ArrayList<Pizza> arrayPizzasPedidas;
    RadioButton rdnMediana, rdnGrande, rdnFamiliar;
    Servicio servicio;
    RadioGroup grupoRadioBtn;
    ConstraintLayout layoutDeAqui;
    TextView textViewElijeIngredientes, textViewEligeTamaño;
    int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acrivity_pizza_personalizada);
        textViewElijeIngredientes = findViewById(R.id.textViewElijeIngredientes);
        textViewEligeTamaño = findViewById(R.id.textViewTamañoPers);
        cbBacon = findViewById(R.id.cbBacon);
        cbExtraQueso = findViewById(R.id.cbExtraQueso);
        cbCebolla = findViewById(R.id.cbCebolla);
        cbSalsaBarbacoa = findViewById(R.id.cbSalsaBarbacoa);
        cbTernera = findViewById(R.id.cbTernera);
        cbPimientoVerde = findViewById(R.id.cbPimientoVerde);
        cbPollo = findViewById(R.id.cbPollo);
        cbJamonYork = findViewById(R.id.cbJamonYork);
        cbPimientoChili = findViewById(R.id.cbPimientoChili);
        cbAtun = findViewById(R.id.cbAtun);
        btnCrearPizza = findViewById(R.id.btnCrearPizza);
        btnFinalizarPedido = findViewById(R.id.btnFinalizarPedidoPers);
        rdnMediana = findViewById(R.id.rdnMediana);
        rdnGrande = findViewById(R.id.rdnGrande);
        rdnFamiliar = findViewById(R.id.rdnFamiliar);
        arrayIngrediente = new ArrayList<String>();
        arrayPizzasPedidas = new ArrayList<Pizza>();
        grupoRadioBtn = findViewById(R.id.radioGroup);
        servicio = new Servicio(this);
        layoutDeAqui = findViewById(R.id.layout9);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.black){
            cbBacon.setTextColor(Color.WHITE);
            cbAtun.setTextColor(Color.WHITE);
            cbCebolla.setTextColor(Color.WHITE);
            cbExtraQueso.setTextColor(Color.WHITE);
            cbPimientoChili.setTextColor(Color.WHITE);
            cbJamonYork.setTextColor(Color.WHITE);
            cbPollo.setTextColor(Color.WHITE);
            cbSalsaBarbacoa.setTextColor(Color.WHITE);
            cbTernera.setTextColor(Color.WHITE);
            cbPimientoVerde.setTextColor(Color.WHITE);
            btnCrearPizza.setTextColor(Color.WHITE);
            btnCrearPizza.setBackgroundColor(Color.rgb(200, 0, 0));
            btnCrearPizza.setTextColor(Color.WHITE);
            btnCrearPizza.setBackgroundColor(Color.rgb(200, 0, 0));
            btnFinalizarPedido.setTextColor(Color.WHITE);
            btnFinalizarPedido.setBackgroundColor(Color.rgb(200, 0, 0));
            rdnFamiliar.setTextColor(Color.WHITE);
            rdnMediana.setTextColor(Color.WHITE);
            rdnGrande.setTextColor(Color.WHITE);
            textViewElijeIngredientes.setTextColor(Color.WHITE);
            textViewEligeTamaño.setTextColor(Color.WHITE);

        }else if(ActivityAHeredar.colorFondo == android.R.color.white){
            cbBacon.setTextColor(Color.BLACK);
            cbAtun.setTextColor(Color.BLACK);
            cbCebolla.setTextColor(Color.BLACK);
            cbExtraQueso.setTextColor(Color.BLACK);
            cbPimientoChili.setTextColor(Color.BLACK);
            cbJamonYork.setTextColor(Color.BLACK);
            cbPollo.setTextColor(Color.BLACK);
            cbSalsaBarbacoa.setTextColor(Color.BLACK);
            cbTernera.setTextColor(Color.BLACK);
            cbPimientoVerde.setTextColor(Color.BLACK);
            btnCrearPizza.setTextColor(Color.WHITE);
            btnCrearPizza.setBackgroundColor(Color.rgb(200, 0, 0));
            btnCrearPizza.setTextColor(Color.WHITE);
            btnCrearPizza.setBackgroundColor(Color.rgb(200, 0, 0));
            btnFinalizarPedido.setTextColor(Color.WHITE);
            btnFinalizarPedido.setBackgroundColor(Color.rgb(200, 0, 0));
            rdnFamiliar.setTextColor(Color.BLACK);
            rdnMediana.setTextColor(Color.BLACK);
            rdnGrande.setTextColor(Color.BLACK);
            textViewElijeIngredientes.setTextColor(Color.BLACK);
            textViewEligeTamaño.setTextColor(Color.BLACK);
        }else{
            cbBacon.setTextColor(Color.BLACK);
            cbAtun.setTextColor(Color.BLACK);
            cbCebolla.setTextColor(Color.BLACK);
            cbExtraQueso.setTextColor(Color.BLACK);
            cbPimientoChili.setTextColor(Color.BLACK);
            cbJamonYork.setTextColor(Color.BLACK);
            cbPollo.setTextColor(Color.BLACK);
            cbSalsaBarbacoa.setTextColor(Color.BLACK);
            cbTernera.setTextColor(Color.BLACK);
            cbPimientoVerde.setTextColor(Color.BLACK);
            btnCrearPizza.setTextColor(Color.WHITE);
            btnCrearPizza.setBackgroundColor(Color.BLACK);
            btnCrearPizza.setTextColor(Color.WHITE);
            btnCrearPizza.setBackgroundColor(Color.BLACK);
            btnFinalizarPedido.setTextColor(Color.WHITE);
            btnFinalizarPedido.setBackgroundColor(Color.BLACK);
            rdnFamiliar.setTextColor(Color.BLACK);
            rdnMediana.setTextColor(Color.BLACK);
            rdnGrande.setTextColor(Color.BLACK);
            textViewElijeIngredientes.setTextColor(Color.BLACK);
            textViewEligeTamaño.setTextColor(Color.BLACK);
        }
    }

    @Override
    public void onClick(View v) {



        if(v.getId() == cbAtun.getId()){

            if(cbAtun.isChecked()){

                arrayIngrediente.add(cbAtun.getText().toString());

            }else{

                arrayIngrediente.remove(cbAtun.getText().toString());

            }

        }

        if(v.getId() == cbExtraQueso.getId()) {

            if(cbExtraQueso.isChecked() ){

                arrayIngrediente.add(cbExtraQueso.getText().toString());

            }else{

                arrayIngrediente.remove(cbExtraQueso.getText().toString());

            }

        }

        if(v.getId() == cbPimientoVerde.getId()) {

            if(cbPimientoVerde.isChecked() ){

                arrayIngrediente.add(cbPimientoVerde.getText().toString());

            }else{

                arrayIngrediente.remove(cbPimientoVerde.getText().toString());

            }

        }

        if(v.getId() == cbJamonYork.getId()) {

            if(cbJamonYork.isChecked() ){

                arrayIngrediente.add(cbJamonYork.getText().toString());

            }else{

                arrayIngrediente.remove(cbJamonYork.getText().toString());

            }
        }

        if(v.getId() == cbTernera.getId()) {

            if(cbTernera.isChecked() ){

                arrayIngrediente.add(cbTernera.getText().toString());

            }else{

                arrayIngrediente.remove(cbTernera.getText().toString());

            }

        }

        if(v.getId() == cbCebolla.getId()) {

            if(cbCebolla.isChecked()){

                arrayIngrediente.add(cbCebolla.getText().toString());

            }else{

                arrayIngrediente.remove(cbCebolla.getText().toString());

            }

        }

        if(v.getId() == cbPollo.getId()) {

            if(cbPollo.isChecked()){

                arrayIngrediente.add(cbPollo.getText().toString());

            }else{

                arrayIngrediente.remove(cbPollo.getText().toString());

            }

        }

        if(v.getId() == cbPimientoChili.getId()) {

            if(cbPimientoChili.isChecked()){

                arrayIngrediente.add(cbPimientoChili.getText().toString());

            }else{

                arrayIngrediente.remove(cbPimientoChili.getText().toString());

            }

        }

        if(v.getId() == cbSalsaBarbacoa.getId()) {

            if(cbSalsaBarbacoa.isChecked()){

                arrayIngrediente.add(cbSalsaBarbacoa.getText().toString());

            }else{

                arrayIngrediente.remove(cbSalsaBarbacoa.getText().toString());

            }

        }

        if(v.getId() == cbBacon.getId()) {

            if(cbBacon.isChecked()){

                arrayIngrediente.add(cbBacon.getText().toString());

            }else{

                arrayIngrediente.remove(cbBacon.getText().toString());

            }

        }

        if(arrayIngrediente.size() >= 4 && cbBacon.isChecked() == false){
            cbBacon.setEnabled(false);
        }else{
            cbBacon.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbSalsaBarbacoa.isChecked() == false){
            cbSalsaBarbacoa.setEnabled(false);
        }else{
            cbSalsaBarbacoa.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbPimientoChili.isChecked() == false){
            cbPimientoChili.setEnabled(false);
        }else{
            cbPimientoChili.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbPollo.isChecked() == false){
            cbPollo.setEnabled(false);
        }else{
            cbPollo.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbCebolla.isChecked() == false){
            cbCebolla.setEnabled(false);
        }else{
            cbCebolla.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbTernera.isChecked() == false){
            cbTernera.setEnabled(false);
        }else{
            cbTernera.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbJamonYork.isChecked() == false){
            cbJamonYork.setEnabled(false);
        }else{
            cbJamonYork.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbPimientoVerde.isChecked() == false){
            cbPimientoVerde.setEnabled(false);
        }else{
            cbPimientoVerde.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbExtraQueso.isChecked() == false){
            cbExtraQueso.setEnabled(false);
        }else{
            cbExtraQueso.setEnabled(true);
        }
        if(arrayIngrediente.size() >= 4 && cbAtun.isChecked() == false){
            cbAtun.setEnabled(false);
        }else{
            cbAtun.setEnabled(true);
        }

        if(v.getId() == btnCrearPizza.getId()){

            if(arrayIngrediente.size() >= 4 && (rdnMediana.isChecked() || rdnGrande.isChecked() || rdnFamiliar.isChecked())) {
                if (rdnMediana.isChecked()) {
                    arrayPizzasPedidas.add(new Pizza("Pizza personalizada", arrayIngrediente.get(0), arrayIngrediente.get(1), arrayIngrediente.get(2), arrayIngrediente.get(3), "Mediana"));
                    grupoRadioBtn.clearCheck();
                } else if (rdnGrande.isChecked()) {
                    arrayPizzasPedidas.add(new Pizza("Pizza personalizada", arrayIngrediente.get(0), arrayIngrediente.get(1), arrayIngrediente.get(2), arrayIngrediente.get(3), "Grande"));
                    grupoRadioBtn.clearCheck();
                } else if (rdnFamiliar.isChecked()) {
                    arrayPizzasPedidas.add(new Pizza("Pizza personalizada", arrayIngrediente.get(0), arrayIngrediente.get(1), arrayIngrediente.get(2), arrayIngrediente.get(3), "Familiar"));
                    grupoRadioBtn.clearCheck();
                }

                Toast t = Toast.makeText(getApplicationContext(), "Se ha añadido la pizza al pedido", LENGTH_SHORT);
                t.show();

                arrayIngrediente = new ArrayList<String>();


                cbBacon.setChecked(false);
                cbAtun.setChecked(false);
                cbSalsaBarbacoa.setChecked(false);
                cbPimientoChili.setChecked(false);
                cbExtraQueso.setChecked(false);
                cbJamonYork.setChecked(false);
                cbPimientoVerde.setChecked(false);
                cbCebolla.setChecked(false);
                cbTernera.setChecked(false);
                cbPollo.setChecked(false);

                cbBacon.setEnabled(true);
                cbAtun.setEnabled(true);
                cbSalsaBarbacoa.setEnabled(true);
                cbPimientoChili.setEnabled(true);
                cbExtraQueso.setEnabled(true);
                cbJamonYork.setEnabled(true);
                cbPimientoVerde.setEnabled(true);
                cbCebolla.setEnabled(true);
                cbTernera.setEnabled(true);
                cbPollo.setEnabled(true);
            }

        }

        if(v.getId() == btnFinalizarPedido.getId()){

            servicio.añadirPedido(arrayPizzasPedidas);
            arrayPizzasPedidas =  new ArrayList<Pizza>();
            Intent i = new Intent(AcrivityPizzaPersonalizada.this, ActivityFinalizarPedido.class);
            i.putExtra("pedido", "pers");
            startActivity(i);
            finish();

        }

    }

    @Override
    public  void onBackPressed(){

        Intent i = new Intent(AcrivityPizzaPersonalizada.this, ActivityElegirTipoPizza.class);

        startActivity(i);
        finish();

    }
}