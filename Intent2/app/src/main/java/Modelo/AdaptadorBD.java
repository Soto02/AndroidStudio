package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AdaptadorBD extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NOMBREBBDD = "BDPizzeria.db";

    public AdaptadorBD(Context context) {
        super(context, NOMBREBBDD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Pizza" + "(" +
                "Cod_pizza INTEGER Primary Key AUTOINCREMENT," +
                "Nombre TEXT NOT NULL," +
                "Ingrediente1 TEXT NOT NULL," +
                "Ingrediente2 TEXT NOT NULL," +
                "Ingrediente3 TEXT NOT NULL," +
                "Ingrediente4 TEXT NOT NULL," +
                "Tamaño TEXT NOT NULL" + ")");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    //Insertar Pizza
    public long insertarPizza(String nombre, String ingrediente1, String ingrediente2, String ingrediente3, String ingrediente4, String tamaño){
        long id = 0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre", nombre);
            values.put("Ingrediente1", ingrediente1);
            values.put("Ingrediente2", ingrediente2);
            values.put("Ingrediente3", ingrediente3);
            values.put("Ingrediente4", ingrediente4);
            values.put("Tamaño", tamaño);
            id=bbdd.insert("Pizza",null,values);

            System.out.println("Se añadio correctamente.");
        } catch (Exception ex){
            System.err.println("Hubo un error.");
        }
        return id;
    }
    //Obtener Pizza
    public ArrayList<Pizza> obtenerPizzas(){

        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<Pizza> listaPizzas = new ArrayList<Pizza>();
        Pizza pizza;
        Cursor cursorPizza = bbdd.rawQuery("Select * from Pizza",null);

        if(cursorPizza.moveToFirst()){
            do{
                pizza = new Pizza(cursorPizza.getString(1), cursorPizza.getString(2), cursorPizza.getString(3), cursorPizza.getString(4),cursorPizza.getString(5),cursorPizza.getString(6));
                listaPizzas.add(pizza);
            }while(cursorPizza.moveToNext());
        }

        cursorPizza.close();
        return listaPizzas;
    }

}
