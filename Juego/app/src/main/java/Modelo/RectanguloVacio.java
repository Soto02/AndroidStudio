package Modelo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class RectanguloVacio extends Figura{

    private float anchoVacio, altoVacio;

    public RectanguloVacio(float x, float y, int id, float ancho, float alto) {
        super(x, y, id);
        this.anchoVacio = ancho;
        this.altoVacio = alto;
    }

    public float getAnchoVacio() {
        return anchoVacio;
    }

    public void setAnchoVacio(float anchoVacio) {
        this.anchoVacio = anchoVacio;
    }

    public float getAltoVacio() {
        return altoVacio;
    }

    public void setAltoVacio(float altoVacio) {
        this.altoVacio = altoVacio;
    }

    @Override
    public boolean estaDentro(float posX, float posY) {
        boolean dentro = false;

        if(((posX+ anchoVacio) >= this.getPosicionX()) && ((posY- altoVacio) <= this.getPosicionY())) {
            dentro = true;
        }
        return dentro;
    }

    @Override
    public void onDraw(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(x,y,x+ anchoVacio,y- altoVacio,paint);
    }
}
