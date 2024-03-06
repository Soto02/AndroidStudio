package com.example.recuperacionignacio.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.recuperacionignacio.clases.Cita;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_citas.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createPalabrasQuery = "CREATE TABLE IF NOT EXISTS citas ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "numeroVeces INTEGER, "
                + "frase TEXT, "
                + "valoracion INTEGER, "
                + "autor TEXT)";
        db.execSQL(createPalabrasQuery);

        insertPalabras(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void insertPalabras(SQLiteDatabase db) {
        List<String> palabras = new ArrayList<>();
        palabras.add("A quien madruga dios le ayuda");
        palabras.add("Esto es una frase");
        palabras.add("Otra frase más");
        palabras.add("No sé qué más poner");
        palabras.add("Frase de cita");

        for (String palabra : palabras) {
            ContentValues values = new ContentValues();
            values.put("numeroVeces", 0);
            values.put("frase", palabra);
            values.put("valoracion", 1);
            values.put("autor", "yo");

            db.insert("citas", null, values);
        }
    }

    public void insertarCita(String frase, String autor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("numeroVeces", 0);
        values.put("frase", frase);
        values.put("valoracion", 1);
        values.put("autor", autor);

        db.insert("citas", null, values);
    }

    public List<Cita> getCitas() {
        List<Cita> citas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("citas", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String frase = cursor.getString(cursor.getColumnIndexOrThrow("frase"));
            int numeroVeces = cursor.getInt(cursor.getColumnIndexOrThrow("numeroVeces"));
            int valoracion = cursor.getInt(cursor.getColumnIndexOrThrow("valoracion"));
            String autor = cursor.getString(cursor.getColumnIndexOrThrow("autor"));

            citas.add(new Cita(frase, autor, numeroVeces, valoracion));
        }

        return citas;
    }

    public void eliminarCitas() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("citas", "id != 1 AND id != 2 AND id != 3 AND id != 4 AND id != 5", new String[]{});
    }

    public void modificarCita(String frase, int valoracion) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("valoracion", valoracion);
        db.update("citas", values, "frase = ?", new String[]{frase});
    }

    public void setNumeroVeces(String frase, int numeroVeces) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("numeroVeces", numeroVeces);
        db.update("citas", values, "frase = ?", new String[]{frase});
    }
}
