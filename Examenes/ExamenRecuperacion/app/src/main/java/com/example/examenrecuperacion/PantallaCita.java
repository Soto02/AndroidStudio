package com.example.examenrecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import DbHelper.DBHelper;

public class PantallaCita extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private Button btnVolver;
    private List<String> citas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cita);

        SharedPreferences numCitaPreferences = getSharedPreferences("numCitas", MODE_PRIVATE);
        int numeroCitas =numCitaPreferences.getInt("cita", 1);

        TextView numCitas = findViewById(R.id.txtNumCita);

        if(numeroCitas == 0) {
            numCitas.setText("Numero de citas=1");
            citas =dbHelper.getCitaUno();
        } else if(numeroCitas == 1) {
            numCitas.setText("Numero de citas=2");
            citas = dbHelper.getCitaDos();
        } else if(numeroCitas == 2) {
            numCitas.setText("Numero de citas=3");
            citas = dbHelper.getCitaTres();
        }

        btnVolver = (Button) findViewById(R.id.btnVolverCita);
        ListView txtCita = findViewById(R.id.txtCita);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaCita.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citas);

        txtCita.setAdapter(adapter);

    }
}