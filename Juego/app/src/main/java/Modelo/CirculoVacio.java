package Modelo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CirculoVacio extends Figura{

    private float radioVacio;

    public CirculoVacio(float x, float y, int id, float radioVacio) {
        super(x, y, id);
        this.radioVacio = radioVacio;
    }

    public float getRadioVacio() {
        return radioVacio;
    }

    public void setRadioVacio(float radioVacio) {
        this.radioVacio = radioVacio;
    }

    @Override
    public boolean estaDentro(float posX, float posY) {
        boolean dentro = false;

        if(((posX + radioVacio) >= this.getPosicionX()) && ((posX - radioVacio)<= this.getPosicionY())){

            dentro = true;
        }
        return dentro;
    }

    @Override
    public void onDraw(int x, int y, Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(x,y,radioVacio,paint);
    }
}
