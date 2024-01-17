package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.a2_pizzeria.adapters.PizzaAdapter;
import com.example.a2_pizzeria.databinding.ActivityDefaultPizzasScreenBinding;
import com.example.a2_pizzeria.databinding.ActivityOrderScreenBinding;
import com.example.a2_pizzeria.dbHelpers.DbHelper;
import com.example.a2_pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DefaultPizzasScreen extends AppCompatActivity {

    private ActivityDefaultPizzasScreenBinding binding;

    private PizzaAdapter pizzaAdapter;

    private DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_pizzas_screen);

        binding = ActivityDefaultPizzasScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rwPizzas.setLayoutManager(new LinearLayoutManager(this));

        List<Pizza> pizzaList = dbHelper.getDefaultPizzas();


        pizzaAdapter = new PizzaAdapter(pizzaList, new PizzaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pizza pizza) {
                int idSelectedSize = binding.rgSizes.getCheckedRadioButtonId();

                if (idSelectedSize == -1) {
                    Toast.makeText(DefaultPizzasScreen.this, "Seleccione un tamaño", Toast.LENGTH_SHORT).show();
                }
                else {
                    String sizeText = ((RadioButton)findViewById(idSelectedSize)).getText().toString();
                    int size = 0;

                    if (sizeText.equals("Pequeña")) size = 0;
                    else if (sizeText.equals("Mediana")) size = 1;
                    else size = 2;

                    SharedPreferences defaultPizzaOrderPreferences = getSharedPreferences("defaultPizzaOrder", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = defaultPizzaOrderPreferences.edit();
                    editor.putString("name", pizza.getName());
                    editor.putString("size", sizeText);
                    editor.putString("url", pizza.getUrl());
                    editor.putFloat("price", pizza.getPrice(size));
                    editor.apply();

                    startActivity(new Intent(DefaultPizzasScreen.this, ConfirmationScreen.class));
                }
            }
        });

        binding.rwPizzas.setAdapter(pizzaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.setScreenBackgroundColor(binding.getRoot());
    }

    public void cancel(View view) {
        finish();
    }
}