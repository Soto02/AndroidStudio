package com.example.juego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import Modelo.Circulo;
import Modelo.Figura;
import Modelo.Puntuacion;
import Modelo.Rectangulo;

public class DragAndDropView extends SurfaceView implements SurfaceHolder.Callback {

    private HiloPintar thread;
    private int figuraActiva;
    private ArrayList<Figura> figuras;
    private Puntuacion puntuacion;

    public DragAndDropView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public List<Integer> generarPosicionRandom() {
        int maximoX = getWidth()-100;
        int maximoY = getHeight()-100;
        int x = (int) (Math.random() * maximoX);
        int y = (int) (Math.random() * maximoY);

        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);

        return list;

    }

    public void agregarRectangulo() {
        int x = generarPosicionRandom().get(0);
        int y = generarPosicionRandom().get(1);
        int anchoAlto = (int) (Math.random() * 300 + 50);

        Rectangulo r1 = new Rectangulo(x,y,false, anchoAlto, anchoAlto);
        figuras.add(r1);

        x = generarPosicionRandom().get(0);
        y = generarPosicionRandom().get(1);

        Rectangulo r2 = new Rectangulo(x,y,true, anchoAlto, anchoAlto);
        figuras.add(r2);
    }

    public void agregarCirculo() {
        int x = generarPosicionRandom().get(0);
        int y = generarPosicionRandom().get(1);
        int radio = (int) (Math.random() * 200 + 25);

        Circulo c1 = new Circulo(x,y,false, radio);
        figuras.add(c1);

        x = generarPosicionRandom().get(0);
        y = generarPosicionRandom().get(1);

        Circulo c2 = new Circulo(x,y,true, radio);
        figuras.add(c2);
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

            Paint p = new Paint();
            p.setColor(Color.BLUE);

            if(figura.isRellenado()) {
                p.setStyle(Paint.Style.FILL);
            } else {
                p.setStyle(Paint.Style.STROKE);
                p.setStrokeWidth(4);
            }

            if(figura instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) figura;
                r.onDraw((int) r.getPosicionX(), (int) r.getPosicionY(), canvas,p);

            }else if(figura instanceof Circulo){
                Circulo c = (Circulo) figura;
                c.onDraw((int) c.getPosicionX(), (int) c.getPosicionY(), canvas,p);

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
                    figuraActiva = -1;
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
                            encajan(figura);
                        }
                    }

                break;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void encajan(Figura figura) {
        List<Figura> eliminadas = new ArrayList<>();

        for(Figura f : figuras) {
            if (!f.isRellenado()) {
                float margen = 5;

                if (Math.abs(f.getPosicionX() - figura.getPosicionX()) < margen && Math.abs(f.getPosicionY() - figura.getPosicionY()) < margen) {
                    eliminadas.add(f);
                    eliminadas.add(figura);
                }
            }
        }
        for (Figura f : eliminadas) {
            figuras.remove(f);
        }
        if(!eliminadas.isEmpty()) {
            puntuacion.actualizarPuntuacion(1);
            invalidate();
        }
    }

    public void setPuntuacion(Puntuacion puntuacion) {
        this.puntuacion = puntuacion;
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
