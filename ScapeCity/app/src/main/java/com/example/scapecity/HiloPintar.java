package com.example.scapecity;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class HiloPintar extends Thread{

    private SurfaceHolder sh;
    private GameView view;
    private boolean run;

    public HiloPintar(SurfaceHolder sh, GameView view){
        this.sh = sh;
        this.view = view;
        run = false;
    }

    public void setRunning(boolean run){
        this.run = run;
    }

    public void  run(){
        Canvas canvas;
        while (run){
            canvas = null;
            try {
                canvas = sh.lockCanvas(null);

                if(canvas != null){
                    synchronized (sh){
                        view.postInvalidate();
                    }
                }
            }finally {
                if(canvas != null){
                    sh.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
