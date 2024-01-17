package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a2_pizzeria.MainActivity;
import com.example.a2_pizzeria.MainScreen;
import com.example.a2_pizzeria.R;
import com.example.a2_pizzeria.databinding.ActivityConfirmationScreenBinding;
import com.example.a2_pizzeria.databinding.ActivityCustomConfirmationScreenBinding;

import java.util.ArrayList;

public class CustomConfirmationScreen extends AppCompatActivity {

    private ActivityCustomConfirmationScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_confirmation_screen);

        binding = ActivityCustomConfirmationScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences customPizzaOrderPreferences = getSharedPreferences("customPizzaOrder", Context.MODE_PRIVATE);
        ArrayList<String> ingredients = new ArrayList<>(customPizzaOrderPreferences.getStringSet("ingredients", null));
        String size = customPizzaOrderPreferences.getString("size", "");
        float price = customPizzaOrderPreferences.getFloat("price", 0);

        binding.txtIngredient1.setText(ingredients.get(0));
        binding.txtIngredient2.setText(ingredients.get(1));
        binding.txtIngredient3.setText(ingredients.get(2));
        binding.txtSize.setText(size);
        binding.txtPrice.setText(price + "€");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.setScreenBackgroundColor(binding.getRoot());
    }

    public void confirm(View view) {
        SharedPreferences lastOrderPreferences = getSharedPreferences("lastOrder", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = lastOrderPreferences.edit();
        editor.putString("lastOrder", "custom");
        editor.apply();

        Intent intent = new Intent(this, LoadingScreen.class);
        startActivity(intent);

        /*Intent intent = new Intent(this, MainScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();*/
    }

    public void cancel(View view) {
        finish();
    }
}