package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPuntuacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);

        Button botonVolver = (Button) findViewById(R.id.btnVolverPuntuacion);
        botonVolver.setBackgroundColor(getResources().getColor(R.color.blue));

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPuntuacion.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}