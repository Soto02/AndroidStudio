package Modelo;

import android.graphics.Canvas;

public class Rectangulo extends Figura{

    private float x, y, ancho, alto;

    public Rectangulo(float x, float y, float ancho, float alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    @Override
    public void dibujar(Canvas canvas) {}

    @Override
    public boolean comprobarSiTocoDentro(float posX, float posY) {
        boolean dentro = false;

        if(((posX+ancho) >= this.getX()) && (posY-alto <= this.getY())) {
            dentro = true;
        }
        return dentro;
    }
}
