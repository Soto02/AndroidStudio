package com.example.scapecity;

public class Tabla {

    public static final String TABLA_PUNTUACIONES="puntuaciones";
    public static final String NOMBRE="nombre";
    public static final String PUNTUACION="tiempo";

    public static final String CREAR_TABLA_RECORDS="CREATE TABLE " +
            ""+TABLA_PUNTUACIONES+" ("+NOMBRE+" TEXT,"
            +PUNTUACION+" DOUBLE)";
}
