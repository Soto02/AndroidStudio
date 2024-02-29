package Modelo;

import android.content.Context;

import java.util.ArrayList;

import DAO.DAOPregunta;

public class Servicio  {
    DAOPregunta daoPregunta;

    public Servicio(Context context) {
        daoPregunta = DAOPregunta.getInstance(context);
    }

    public ArrayList<Pregunta> getServicioPalabras() {
        return daoPregunta.getPalabras();
    }
}
