package Pojo;

import static com.example.proyectaso.MainActivity.personas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectaso.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class ConexionBD extends SQLiteOpenHelper {

    private String crearTablaPersona() {
        String tabla = "CREATE TABLE personas (" +
                "id INT PRIMARY KEY ," +
                "nombre VARCHAR(45) NOT NULL," +
                "edad INT NOT NULL)";

        return tabla;
    }

    public ConexionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTablaPersona());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrirBD() {
        this.getWritableDatabase();
    }

    public void insertarPersona(Persona persona) {
        ContentValues valores = new ContentValues();
        valores.put("id", persona.getId());
        valores.put("nombre", persona.getNombre());
        valores.put("edad", persona.getEdad());

        this.getWritableDatabase().insert("personas", null, valores);
    }

    public void borrarPersona(int id) {
        this.getWritableDatabase().delete("personas", "id = ?", new String[]{String.valueOf(id)});
    }

    public void borrarPersonas() {
        this.getWritableDatabase().delete("personas", "", new String[]{});
    }

    public void modificarPersona(int id, String nombre, int edad) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("edad", edad);

        this.getWritableDatabase().update("personas", valores, "id=?",new String[]{String.valueOf(id)});
    }

    public List<Persona> getPersonas() {
        //List<Persona> personas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("personas", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            int edad = cursor.getInt(cursor.getColumnIndexOrThrow("edad"));

            personas.add(new Persona(id, nombre, edad));
        }

        return personas;
    }

    public List<Persona> getPersonasMenores() {
        List<Persona> personas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("personas", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            int edad = cursor.getInt(cursor.getColumnIndexOrThrow("edad"));

            if (edad < 18) {
                personas.add(new Persona(id, nombre, edad));
            }
        }

        return personas;
    }

    public List<Persona> getXPersonas(int numPersonas) {
        List<Persona> personas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("personas", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            int edad = cursor.getInt(cursor.getColumnIndexOrThrow("edad"));

            if(personas.size() < numPersonas) {
                personas.add(new Persona(id, nombre, edad));
            }
        }
        return personas;
    }









}
