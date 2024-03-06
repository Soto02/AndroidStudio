package com.example.recuperacionignacio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recuperacionignacio.clases.Cita;
import com.example.recuperacionignacio.dao.DbHelper;
import com.example.recuperacionignacio.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);

        List<Cita> citas = dbHelper.getCitas();
    }

    public void irPantallaInsertarCita(View view) {
        startActivity(new Intent(this, PantallaInsertarCita.class));
    }

    public void irPantallaListarCitas(View view) {
        startActivity(new Intent(this, PantallaListarCitas.class));
    }

    public void borrarDatos(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Borrar citas");
        alertDialogBuilder.setMessage("Se borrarán todas las citas");

        alertDialogBuilder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dbHelper.eliminarCitas();
                Toast.makeText(MainActivity.this, "Citas eliminadas correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void irPantallaCitaDia(View view) {
        startActivity(new Intent(this, PantallaCitaDia.class));
    }

    public void salir(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Salir");
        alertDialogBuilder.setMessage("¿Desea salir?");

        alertDialogBuilder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });

        alertDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void irPantallaConfiguracion(View view) {
        startActivity(new Intent(this, PantallaConfiguracion.class));
    }
}