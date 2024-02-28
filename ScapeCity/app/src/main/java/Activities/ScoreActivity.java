package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.scapecity.Conexion;
import com.example.scapecity.R;
import com.example.scapecity.Tabla;

import java.util.ArrayList;

import Modelo.Puntuacion;

public class ScoreActivity extends AppCompatActivity {

    private ListView lvPuntuacion;
    private ArrayList<String> listaNombre;
    private ArrayList<Puntuacion> listaPuntuaciones;
    private Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        conexion = new Conexion(getApplicationContext(), "bd_puntuaciones", null, 1);

        lvPuntuacion = findViewById(R.id.lvPuntuaciones);

        consultarListaPuntuaciones();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombre);
        lvPuntuacion.setAdapter(adaptador);

        lvPuntuacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String info = "Puntos: " + listaPuntuaciones.get(position).getPuntos() + "\n";
                info += "Nombre: " + listaPuntuaciones.get(position).getNombre() + "\n";

                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSalir = (Button) findViewById(R.id.btnVolverPunt);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void consultarListaPuntuaciones() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Puntuacion puntuacion;
        listaPuntuaciones = new ArrayList<Puntuacion>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Tabla.TABLA_PUNTUACIONES +" ORDER BY "+ Tabla.PUNTUACION +" DESC",null);

        while(cursor.moveToNext()) {
            puntuacion = new Puntuacion();
            puntuacion.setPuntos(cursor.getString(1));
            puntuacion.setNombre(cursor.getString(0));

            listaPuntuaciones.add(puntuacion);
        }
        obtenerLista();
    }

    public void obtenerLista() {
        listaNombre = new ArrayList<String>();

        for (int i = 0; i < listaPuntuaciones.size(); i++) {
            listaNombre.add(listaPuntuaciones.get(i).getPuntos() + " - " + listaPuntuaciones.get(i).getNombre());
        }
    }

}