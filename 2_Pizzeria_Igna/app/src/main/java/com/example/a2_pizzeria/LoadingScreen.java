package com.example.a2_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.a2_pizzeria.databinding.ActivityConfirmationScreenBinding;
import com.example.a2_pizzeria.databinding.ActivityLoadingScreenBinding;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadingScreen extends AppCompatActivity {

    private ActivityLoadingScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        binding = ActivityLoadingScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        executeBackgroundTasks();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.setScreenBackgroundColor(binding.getRoot());
    }

    public void mostrarTicket(View view) {
        SharedPreferences lastOrderPreferences = getSharedPreferences("lastOrder", Context.MODE_PRIVATE);
        String lastOrder = lastOrderPreferences.getString("lastOrder", "");

        if (lastOrder.equals("default")) {
            SharedPreferences defaultPizzaOrderPreferences = getSharedPreferences("defaultPizzaOrder", Context.MODE_PRIVATE);
            String name = defaultPizzaOrderPreferences.getString("name", "");
            String size = defaultPizzaOrderPreferences.getString("size", "");
            float price = defaultPizzaOrderPreferences.getFloat("price", 0);

            binding.txtTicket.setText("Nombre: " + name + "\n\nTamaño: " + size + "\n\nPrecio: " + price);
        } else if (lastOrder.equals("custom")) {
            SharedPreferences customPizzaOrderPreferences = getSharedPreferences("customPizzaOrder", Context.MODE_PRIVATE);
            ArrayList<String> ingredients = new ArrayList<>(customPizzaOrderPreferences.getStringSet("ingredients", null));
            String size = customPizzaOrderPreferences.getString("size", "");
            float price = customPizzaOrderPreferences.getFloat("price", 0);

            binding.txtTicket.setText("Ingredientes:\n" + ingredients.get(0) + "\n" + ingredients.get(1) + "\n" + ingredients.get(2) + "\n\nTamaño: " + size + "\n\nPrecio: " + price);
        }

        binding.btnShowTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTicket(v);
            }
        });

        binding.btnShowTicket.setText("Ocultar ticket");
    }

    public void ocultarTicket(View view) {
        binding.txtTicket.setText("");

        binding.btnShowTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTicket(v);
            }
        });

        binding.btnShowTicket.setText("Mostrar ticket");
    }

    private void executeBackgroundTasks() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        int finalI = i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.pbLoading.setProgress(finalI *10);
                            }
                        });

                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        binding.pbLoading.setProgress(100);

                        Intent intent = new Intent(LoadingScreen.this, MainScreen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        finish();

                        Toast.makeText(LoadingScreen.this, "Su pizza está en camino...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}