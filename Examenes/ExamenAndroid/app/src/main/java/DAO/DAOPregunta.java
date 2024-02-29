package DAO;

import android.content.Context;

import java.util.ArrayList;

import Modelo.AdaptadorBD;
import Modelo.Pregunta;

public class DAOPregunta {

    private static DAOPregunta daoPregunta = null;
    private static AdaptadorBD adaptadorBD = null;

    private DAOPregunta() {}

    public static DAOPregunta getInstance(Context context) {
        if(daoPregunta == null){
            daoPregunta = new DAOPregunta();
        }
        if(adaptadorBD == null){
            adaptadorBD = new AdaptadorBD(context);
            adaptadorBD.insertarPalabra("Coco");
            adaptadorBD.insertarPalabra("Perro");
            adaptadorBD.insertarPalabra("Casa");
            adaptadorBD.insertarPalabra("Instituto");
            adaptadorBD.insertarPalabra("Fantasma");
            adaptadorBD.insertarPalabra("Sierra");
            adaptadorBD.insertarPalabra("Montaña");
            adaptadorBD.insertarPalabra("Aguila");
            adaptadorBD.insertarPalabra("Pelicula");
            adaptadorBD.insertarPalabra("Jabon");
            adaptadorBD.insertarPalabra("Avioneta");
            adaptadorBD.insertarPalabra("Sepulcro");
            adaptadorBD.insertarPalabra("Abdominales");
            adaptadorBD.insertarPalabra("Anillo");
            adaptadorBD.insertarPalabra("Oredenador");
            adaptadorBD.insertarPalabra("Pizarra");
            adaptadorBD.insertarPalabra("Cama");
            adaptadorBD.insertarPalabra("Arbol");
            adaptadorBD.insertarPalabra("Luz");
            adaptadorBD.insertarPalabra("Jineta");
        }
        return daoPregunta;
    }
    public ArrayList<Pregunta> getPalabras(){

        return adaptadorBD.obtenerPalabras();
    }
}
