package com.example.recuperacionignacio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.recuperacionignacio.clases.Cita;
import com.example.recuperacionignacio.dao.DbHelper;
import com.example.recuperacionignacio.databinding.ActivityPantallaCitaBinding;
import com.example.recuperacionignacio.databinding.ActivityPantallaCitaDiaBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PantallaCitaDia extends AppCompatActivity {
    private ActivityPantallaCitaDiaBinding binding;
    private DbHelper dbHelper;
    private int numeroCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cita_dia);

        binding = ActivityPantallaCitaDiaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);

        SharedPreferences numeroCitasPreferences = getSharedPreferences("numeroCitas", Context.MODE_PRIVATE);
        numeroCitas = numeroCitasPreferences.getInt("numeroCitas", 1);

        mostrarCitas();
    }

    private void mostrarCitas() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < numeroCitas; i++) {
                        int number = i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                List<Cita> citas = dbHelper.getCitas();


                                List<Cita> citasFiltradasPorVeces = new ArrayList<>();
                                int numeroMenorVeces = citas.get(0).getNumeroVeces();
                                for (Cita cita : citas) {
                                    if (cita.getNumeroVeces() < numeroMenorVeces) {
                                        citasFiltradasPorVeces.add(cita);
                                    }
                                }



                                if (citas.size() > 1) {
                                    List<Cita> citasFiltradasPorValoracion = new ArrayList<>();
                                    int valoracionMayor = citas.get(0).getValoracion();
                                    for (Cita cita : citas) {
                                        if (cita.getValoracion() >= valoracionMayor) {
                                            citasFiltradasPorValoracion.add(cita);
                                        }
                                    }

                                }

                                Cita cita = null;
                                if (citas.size() > 1) {
                                    int numeroAleatorio = (int)(Math.random() * citas.size());
                                    cita = citas.get(numeroAleatorio);
                                } else {
                                    cita = citas.get(0);
                                }


                                binding.txtFrase.setText(cita.getFrase());
                                binding.txtAutor.setText(cita.getAutor());
                                binding.txtNumeroveces.setText(cita.getNumeroVeces() + "");
                                binding.txtValoracion.setText(cita.getValoracion() + "");

                                dbHelper.setNumeroVeces(cita.getFrase(), cita.getNumeroVeces() + 1);
                            }
                        });
                        Thread.sleep(10000);
                    }
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        });
    }

    public void volver(View view) {
        finish();
    }
}