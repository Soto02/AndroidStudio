package Modelo;

import android.graphics.Canvas;

public abstract class Figura {

    private int id;
    private float posicionX,posicionY;
    private boolean pulsado;

    public Figura(float x, float y, int id) {
        this.posicionX = x;
        this.posicionY = y;
        this.id = id;
        pulsado = false;
    }

    public float getPosicionX() {
        return posicionX;
    }
    public float getPosicionY() {
        return posicionY;
    }
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }
    public void setPosicionY(float posicionY) {
        this.posicionY = posicionY;
    }

    public boolean isPulsado() {
        return pulsado;
    }

    public abstract boolean estaDentro(float posX, float posY);

    public abstract void onDraw(int x, int y, Canvas canvas);
}
