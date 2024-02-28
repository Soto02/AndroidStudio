package com.example.scapecity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Activities.GameActivity;
import Modelo.Circulo;
import Modelo.Coche;
import Modelo.Figura;
import Modelo.Rectangulo;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private HiloPintar hilo;
    private Paint paint;
    private ArrayList<Figura> figuras;
    private Bitmap carretera, btnIzquierda, btnIzquierdaR, btnDerecha, btnDerechaR, btnSalir, btnSalirR,
            coche, cocheR, gameOver, gameOverR,sueloo, suelooR, explosion, explosionR,  vida1, vida1R, vida2, vida2R, vida3, vida3R;
    private Rectangulo suelo;
    private Coche cochaso;
    private DisplayMetrics metrics = this.getResources().getDisplayMetrics(); //Informa sobre la pantalla (tamaño, densidad, escala)
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private Figura figActiva;
    int bajarCoche, contadorCocheQuieta, contador2, contadorMuerte;
    int maxX = metrics.widthPixels;
    int maxY = metrics.heightPixels;
    float ancho, alto;
    boolean crearCoche, personaTocada, pantallaReset;
    int puntos, tocado, ira;
    int contadorVidas;
    float velocidadCoche = 3f;
    private SoundPool soundPool;
    private int sonidoAccidente, sonidoMuerte;
    private MediaPlayer mySong;
    SharedPreferences preferences = getContext().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);

    //Construccion del objeto
    public GameView(Context context) {
        super(context);
        paint = new Paint();
        getHolder().addCallback(this);

        //Cargar recursos graficos
        carretera = BitmapFactory.decodeResource(getResources(), R.drawable.road2);
        sueloo = BitmapFactory.decodeResource(getResources(), R.drawable.suelob);
        btnIzquierda = BitmapFactory.decodeResource(getResources(), R.drawable.btnleft);
        btnDerecha = BitmapFactory.decodeResource(getResources(), R.drawable.btnright);
        coche = BitmapFactory.decodeResource(getResources(), R.drawable.cochepixelb);
        explosion = BitmapFactory.decodeResource(getResources(), R.drawable.explosion);
        gameOver = BitmapFactory.decodeResource(getResources(), R.drawable.gameoverb);
        vida1 = BitmapFactory.decodeResource(getResources(), R.drawable.vidauno);
        vida2 = BitmapFactory.decodeResource(getResources(), R.drawable.vidados);
        vida3 = BitmapFactory.decodeResource(getResources(), R.drawable.vidatres);
        btnSalir = BitmapFactory.decodeResource(getResources(), R.drawable.exit);
        suelo= new Rectangulo(0, maxY,maxX, maxY-(maxY/6f));

        iniciarBotones(maxX, maxY);

        //Inicializo el soundpool
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.UPSIDE_DOWN_CAKE){
            //creo atributos de audio para soundpool
            AudioAttributes audioAttributes= new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            //creo el soundpool con sus atributos
            soundPool= new SoundPool.Builder().setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else{
            //creo el soundpool para versiones anteriores
            soundPool= new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        }

        //cargo efectos de sonido
        sonidoAccidente = soundPool.load(this.getContext(), R.raw.explosion, 1);
        sonidoMuerte = soundPool.load(this.getContext(), R.raw.muerte, 1);
        //inicializo mediaPlayer para la musica de fondo
        mySong = MediaPlayer.create(getContext(), R.raw.musica);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        createSprites();

        //inicializo el hilo
        hilo = new HiloPintar(getHolder(), this);
        hilo.setRunning(true);
        hilo.start();

        //genero posicion random para la x del coche
        Random random = new Random();
        float i = random.nextInt((int) ((maxX-ancho)-1+1))+1;
        cochaso = new Coche(i, maxY/11f, ancho, alto);
        contadorVidas = 3;
        puntos = 0;
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        //detengo la musica y el hilo
        mySong.stop();
        boolean retry = true;
        hilo.setRunning(false);
        //espero a que acabe le hilo
        while (retry) {
            try {
                hilo.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //obtengo el ancho y alto de la pantalla
        maxX = metrics.widthPixels;
        maxY = metrics.heightPixels;

        //escala a la que quiero pintar las imagenes
        cocheR = Bitmap.createScaledBitmap(coche,(int)(canvas.getWidth()*0.23),(int)(canvas.getWidth()*0.23), false);
        suelooR = Bitmap.createScaledBitmap(sueloo,(int)(canvas.getWidth()*1.2),(int)(canvas.getHeight()*0.18), false);
        btnIzquierdaR = Bitmap.createScaledBitmap(btnIzquierda,(int)(canvas.getWidth()*0.15),(int)(canvas.getWidth()*0.15), false);
        btnDerechaR = Bitmap.createScaledBitmap(btnDerecha,(int)(canvas.getWidth()*0.15),(int)(canvas.getWidth()*0.15), false);
        btnSalirR = Bitmap.createScaledBitmap(btnSalir,(int)(canvas.getWidth()*0.18),(int)(canvas.getWidth()*0.18), false);
        vida1R = Bitmap.createScaledBitmap(vida1,(int)(canvas.getWidth()*0.23),(int)(canvas.getWidth()*0.12), false);
        vida2R = Bitmap.createScaledBitmap(vida2,(int)(canvas.getWidth()*0.23),(int)(canvas.getWidth()*0.12), false);
        vida3R = Bitmap.createScaledBitmap(vida3,(int)(canvas.getWidth()*0.23),(int)(canvas.getWidth()*0.12), false);
        explosionR = Bitmap.createScaledBitmap(explosion,(int)(canvas.getWidth()*0.23),(int)(canvas.getWidth()*0.23), false);
        gameOverR = Bitmap.createScaledBitmap(gameOver,(int)(canvas.getWidth()*1),(int)(canvas.getHeight()*1), false);

        //dimensiones del coche
        ancho = cocheR.getWidth();
        alto = cocheR.getHeight();

        //dibujo los elementos
        canvas.drawBitmap(carretera, 0, 0, paint);
        paint.setColor(Color.RED);
        canvas.drawBitmap(btnIzquierdaR,maxX/10f,maxY-(maxY/4f),paint);
        canvas.drawBitmap(btnDerechaR,maxX-(maxX/4f),maxY-(maxY/4f),paint);
        canvas.drawBitmap(suelooR, -20, maxY - suelooR.getHeight() - 85, paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(canvas.getWidth()/15);
        canvas.drawText("PUNTOS:" + String.valueOf(puntos), 25, canvas.getHeight()/12, paint);

        if(contadorVidas==3){
            contadorMuerte=0;
            canvas.drawBitmap(vida3R,0,0,paint);
            pantallaReset=false;
            mySong.start();
        }else if(contadorVidas==2){
            canvas.drawBitmap(vida2R,0,0,paint);
            pantallaReset=false;
        }else if(contadorVidas==1){
            canvas.drawBitmap(vida1R,0,0,paint);
            pantallaReset=false;
        }

        //dibujar figuras y sprites
        for (Figura figura : figuras) {
            figura.dibujar(canvas);
        }
        for (Sprite sprite : sprites) {
            sprite.onDraw(canvas);
        }

        moverCoche(canvas);
        nuevoCoche(canvas);

        //si no quedan vidas muestra el gamOver
        if(contadorVidas==0){
            if(contadorMuerte==0) {
                mySong.pause();
                soundPool.play(sonidoMuerte, 1, 1, 0, 0, 1);
                contadorMuerte++;
                //guardamos la puntuacion en la bd
                Conexion conn = new Conexion(getContext(), "bd_puntuaciones", null, 1);
                SQLiteDatabase db = conn.getWritableDatabase();
                String insert = "INSERT INTO " + Tabla.TABLA_PUNTUACIONES + " ( " + Tabla.PUNTUACION + "," +
                        Tabla.NOMBRE + ")" + " VALUES ('" + puntos+ "','"
                        + preferences.getString("nombre", "0") + "')";
                db.execSQL(insert);
                db.close();
            }
            //mostrar la pantalla de gameOver
            iniciarBotonesGO(maxX,maxY);
            canvas.drawBitmap(gameOverR,0,-45,paint);
            canvas.drawBitmap(btnSalirR,maxX-(maxX/1.7f),maxY-(maxY/7f),paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(canvas.getWidth()/25);
            canvas.drawText("SALIR", maxX-(maxX/1.8f),maxY-(maxY/25f),paint);
            bajarCoche=maxY/11;
            personaTocada =false;
            pantallaReset=true;

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //Cuando se presiona la pantalla
            case MotionEvent.ACTION_DOWN:

                for(Figura figura: figuras){
                    if(figura.comprobarSiTocoDentro(event.getX(),event.getY())) {
                        figActiva = figura;
                    }
                }

                //convertir figuraActiva en un circulo
                Circulo c=(Circulo) figActiva;

                if (c.getNombre().equals("izquierda")) {
                    c.setColor(Color.TRANSPARENT);
                    sprites.get(0).moverIzq();
                }
                if (c.getNombre().equals("derecha")) {
                    c.setColor(Color.TRANSPARENT);
                    sprites.get(0).moverDer();
                }

                if(pantallaReset) {
                    if (c.getNombre().equals("fin")) {
                        sprites.get(0).noMover();
                        ((Activity) getContext()).finish();

                    }
                }
                break;


            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_CANCEL:
                break;

            //Cuando se levanta el dedo
            case MotionEvent.ACTION_UP:
                Circulo ca=(Circulo) figActiva;
                ca.setColor(Color.TRANSPARENT);
                //reinicio la figuraActiva
                figActiva=null;
                sprites.get(0).noMover(); //detengo el sprite
                break;
        }
        return true;
    }


    private void createSprites() {sprites.add(createSprite(R.drawable.persona2));}
    private Sprite createSprite(int resource) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
        return new Sprite(this,bmp);
    }

    private boolean comprobarChoque(float i, Canvas canvas, int x, int y) {
        return x > i && x < i+ancho && y<bajarCoche+alto;
    }

    private void moverCoche(Canvas canvas) {
            //si el coche llega al suelo
            if(bajarCoche+alto >= suelo.getAlto()) {
                //dibujo una explosion y le pongo sonido
                canvas.drawBitmap(explosionR, cochaso.getX(), bajarCoche, paint);
                soundPool.play(sonidoAccidente,3,3,0,0,1);
                //contador para saber si ha tocado el suelo, si lo toca crearCoche es true
                if(contador2 == 0) {
                    crearCoche = true;
                    contador2++;
                    puntos++;
                }
            } else {
                //si el coche no taca el suelo
                if(!personaTocada && comprobarChoque(cochaso.getX(), canvas, sprites.get(0).getX(), sprites.get(0).getY())) {
                    personaTocada = true;
                    crearCoche = true;

                    //si es menor de 80, el choque se esta manteniendo
                    if(contadorCocheQuieta < 80) {
                        //si se choca, reduce las vidas y reproduce sonido
                        if(contadorCocheQuieta == 0) {
                            contadorVidas--;
                            soundPool.play(sonidoMuerte,3,3,0,0,1);
                            tocado = (int) (bajarCoche);
                            ira = (int) cochaso.getX();
                        }
                        //dibuja la explosion en la posicion del coche
                        canvas.drawBitmap(explosionR, cochaso.getX(), tocado, paint);
                        contadorCocheQuieta++;
                    }
                } else {
                    //si no se choca con la persona
                    if (!crearCoche) {
                        if (!personaTocada) {
                            //velocidad a la que tiene que ir el coche segun el nivel
                            if (preferences.getInt("nivel", 0) == 0) {
                                velocidadCoche = 0.05f;
                            } else if (preferences.getInt("nivel", 0) == 1) {
                                velocidadCoche = 0.075f;
                            }else if (preferences.getInt("nivel", 0) == 2) {
                                velocidadCoche = 0.1f;
                            }

                            bajarCoche += 1 + bajarCoche * velocidadCoche;
                            canvas.drawBitmap(cocheR, cochaso.getX(), bajarCoche, paint);
                            contador2 = 0;
                        } else {
                            contador2=0;

                            //despues de dos segundo establezco personaTocada a false para que sigan callendo coches
                            canvas.drawBitmap(explosionR, ira, tocado, paint);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    personaTocada = false;
                                }

                            }, 2000);
                        }
                    }
                }
            }

    }

    private void nuevoCoche(Canvas canvas) {

        if(crearCoche){
            //establezco el estilo de pintura
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(5);

            //inicializo la posicion del coche en la parte superior de la pantalla
            bajarCoche= (int) (maxY/11f);
            //genero posicion aleatoria
            Random random = new Random();
            final int aleatorio = random.nextInt((int) ((maxX-ancho) - 1 + 1)) + 1;
            //genero coche con la posicion aleatoria
            cochaso= new Coche(aleatorio, maxX/11f, ancho, alto);
            //reinicio el contador
            contadorCocheQuieta=0;
        }
        crearCoche=false;
    }

    public void iniciarBotones(int maxX, int maxY) {
        figuras = new ArrayList<>();
        figuras.add(new Circulo(85+(maxX/10f), 85+maxY-(maxY/4f), 85, "izquierda",Color.TRANSPARENT));
        figuras.add(new Circulo(85+(maxX-(maxX/4f)), 85+(maxY-(maxY/4f)), 85,"derecha",Color.TRANSPARENT));
    }

    public void iniciarBotonesGO(int maxX, int maxY) {
        figuras = new ArrayList<>();
        figuras.add(new Circulo(85+maxX-(maxX/1.75f),85+maxY-(maxY/7f), 85,"fin",Color.TRANSPARENT));
    }
}
