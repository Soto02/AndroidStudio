package Modelo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo extends Figura{

    private float radio;

    public Circulo(float x, float y,int id, float radio) {
        super(x, y,id);
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

    public void onDraw(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x,y,radio,paint);
    }
}
