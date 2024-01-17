package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.a2_pizzeria.databinding.ActivityOrderScreenBinding;
import com.example.a2_pizzeria.databinding.ActivitySettingsScreenBinding;

import java.util.ArrayList;

public class OrderScreen extends AppCompatActivity {

    private ActivityOrderScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        binding = ActivityOrderScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.setScreenBackgroundColor(binding.getRoot());
    }

    public void openDefaultPizzasScreen(View view) {
        startActivity(new Intent(this, DefaultPizzasScreen.class));
    }

    public void openCustomPizzasScreen(View view) {
        startActivity(new Intent(this, CustomPizzasScreen.class));
    }

    public void repeatLastOrder(View view) {
        SharedPreferences lastOrderPreferences = getSharedPreferences("lastOrder", Context.MODE_PRIVATE);
        String lastOrder = lastOrderPreferences.getString("lastOrder", "");

        if (lastOrder.equals("default")) {
            startActivity(new Intent(this, ConfirmationScreen.class));
        }
        else {
            startActivity(new Intent(this, CustomConfirmationScreen.class));
        }
    }

    public void goBack(View view) {
        finish();
    }
}