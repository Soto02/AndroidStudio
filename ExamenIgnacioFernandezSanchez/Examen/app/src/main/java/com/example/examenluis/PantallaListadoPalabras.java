package com.example.examenluis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import DBHelper.DbHelper;

public class PantallaListadoPalabras extends AppCompatActivity {

    private DbHelper dbHelper = new DbHelper(this);
    private List<String> palabras;

    SQLiteDatabase dbWrite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_listado_palabras);

        dbWrite = new DbHelper(this).getWritableDatabase();

        palabras = dbHelper.getPalabrasDificil();

        ListView txtLista = findViewById(R.id.listaPalabras);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, palabras);

        txtLista.setAdapter(adapter);

        txtLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog = new AlertDialog.Builder(PantallaListadoPalabras.this).create();
                alertDialog.setTitle("¿Quieres borrar la palabra?");
                alertDialog.setMessage("Selecciona una opcion");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Borrar", (dialog, which) -> {
                    borrarPalabra(txtLista.getItemAtPosition(position).toString());
                    txtLista.setAdapter(new ArrayAdapter<String>(PantallaListadoPalabras.this, android.R.layout.simple_list_item_1, palabras));
                });
                alertDialog.show();
            }
        });

        Button btnSalir = (Button) findViewById(R.id.btnSalirLista);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaListadoPalabras.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void borrarPalabra(String palabra) {
        this.palabras.remove(palabra);
        this.dbHelper.borrarPalabra(dbWrite, palabra);
    }
}