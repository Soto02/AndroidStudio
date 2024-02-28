package Modelo;

import android.graphics.Canvas;

public abstract class Figura {
    public abstract void dibujar(Canvas canvas);
    public abstract boolean comprobarSiTocoDentro(float posX, float posY);
}
