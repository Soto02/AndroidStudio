package com.example.proyectaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Pojo.Persona;
import Pojo.Servicio;
import Pojo.TipoLista;

public class MainActivity extends AppCompatActivity {

    private EditText txtId, txtNombre, txtEdad;
    private ListView listPersonas;
    public static ArrayList<Persona> personas = new ArrayList();
    private TipoLista tipo = TipoLista.LISTA_COMPLETA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Servicio.getInstance(this);
        Servicio.getInstance().conexionBD.abrirBD();


        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        listPersonas = findViewById(R.id.listPersonas);

        cargarLista();

        listPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ActivityInfo.class);
                i.putExtra("persona", personas.get(position));
                startActivity(i);
            }
        });

        cargarPreferencias();

    }

    public void agregarPersona(View v) {
        Servicio.getInstance().agregarPersona(Integer.parseInt(txtId.getText().toString()), txtNombre.getText().toString(), Integer.parseInt(txtEdad.getText().toString()));
        cargarLista();
        Toast.makeText(this, "Añadido correctamente", Toast.LENGTH_SHORT).show();
    }

    public void borrarPersona(View v) {
        Servicio.getInstance().borrarPersona(Integer.parseInt(txtId.getText().toString()));
        cargarLista();
        Toast.makeText(this, "Borrado correctamente", Toast.LENGTH_SHORT).show();
    }

    public void cargarLista() {
        personas.clear();
        ArrayAdapter<Persona> adapter;
        if(tipo == TipoLista.LISTA_COMPLETA  ) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Servicio.getInstance().conexionBD.getPersonas());
        } else {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Servicio.getInstance().conexionBD.getXPersonas(5));
        }

        listPersonas.setAdapter(adapter);
    }

    public void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
        String valor = preferences.getString("lista", "");
        if(valor.equals("todos")) {
            tipo = TipoLista.LISTA_COMPLETA;
        } else {
            tipo = TipoLista.LISTA_CINCO;
        }

    }
    public void recargarLista(View v) {
        cargarLista();
    }












}