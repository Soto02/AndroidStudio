package DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Modelo.Cita;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_citas_examen.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "citas";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createPalabrasQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME+ "("
                + "codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "cita TEXT,"
                + "autor TEXT,"
                + "numVeces INTEGER,"
                + "valoracion TEXT)";

        db.execSQL(createPalabrasQuery);

        insertarCitas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    private void insertarCitas(SQLiteDatabase db) {
        List<Cita> citas = new ArrayList<>();
        citas.add(new Cita("Soy del Madrid", "Soto", 0, "Buena"));
        citas.add(new Cita("Es mejor el que gana", "Paco", 0, "Buena"));
        citas.add(new Cita("Mucho Beti", "Alejandro", 0, "Buena"));
        citas.add(new Cita("El mejor deporte es el baloncesto", "Alejandro", 0, "Buena"));
        citas.add(new Cita("Me encanta Jere", "Jose", 0, "Buena"));

        for (Cita cita : citas) {
            ContentValues values = new ContentValues();
            values.put("cita", cita.getCita());
            values.put("autor", cita.getAutor());
            values.put("numVeces", cita.getNumVeces());
            values.put("valoracion", cita.getValoracion());

            db.insert("citas", null, values);
        }
    }

    public List<String> getCitaUno() {

        List<String> citas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM citas LIMIT 1 ", null);

        while (cursor.moveToNext()) {
            String cita = cursor.getString(cursor.getColumnIndexOrThrow("cita"));
            String autor = cursor.getString(cursor.getColumnIndexOrThrow("autor"));
            Integer numVeces = cursor.getInt(cursor.getColumnIndexOrThrow("numVeces"));
            String valoracion = cursor.getString(cursor.getColumnIndexOrThrow("valoracion"));

            citas.add(String.valueOf(new Cita(cita, autor, numVeces, valoracion)));
        }

        cursor.close();
        db.close();

        return citas;
    }

    public List<String> getCitaDos() {

        List<String> citas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM citas LIMIT 2", null);

        while (cursor.moveToNext()) {
            String cita = cursor.getString(cursor.getColumnIndexOrThrow("cita"));
            String autor = cursor.getString(cursor.getColumnIndexOrThrow("autor"));
            Integer numVeces = cursor.getInt(cursor.getColumnIndexOrThrow("numVeces"));
            String valoracion = cursor.getString(cursor.getColumnIndexOrThrow("valoracion"));

            citas.add(String.valueOf(new Cita(cita, autor, numVeces, valoracion)));
        }

        cursor.close();
        db.close();

        return citas;
    }
    public List<String> getCitaTres() {

        List<String> citas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM citas LIMIT 3", null);

        while (cursor.moveToNext()) {
            String cita = cursor.getString(cursor.getColumnIndexOrThrow("cita"));
            String autor = cursor.getString(cursor.getColumnIndexOrThrow("autor"));
            Integer numVeces = cursor.getInt(cursor.getColumnIndexOrThrow("numVeces"));
            String valoracion = cursor.getString(cursor.getColumnIndexOrThrow("valoracion"));

            citas.add(String.valueOf(new Cita(cita, autor, numVeces, valoracion)));
        }

        cursor.close();
        db.close();

        return citas;
    }

    public List<String> getCitas() {

        List<String> citas = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("citas", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String cita = cursor.getString(cursor.getColumnIndexOrThrow("cita"));
            String autor = cursor.getString(cursor.getColumnIndexOrThrow("autor"));
            Integer numVeces = cursor.getInt(cursor.getColumnIndexOrThrow("numVeces"));
            String valoracion = cursor.getString(cursor.getColumnIndexOrThrow("valoracion"));

            citas.add(String.valueOf(new Cita(cita, autor, numVeces, valoracion)));
        }

        cursor.close();
        db.close();

        return citas;
    }
    public void borrarCita(Integer codigo) {
        SQLiteOpenHelper dbHelper = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Delete the record with the specified ID
        db.delete("your_table_name", "codigo = ?", new String[]{String.valueOf(codigo)});

        db.close();
    }
}
