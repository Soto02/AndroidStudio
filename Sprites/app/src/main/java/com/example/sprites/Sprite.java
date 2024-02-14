package com.example.sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceView;

import java.util.Random;

public class Sprite {

    private static final int BMP_ROWS = 4;
    private static final int BMP_COLUMNS = 3;

    private static final int MAX_SPEED = 25;
    private int x = 0;
    private int y = 0;
    private int xSpeed = 10;
    private GameView gameView;
    private Bitmap bmp;
    private int currentFrame = 0;
    private int width;
    private int height;
    private int ySpeed;

    //Construccion del objeto
    public Sprite(GameView gameView, Bitmap bmp) {
        this.gameView = gameView;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;
        Random rnd = new Random();
        x = rnd.nextInt(gameView.getWidth() - width);
        y = rnd.nextInt(gameView.getHeight() - height);
        xSpeed = rnd.nextInt(MAX_SPEED *2 ) -MAX_SPEED;
        ySpeed = rnd.nextInt(MAX_SPEED *2 ) -MAX_SPEED;
    }

    //Como queremos que se mueva
    private void update() {
        if(x>gameView.getWidth() - width -xSpeed || x+xSpeed < 0) {
            xSpeed = -xSpeed;
        }
        x =x+xSpeed;
        if(y > gameView.getHeight() - height - ySpeed || y + ySpeed < 0) {
            ySpeed = -ySpeed;
        }
        y = y + ySpeed;
        currentFrame = ++currentFrame % BMP_COLUMNS;
    }

    //Pintar el objeto
    public void onDraw(Canvas canvas) {
        update();
        int srcX = currentFrame * width;
        int srcY = getAnimationRow() * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x+width, y+height);
        canvas.drawBitmap(bmp,src,dst,null);
    }

    int[] DIRECTION_TOANIMATION_MAP = {3,1,0,2};

    private int getAnimationRow() {
        double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) +2);
        int direction = (int) Math.round(dirDouble) % BMP_ROWS;
        return DIRECTION_TOANIMATION_MAP[direction];
    }

    public boolean isCollition(float x2, float y2) {
        return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
    }
}
