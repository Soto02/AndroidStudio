package com.example.sprites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements SurfaceHolder.Callback  {

    private Bitmap bmp;
    private Sprite sprite;
    private GameLoopThread gameLoopThread;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private List<TempSprite> temps = new ArrayList<TempSprite>();
    private Long lastClick;
    private Bitmap bmpBlood;

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameLoopThread = new GameLoopThread(getHolder(), this);
        gameLoopThread.setRunnig(true);
        gameLoopThread.start();
        bmpBlood = BitmapFactory.decodeResource(getResources(), R.drawable.blood1);
        //bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bad1);
        //sprite = new Sprite(this, bmp);
        createSprites();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        //sprite.onDraw(canvas);
        for(Sprite sprite : sprites) {
            sprite.onDraw(canvas);
        }
        for(int i = temps.size() -1; i >=0; i--) {
            temps.get(i).onDraw(canvas);
        }
    }

    private void createSprites() {
        sprites.add(createSprite(R.drawable.bad1));
        sprites.add(createSprite(R.drawable.bad2));
        sprites.add(createSprite(R.drawable.bad3));
        sprites.add(createSprite(R.drawable.bad4));
        sprites.add(createSprite(R.drawable.bad5));
        sprites.add(createSprite(R.drawable.bad6));
    }

    private Sprite createSprite(int resource) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
        return new Sprite(this,bmp);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //if(System.currentTimeMillis() - lastClick > 500) {
            //lastClick = System.currentTimeMillis();
            float x = event.getX();
            float y = event.getY();
            //synchronized (getHolder()) {
                boolean muerto = false;
                for (int i = sprites.size()-1; i>=0 && !muerto; i--) {
                    Sprite sprite = sprites.get(i);
                    if(sprite.isCollition(event.getX(), event.getY())) {
                        sprites.remove(sprite);
                        temps.add(new TempSprite(temps,this, x,y, bmpBlood));
                        muerto = true;
                    }
                }
                return muerto;
            //}
        //}
        //return true;
    }

}
