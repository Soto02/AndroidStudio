package com.example.recuperacionignacio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recuperacionignacio.dao.DbHelper;
import com.example.recuperacionignacio.databinding.ActivityMainBinding;
import com.example.recuperacionignacio.databinding.ActivityPantallaInsertarCitaBinding;

public class PantallaInsertarCita extends AppCompatActivity {
    private ActivityPantallaInsertarCitaBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_insertar_cita);

        binding = ActivityPantallaInsertarCitaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);
    }

    public void insertarCita(View view) {
        String frase = binding.edtFrase.getText().toString();
        String autor = binding.edtAutor.getText().toString();

        if (!frase.isEmpty() && !autor.isEmpty()) {
            dbHelper.insertarCita(frase, autor);
            Toast.makeText(PantallaInsertarCita.this, "Cita insertada correctamente", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(PantallaInsertarCita.this, "Rellena ambos campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver(View view) {
        finish();
    }
}