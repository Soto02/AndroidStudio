package com.example.examenignaciofernandezsanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenignaciofernandezsanchez.dbHelpers.DbHelper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PantallaJugar extends AppCompatActivity {
    private DbHelper dbHelper = new DbHelper(this);
    private List<String> palabras;
    private TextView txtPalabra;
    private boolean parar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_jugar);

        txtPalabra = findViewById(R.id.txtPalabra);

        palabras = dbHelper.getPalabras();

        SharedPreferences palabrasPreferences = getSharedPreferences("palabras", Context.MODE_PRIVATE);

        if (palabrasPreferences.getAll().isEmpty()) {
            SharedPreferences.Editor editor = palabrasPreferences.edit();
            editor.putString("palabra1", "belleza");
            editor.putString("palabra2", "basket");
            editor.putString("palabra3", "alarma");
            editor.apply();
        }
        palabras.add(palabrasPreferences.getString("palabra1", ""));
        palabras.add(palabrasPreferences.getString("palabra2", ""));
        palabras.add(palabrasPreferences.getString("palabra3", ""));

        mostrarPalabras();
    }

    public void volverInicio(View view) {
        Intent intent = new Intent(PantallaJugar.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        parar = true;
        startActivity(intent);
        finish();
    }

    private void mostrarPalabras() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (String palabra: palabras) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txtPalabra.setText(palabra);
                            }
                        });

                        Thread.sleep(2000);
                    }
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!parar) {
                            startActivity(new Intent(PantallaJugar.this, PantallaResponder.class));
                        }
                    }
                });
            }
        });
    }
}