package Modelo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo extends Figura{

    private float radio;

    public Circulo(float x, float y,boolean rellenado, float radio) {
        super(x, y,rellenado);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public boolean estaDentro(float x, float y) {

        boolean dentro = false;

        if(((x + radio) >= this.getPosicionX()) && ((y - radio)<= this.getPosicionY())){

            dentro = true;
        }
        return dentro;
    }

    public boolean encajan(CirculoVacio cv) {

        double distancia = Math.sqrt(Math.pow(this.getPosicionX() - cv.getPosicionX(), 2) + Math.pow(this.getPosicionY() - cv.getPosicionY(), 2));
        return distancia + this.radio <= cv.getRadioVacio();
    }

    public void onDraw(int x, int y, Canvas canvas, Paint paint) {

        canvas.drawCircle(x,y,radio,paint);
    }
}
