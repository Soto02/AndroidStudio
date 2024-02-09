package Modelo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Rectangulo extends Figura{

    private float ancho, alto;

    public Rectangulo(float x, float y,int id, float ancho, float alto) {
        super(x, y,id);
        this.ancho = ancho;
        this.alto = alto;
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

    public boolean estaDentro(float posX, float posY) {

        boolean dentro = false;

        if(((posX+ancho) >= this.getPosicionX()) && (posY-alto <= this.getPosicionY())) {
            dentro = true;
        }
        return dentro;
    }

    public void onDraw(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawRect(x,y,x+ancho,y-alto,paint);
    }
}
