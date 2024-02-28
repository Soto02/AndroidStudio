package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scapecity.R;

public class MainActivity extends AppCompatActivity {

    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtNombre = findViewById(R.id.txtNombre);
        nombre = txtNombre.getText().toString();

        Button btnJugar = (Button) findViewById(R.id.btnJugar);


        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = txtNombre.getText().toString();
                if (nombre.equals("")) {
                    Toast.makeText(getApplicationContext(), "Tienes que insertar un nombre",Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences prefs = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nombre", nombre);
                    editor.apply();
                    Toast.makeText(getApplicationContext(),"Empieza el juego " + nombre.toString(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button btnPuntuacion = (Button) findViewById(R.id.btnPuntacion);

        btnPuntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });

        Button btnConfig = (Button) findViewById(R.id.btnConfiguracion);

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
                startActivity(intent);
            }
        });

        Button btnSalir = (Button) findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}