package com.example.recuperacionignacio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.recuperacionignacio.dao.DbHelper;
import com.example.recuperacionignacio.databinding.ActivityPantallaCitaBinding;
import com.example.recuperacionignacio.databinding.ActivityPantallaConfiguracionBinding;

public class PantallaConfiguracion extends AppCompatActivity {
    private ActivityPantallaConfiguracionBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_configuracion);

        binding = ActivityPantallaConfiguracionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);


        SharedPreferences numeroCitasPreferences = getSharedPreferences("numeroCitas", Context.MODE_PRIVATE);
        int numeroCitas = numeroCitasPreferences.getInt("numeroCitas", 1);

        switch (numeroCitas) {
            case 1:
                binding.rb1.setChecked(true);
                break;
            case 2:
                binding.rb2.setChecked(true);
                break;
            case 3:
                binding.rb3.setChecked(true);
                break;
            default:
                break;
        }


        binding.rgNumeroCitas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                int numeroVeces = 1;

                if (id == binding.rb1.getId()) {
                    numeroVeces = 0;
                } else if (id == binding.rb2.getId()) {
                    numeroVeces = 1;
                } else if (id == binding.rb3.getId()) {
                    numeroVeces = 2;
                }

                SharedPreferences.Editor editor = numeroCitasPreferences.edit();
                editor.putInt("numeroCitas", numeroVeces);
                editor.apply();
            }
        });
    }

    public void volver(View view) {
        finish();
    }
}