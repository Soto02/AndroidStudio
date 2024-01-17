package com.example.examenluis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DBHelper.DbHelper;

public class PantallaJuego extends AppCompatActivity {

    private DbHelper dbHelper = new DbHelper(this);
    private List<String> palabras;
    private ListView txtList;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        //SharedPreference de dificultad
        SharedPreferences dificultadpreferences = getSharedPreferences("dificultad", MODE_PRIVATE);
        int dificultad = dificultadpreferences.getInt("dificultad", 1);

        TextView txtDificultad = findViewById(R.id.txtDificultad);

        if(dificultad == 0) {
            txtDificultad.setText("Facil");
            palabras = dbHelper.getPalabrasFacil();
        } else if (dificultad == 1) {
            txtDificultad.setText("Medio");
            palabras = dbHelper.getPalabrasMedio();
        } else if (dificultad == 2) {
            txtDificultad.setText("Dificil");
            palabras = dbHelper.getPalabrasDificil();
        }

        Button btnVolver = (Button) findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaJuego.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        progressBar = findViewById(R.id.pbBarra);


        SharedPreferences palabrasPreferencias = getSharedPreferences("palabras", Context.MODE_PRIVATE);

        if(palabrasPreferencias.getAll().isEmpty()) {
            SharedPreferences.Editor editor = palabrasPreferencias.edit();
            editor.putStringSet("palabras", new HashSet<>(palabras));
            editor.apply();
        }

        txtList = findViewById(R.id.listLista);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, palabras);

        txtList.setAdapter(adapter);

        txtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Toast.makeText(PantallaJuego.this, "Selected:" + selected,Toast.LENGTH_SHORT).show();
            }
        });

        mostrarPalabras();

    }

    private void mostrarPalabras() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i =0; i<10; i++) {
                        int num = i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(num*10);
                                //Toast.makeText(PantallaJuego.this, palabras, Toast.LENGTH_SHORT).show();
                            }
                        });
                        Thread.sleep(2000);
                    }
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PantallaJuego.this,PantallaRespuesta.class));
                    }
                });
            }
        });
    }
}