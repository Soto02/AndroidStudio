package com.example.recuperacionignacio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.recuperacionignacio.clases.Cita;
import com.example.recuperacionignacio.dao.DbHelper;
import com.example.recuperacionignacio.databinding.ActivityMainBinding;
import com.example.recuperacionignacio.databinding.ActivityPantallaListarCitasBinding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PantallaListarCitas extends AppCompatActivity {
    private ActivityPantallaListarCitasBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_listar_citas);

        binding = ActivityPantallaListarCitasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);

        List<Cita> citas = dbHelper.getCitas();

        List<String> frases = new ArrayList<>();

        for (Cita cita : citas) {
            frases.add(cita.getFrase());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, frases);
        binding.lstCitas.setAdapter(adapter);

        binding.lstCitas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                SharedPreferences citaElegidaPreferences = getSharedPreferences("citaElegida", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = citaElegidaPreferences.edit();
                editor.putString("frase", selectedItem);
                editor.apply();

                startActivity(new Intent(PantallaListarCitas.this, PantallaCita.class));
            }
        });
    }

    public void volver(View view) {
        finish();
    }
}