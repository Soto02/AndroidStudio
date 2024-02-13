package Modelo;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Figura {

    private int id;
    private static int ID = 0;
    private float posicionX,posicionY;
    private boolean rellenado;

    public Figura(float x, float y, boolean rellenado) {
        this.posicionX = x;
        this.posicionY = y;
        this.id = ID++;
        this.rellenado = rellenado;
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

    public boolean isRellenado() {
        return rellenado;
    }

    public abstract boolean estaDentro(float posX, float posY);

    public abstract void onDraw(int x, int y, Canvas canvas, Paint paint);
}
