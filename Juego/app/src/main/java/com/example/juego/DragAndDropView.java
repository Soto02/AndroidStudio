package com.example.juego;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.Circulo;
import Modelo.CirculoVacio;
import Modelo.Figura;
import Modelo.Rectangulo;
import Modelo.RectanguloVacio;

public class DragAndDropView extends SurfaceView implements SurfaceHolder.Callback {

    private HiloPintar thread;
    private Rectangulo rectangulo;
    private int figuraActiva;
    private ArrayList<Figura> figuras;
    private int puntuacion;

    public DragAndDropView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public void agregarFigura(Figura figura) {
        if(figuras != null) {
            figuras.add(figura);
            invalidate();
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

        int id = 0;

        figuras = new ArrayList<Figura>();

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

            }else if(figura instanceof Circulo){
                Circulo c = (Circulo) figura;
                c.onDraw((int) c.getPosicionX(), (int) c.getPosicionY(), canvas);

            } else if (figura instanceof RectanguloVacio) {
                RectanguloVacio rv = (RectanguloVacio) figura;
                rv.onDraw((int) rv.getPosicionX(),(int) rv.getPosicionY(), canvas);

            } else if (figura instanceof CirculoVacio) {
                CirculoVacio cv = (CirculoVacio) figura;
                cv.onDraw((int) cv.getPosicionX(), (int) cv.getPosicionY(), canvas);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
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
                    detectarColisiones();
                break;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void detectarColisiones() {
        ArrayList<Figura> figuras = colisiones();

        for (Figura figura : figuras) {
            if (figura instanceof Circulo) {
                Circulo c = (Circulo) figura;
                figuras.remove(c);
                puntuacion++;
            } else if (figura instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) figura;
                figuras.remove(r);
                puntuacion++;
            }
            invalidate();
        }
    }

    private ArrayList<Figura> colisiones() {
        ArrayList<Figura> figurasColisionadas = new ArrayList<>();

        for (Figura figura : figuras) {
            if (figura instanceof Circulo) {
                Circulo c = (Circulo) figura;
                for (Figura f : figuras) {
                    if (f instanceof CirculoVacio && c.encajan((CirculoVacio) f)) {
                        figurasColisionadas.add(c);
                    }

                }
            } else if (figura instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) figura;
                for (Figura f : figuras) {
                    if (f instanceof RectanguloVacio && r.encajan((RectanguloVacio) f)) {
                        figurasColisionadas.add(r);
                    }
                }
            }
        }
        return figurasColisionadas;
    }
}
/*
if(figura instanceof Rectangulo && figuraActiva == 0) {
                                Figura rectanguloVacio = null;
                                for (Figura f : figuras) {
                                    if (f.getId() == -1) {
                                        rectanguloVacio = f;
                                        break;
                                    }
                                }
                                if (rectanguloVacio != null)  {

                                    figura.setPosicionX(Math.max(rectanguloVacio.getPosicionX(), Math.min(x, rectanguloVacio.getPosicionX() + ((RectanguloVacio) rectanguloVacio).getAnchoVacio() - ((Rectangulo) figura).getAncho())));
                                    figura.setPosicionY(Math.max(rectanguloVacio.getPosicionY(), Math.min(y, rectanguloVacio.getPosicionY() + ((RectanguloVacio) rectanguloVacio).getAltoVacio() - ((Rectangulo) figura).getAlto())));

                                    if (figura.getPosicionX() == rectanguloVacio.getPosicionX() && figura.getPosicionY() == rectanguloVacio.getPosicionY()) {
                                        figuras.remove(figura);
                                        figuras.remove(rectanguloVacio);
                                    }
                                }

                            }

                            else if (figura instanceof Circulo && figuraActiva == 0) {
                                Figura circuloVacio = null;
                                for (Figura f : figuras) {
                                    if (f.getId() == -1) {
                                        circuloVacio = f;
                                        break;
                                    }
                                }
                                if (circuloVacio != null)  {

                                    figura.setPosicionX(Math.max(circuloVacio.getPosicionX(), Math.min(x, circuloVacio.getPosicionX() + ((RectanguloVacio) circuloVacio).getAnchoVacio() - ((Rectangulo) figura).getAncho())));
                                    figura.setPosicionY(Math.max(circuloVacio.getPosicionY(), Math.min(y, circuloVacio.getPosicionY() + ((RectanguloVacio) circuloVacio).getAltoVacio() - ((Rectangulo) figura).getAlto())));

                                    if (Math.pow((figura.getPosicionX() - circuloVacio.getPosicionX()), 2) + Math.pow((figura.getPosicionY() - circuloVacio.getPosicionY()), 2) <= Math.pow(((CirculoVacio) circuloVacio).getRadioVacio() - ((Circulo) figura).getRadio(), 2)) {
                                        figuras.remove(figura);
                                        figuras.remove(circuloVacio);
                                    }
                                }
                            }
 */
