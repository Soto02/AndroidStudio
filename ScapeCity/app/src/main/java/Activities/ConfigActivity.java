package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scapecity.R;

public class ConfigActivity extends AppCompatActivity {

    private int nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        TextView txtNivel = findViewById(R.id.txtNivel);
        SeekBar sbNivel = findViewById(R.id.sbNivel);
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);

        SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);

        if (preferences.getInt("nivel", 0) == 0) {
            txtNivel.setText("Fácil");
            nivel = 0;
        } else if (preferences.getInt("nivel", 0) == 1) {
            txtNivel.setText("Medio");
            nivel = 1;
        } else if (preferences.getInt("nivel", 0) == 2) {
            txtNivel.setText("Difícil");
            nivel = 2;
        }

        sbNivel.setProgress(preferences.getInt("nivel", 0));

        sbNivel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==0){
                    txtNivel.setText("Fácil");
                    nivel = 0;
                }else if(progress==1){
                    txtNivel.setText("Medio");
                    nivel = 1;
                }else if(progress==2){
                    txtNivel.setText("Difícil");
                    nivel = 2;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("nivel", nivel);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Nivel guardado",Toast.LENGTH_LONG).show();
            }
        });

        Button btnSalir = (Button) findViewById(R.id.btnVolverConfig);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}