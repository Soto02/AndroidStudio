package com.example.juego;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class HiloPintar extends Thread{

    private SurfaceHolder sh;
    private DragAndDropView view;
    private boolean run;

    public HiloPintar(SurfaceHolder sh, DragAndDropView view) {
        this.sh = sh;
        this.view = view;
        run = false;
    }

    public void setRunnig(boolean run) {
        this.run = run;
    }

    public void run() {

        Canvas canvas;
        while(run) {
            canvas = null;

            try{
                canvas = sh.lockCanvas(null);
                synchronized (sh) {
                    view.postInvalidate();
                }

            } finally {
                if(canvas != null) sh.unlockCanvasAndPost(canvas);
            }
        }
    }

}
