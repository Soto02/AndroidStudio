package com.example.juego;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import Modelo.Circulo;
import Modelo.Figura;
import Modelo.Rectangulo;

public class DragAndDropView extends SurfaceView implements SurfaceHolder.Callback {

    private HiloPintar thread;
    private Rectangulo rectangulo;
    private int figuraActiva;
    private ArrayList<Figura> figuras;

    public DragAndDropView(Context context) {
        super(context);
        getHolder().addCallback(this);

        //rectangulo = new Rectangulo(100,100,200,200);

        //  setBackgroundColor(Color.WHITE);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

        int id = 0;

        figuras = new ArrayList<Figura>();
        figuras.add(new Rectangulo(200, 500, id++,200, 200));
        figuras.add(new Circulo(200,200, id++, 100));

        thread = new HiloPintar(getHolder(),this);
        thread.setRunnig(true);
        thread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

        boolean retry = true;

        thread.setRunnig(false);

        while(retry) {
            try{
                thread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        for(Figura figura: figuras) {
            if(figura instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) figura;
                r.onDraw((int) r.getPosicionX(), (int) r.getPosicionY(), canvas);
            }else {
                Circulo c = (Circulo) figura;
                c.onDraw((int) c.getPosicionX(), (int) c.getPosicionY(), canvas);
            }
        }


        //Paint paint = new Paint();
        //paint.setColor(Color.RED);

        //canvas.drawRect(rectangulo.getPosicionX(),rectangulo.getPosicionY(),rectangulo.getPosicionX()+rectangulo.getAncho(),rectangulo.getPosicionY()+rectangulo.getAlto() ,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x =  event.getX();
        float y =(int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                for (Figura figura: figuras){
                    if(figura instanceof Circulo){
                        Circulo c = (Circulo) figura;
                        float distanciaX = x - c.getPosicionX();
                        float distanciaY = y - c.getPosicionY();
                        if(Math.pow(c.getRadio(),2) >= (Math.pow(distanciaX,2) + Math.pow(distanciaY,2))){
                            figuraActiva = c.getId();
                        }
                    }else{
                        Rectangulo r = (Rectangulo) figura;
                        if(r.estaDentro(x,y)){
                            figuraActiva = r.getId();
                        }else {
                            figuraActiva = -1;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for (Figura figura: figuras){
                    if(figura.getId() == figuraActiva){
                        figura.setPosicionX(x);
                        figura.setPosicionY(y);
                    }
                }
                break;
        }
        return true;
    }
}
