package com.example.scapecity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

public class Sprite {
    private static final int BMP_ROWS = 4;
    private static final int BMP_COLUMNS = 4;
    private static final int[] DIRECTION_TO_ANIMATION_MAP = {0, 1, 3, 2, 4};
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private GameView gameView;
    private Bitmap bmp;
    private int width;
    private int height;
    private int currentFrame = 0;
    private boolean moverIzq, moverDer;

    //Construccion del objeto
    public Sprite(GameView gameView, Bitmap bmp) {
        this.gameView = gameView;
        this.bmp = bmp;
        width = bmp.getWidth() / BMP_COLUMNS;
        height = bmp.getHeight() / BMP_ROWS;
        x = (int) (gameView.getWidth()/2-width/2);
        y= (int) (gameView.getHeight()-(gameView.getHeight()/4.75f));
        xSpeed = 15;
        ySpeed = 10;
    }

    //Como queremos que se mueva
    public void update() {
        //Comprobar si toca el filo izquierdo de la pantalla
        if(x<0){
            //Ajusto la posicion para que el sprite no salga
            x=1;
            //Comprobar si toca el filo derecho de la pantalla
        }else if(x>gameView.getWidth()-width-xSpeed){
            //Ajusto la posicion para que el sprite no salga
            x=gameView.getWidth()-width-xSpeed;
        }else {
            //Si no toca ningun borde
            if (moverIzq) {
                //ySpeed=-10;
                if(xSpeed>0){ //Sila velocidad es
                    xSpeed=-xSpeed; // Invierte la dirección horizontal del sprite
                }
                x +=xSpeed;
            } else if (moverDer) {
                //ySpeed=10;
                if(xSpeed<0){
                    xSpeed=-xSpeed;
                }
                x += xSpeed;
            }
            currentFrame = ++currentFrame % BMP_COLUMNS; // Actualiza la posición x del sprite según su velocidad horizontal
        }
    }

    public void moverDer() { moverDer = true;}
    public void moverIzq() { moverIzq = true;}

    //Detener el movimiento del sprite
    public void noMover() {
        moverDer = false;
        moverIzq = false;

        y = (int)(gameView.getHeight()-(gameView.getHeight()/4.75f));
    }

    //Pintamos el objeto
    public void onDraw(Canvas canvas) {
        if (moverDer || moverIzq) {
            update();
        }
        int srcX = currentFrame * width;
        int srcY = getAnimationRow() * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x+width, y+height);
        canvas.drawBitmap(bmp,src,dst,null);

    }

    //Obtener fila de animacion del sprite
    private int getAnimationRow() {
        double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) +2);
        int direction = (int) Math.round(dirDouble) % BMP_ROWS;
        return DIRECTION_TO_ANIMATION_MAP[direction];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
