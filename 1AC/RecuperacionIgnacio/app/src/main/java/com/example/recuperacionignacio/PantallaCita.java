package com.example.recuperacionignacio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.recuperacionignacio.clases.Cita;
import com.example.recuperacionignacio.dao.DbHelper;
import com.example.recuperacionignacio.databinding.ActivityPantallaCitaBinding;
import com.example.recuperacionignacio.databinding.ActivityPantallaListarCitasBinding;

import java.util.List;

public class PantallaCita extends AppCompatActivity {
    private ActivityPantallaCitaBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cita);

        binding = ActivityPantallaCitaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);

        SharedPreferences citaElegidaPreferences = getSharedPreferences("citaElegida", Context.MODE_PRIVATE);
        String frase = citaElegidaPreferences.getString("frase", "");

        List<Cita> citas = dbHelper.getCitas();

        Cita citaElegida = null;

        for (Cita cita : citas) {
            if (cita.getFrase().equals(frase)) {
                citaElegida = cita;
            }
        }

        binding.txtFrase.setText(frase);
        binding.txtAutor.setText(citaElegida.getAutor());
        binding.txtNumeroveces.setText(citaElegida.getNumeroVeces() + "");

        int valoracion = citaElegida.getValoracion();

        switch (valoracion) {
            case 0:
                binding.rbMala.setChecked(true);
                break;
            case 1:
                binding.rbRegular.setChecked(true);
                break;
            case 2:
                binding.rbBuena.setChecked(true);
                break;
            case 3:
                binding.rbMuyBuena.setChecked(true);
                break;
            default:
                break;
        }

        binding.rgValoraciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                int valoracion = 2;

                if (id == binding.rbMala.getId()) {
                    valoracion = 0;
                } else if (id == binding.rbRegular.getId()) {
                    valoracion = 1;
                } else if (id == binding.rbBuena.getId()) {
                    valoracion = 2;
                } else if (id == binding.rbMuyBuena.getId()) {
                    valoracion = 3;
                }

                dbHelper.modificarCita(frase, valoracion);
            }
        });
    }

    public void volver(View view) {
        finish();
    }
}