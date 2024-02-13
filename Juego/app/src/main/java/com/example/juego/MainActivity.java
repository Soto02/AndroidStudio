package com.example.juego;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import Modelo.Puntuacion;

public class MainActivity extends AppCompatActivity implements Puntuacion {

    private DragAndDropView dragAndDropView;
    private RelativeLayout relativeLayout;
    private TextView txtPuntos;
    private int puntos;
    private int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dragAndDropView = new DragAndDropView(this);
        dragAndDropView.setBackgroundColor(Color.WHITE);
        dragAndDropView.setPuntuacion(this);
        relativeLayout =findViewById(R.id.relativeLayout);
        relativeLayout.addView(dragAndDropView);

        txtPuntos = findViewById(R.id.txtPuntos);
        puntos = 0;

        Button btnPintarCirculo = (Button) findViewById(R.id.btnCirculo);

        Button btnPintarCuadrado = (Button) findViewById(R.id.btnCuadrado);

        btnPintarCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dragAndDropView.agregarCirculo();
            }
        });

        btnPintarCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dragAndDropView.agregarRectangulo();
            }
        });
    }

    @Override
    public void actualizarPuntuacion(int nuevosPuntos) {
        puntos += nuevosPuntos;
        sumarPuntos();
    }

    private void sumarPuntos() {
        runOnUiThread(() -> txtPuntos.setText(String.valueOf(puntos)));
    }

}
    //requestWindowFeature(Window.FEATURE_NO_TITLE);
    //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    //setContentView(new RenderView(this));

    //textView = new TextView(this);
    //textView.setText("Touch and drag (one finger only)!:");

    //textView.setOnTouchListener(this);
    //setContentView(textView);
/*class RenderView extends View {
        Paint paint;
        Random rand = new Random();

        public RenderView(Context context) {
            super(context);
            paint = new Paint();
        }

        protected void onDraw(Canvas canvas) {
            //canvas.drawRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            canvas.drawRGB(255, 255, 255);
            paint.setColor(Color.RED);
            canvas.drawLine(0,0,canvas.getWidth()-1, canvas.getHeight()-1, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(0xff00ff00);
            canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 40, paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(0x770000ff);
            canvas.drawRect(100,100,200,200,paint);
            //invalidate();


        }
    }*/

/*
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        builder.setLength(0);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                builder.append("down, ");
                break;
            case MotionEvent.ACTION_MOVE:
                builder.append("move, ");
                break;
            case MotionEvent.ACTION_CANCEL:
                builder.append("cancel, ");
                break;
            case MotionEvent.ACTION_UP:
                builder.append("up, ");
                break;
        }
        builder.append(event.getX());
        builder.append(" , ");
        builder.append(event.getY());
        String text = builder.toString();
        Log.d("TouchTest", text);
        textView.setText(text);

        return true;
    }*/

/*
int posX = generarPosicionRandom(relativeLayout.getWidth());
                int posY = generarPosicionRandom(relativeLayout.getHeight());
                int posXv = generarPosicionRandom(relativeLayout.getWidth());
                int posYv = generarPosicionRandom(relativeLayout.getHeight());
                Rectangulo r = new Rectangulo(posX, posY, false, 150, 150);
                RectanguloVacio rv = new RectanguloVacio(posXv, posYv, false, 150, 150);

                dragAndDropView.agregarFigura(r);
                dragAndDropView.agregarFigura(rv);
 */