package com.example.examenrecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import DbHelper.DBHelper;
import Modelo.Cita;

public class PantallaListar extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private List<String> citas;
    private Button btnVolver;
    private Cita cita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_listar);

        btnVolver = (Button) findViewById(R.id.btnVolverListar);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaListar.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        citas =dbHelper.getCitas();

        ListView lista = findViewById(R.id.txtListaCitas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citas);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                //String datos = ", autor='" + cita.getAutor() + "', numero de veces='" + cita.getNumVeces() + "', valoracion='" + cita.getValoracion() +"')";
                Toast.makeText(PantallaListar.this, "Seleccionado:" + selected,Toast.LENGTH_LONG).show();
            }
        });


    }
}