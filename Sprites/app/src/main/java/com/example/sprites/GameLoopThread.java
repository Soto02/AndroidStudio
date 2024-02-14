package com.example.sprites;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoopThread extends Thread{

    static final long FPS = 10;
    private SurfaceHolder sh;
    private GameView view;
    private boolean run;

    public GameLoopThread(SurfaceHolder sh, GameView view) {
        this.sh = sh;
        this.view = view;
        run = false;
    }

    public void setRunnig(boolean run) {
        this.run = run;
    }

    public void run() {
        long ticksPS = 1000/FPS;
        long startTime;
        long sleepTime;

        Canvas canvas;
        while(run) {
            canvas = null;
            startTime = System.currentTimeMillis();

            try{
                //canvas = sh.lockCanvas(null);
                //synchronized (sh) {
                    //view.postInvalidate();
                //}
                canvas = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {
                    view.postInvalidate();
                }

            } finally {
                //if(canvas != null) sh.unlockCanvasAndPost(canvas);
                if(canvas != null) view.getHolder().unlockCanvasAndPost(canvas);
            }
            sleepTime = ticksPS-(System.currentTimeMillis() -startTime);
            try {
                if(sleepTime > 0) sleep(sleepTime);
                else sleep(10);
            }catch (Exception e) { }
        }
    }

}

