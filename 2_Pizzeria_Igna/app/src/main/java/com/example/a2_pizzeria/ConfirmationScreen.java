package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a2_pizzeria.databinding.ActivityConfirmationScreenBinding;
import com.example.a2_pizzeria.databinding.ActivityOrderScreenBinding;

public class ConfirmationScreen extends AppCompatActivity {

    private ActivityConfirmationScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_screen);

        binding = ActivityConfirmationScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences defaultPizzaOrderPreferences = getSharedPreferences("defaultPizzaOrder", Context.MODE_PRIVATE);
        String name = defaultPizzaOrderPreferences.getString("name", "");
        String size = defaultPizzaOrderPreferences.getString("size", "");
        String url = defaultPizzaOrderPreferences.getString("url", "");
        float price = defaultPizzaOrderPreferences.getFloat("price", 0);

        binding.txtPizzaName.setText(name);
        binding.txtPizzaSize.setText(size);
        int drawableResourceId = getResources().getIdentifier(url, "drawable", getPackageName());
        binding.imgPizza.setImageResource(drawableResourceId);
        binding.txtPizzaPrice.setText(price + "€");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.setScreenBackgroundColor(binding.getRoot());
    }

    public void confirm(View view) {
        SharedPreferences lastOrderPreferences = getSharedPreferences("lastOrder", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = lastOrderPreferences.edit();
        editor.putString("lastOrder", "default");
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