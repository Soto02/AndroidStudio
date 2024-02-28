package Modelo;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circulo extends Figura{

    private float x, y, radio;
    private String nombre;
    private int color;

    public Circulo(float x, float y, float radio, String nombre, int color) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.nombre = nombre;
        this.color = color;
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

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void dibujar(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(color);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y,radio,p);

    }

    @Override
    public boolean comprobarSiTocoDentro(float posX, float posY) {
        boolean dentro = false;

        if(((posX + radio) >= this.getX()) && ((posY - radio)<= this.getY())){
            dentro = true;
        }
        return dentro;
    }
}
