package com.example.examenignaciofernandezsanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PantallaResponder extends AppCompatActivity {
    List<String> palabras = new ArrayList<String>();
    List<String> palabrasAcertadas = new ArrayList<String>();
    private boolean parar = false;
    //SharedPreferences numeroAciertosPreferences = getSharedPreferences("numeroAciertosActual", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_responder);

        SharedPreferences palabrasPreferences = getSharedPreferences("palabras", Context.MODE_PRIVATE);

        palabras.add(palabrasPreferences.getString("palabra1", ""));
        palabras.add(palabrasPreferences.getString("palabra2", ""));
        palabras.add(palabrasPreferences.getString("palabra3", ""));

        gestionarProgreso();
    }

    public void comprobarPalabra(View view) {
        EditText txtPalabra = findViewById(R.id.edtPalabra);
        TextView txtPalabrasAcertadas = findViewById(R.id.txtPalabrasAcertadas);
        String palabraIntroducida = txtPalabra.getText().toString();

        if (palabras.contains(palabraIntroducida) && !palabrasAcertadas.contains(palabraIntroducida)) {
            txtPalabrasAcertadas.setText(txtPalabrasAcertadas.getText() + "  " + palabraIntroducida);
            palabrasAcertadas.add(palabraIntroducida);
        }

        if (palabrasAcertadas.size() == palabras.size()) {
            /*SharedPreferences.Editor editor = numeroAciertosPreferences.edit();
            editor.putInt("numeroAciertos", palabrasAcertadas.size());
            editor.apply();*/

            parar = true;
            startActivity(new Intent(PantallaResponder.this, PantallaResultados.class));
        }
    }

    public void volverInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        parar = true;
        startActivity(intent);
        finish();
    }

    private void gestionarProgreso() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((ProgressBar)findViewById(R.id.pbProgreso)).setProgress(palabrasAcertadas.size() / palabras.size() * 100);
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
                        if (!parar) {
                            /*SharedPreferences.Editor editor = numeroAciertosPreferences.edit();
                            editor.putInt("numeroAciertos", palabrasAcertadas.size());
                            editor.apply();*/

                            startActivity(new Intent(PantallaResponder.this, PantallaResultados.class));
                        }
                    }
                });
            }
        });
    }
}