package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AdaptadorBD extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NOMBREBBDD = "BDEntrenaMemoria.db";

    public AdaptadorBD(Context context) {
        super(context, NOMBREBBDD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Preguntas" + "(" +
                "Cod_palabras INTEGER Primary Key AUTOINCREMENT," +
                "Palabra TEXT NOT NULL" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    //Insertar Preguntas Facil
    public long insertarPalabra(String palabra) {
        long id = 0;

        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Palabra", palabra);

            System.out.println("Se añadio correctamente.");
        } catch (Exception ex){
            System.err.println("Hubo un error.");
        }
        return id;
    }
    public ArrayList<Pregunta> obtenerPalabras() {

        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<Pregunta> listaPalabra = new ArrayList<Pregunta>();
        Pregunta palabras;

        Cursor cursorPalabra = bbdd.rawQuery("Select * from Pregunta",null);

        if(cursorPalabra.moveToFirst()){
            do{
                palabras = new Pregunta(cursorPalabra.getString(1));
                listaPalabra.add(palabras);
            }while(cursorPalabra.moveToNext());
        }
        cursorPalabra.close();
        return listaPalabra;
    }
}
