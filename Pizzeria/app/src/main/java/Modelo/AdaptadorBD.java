package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class AdaptadorBD extends SQLiteOpenHelper{
    private static final int VERSION=1;
    private static final String NOMBREBBDD = "BBDDPizzeria.db";

    public AdaptadorBD( Context context) {
        super(context, NOMBREBBDD, null, VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create Table Usuario" + "(" +
                "Cod_usuario INTEGER Primary Key AUTOINCREMENT," +
                "Usuario TEXT NOT NULL," +
                "Contraseña TEXT NOT NULL" + ")");

        db.execSQL("Create Table Pizza" + "(" +
                "Cod_pizza INTEGER Primary Key AUTOINCREMENT," +
                "Nombre TEXT NOT NULL," +
                "Ingrediente1 TEXT NOT NULL," +
                "Ingrediente2 TEXT NOT NULL," +
                "Ingrediente3 TEXT NOT NULL," +
                "Ingrediente4 TEXT NOT NULL," +
                "Tamaño TEXT NOT NULL" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //Así se realiza un insert
    public long registrarUsuario(String usu, String contraseña){
        long id = 0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Usuario",usu);
            values.put("Contraseña",contraseña);
            id=bbdd.insert("Usuario",null,values);

            System.out.println("Se añadio bien");
        } catch (Exception ex){
            System.err.println("Algo falló");
        }


        return id;
    }
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

            System.out.println("Se añadio bien");
        } catch (Exception ex){
            System.err.println("Algo falló");
        }


        return id;
    }

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

    public ArrayList<Usuario> obtenerUsuarios(){


        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Usuario usuario;
        Cursor cursorPizzas = bbdd.rawQuery("Select * from Usuario",null);

        if(cursorPizzas.moveToFirst()){
            do{
                usuario = new Usuario(cursorPizzas.getString(1), cursorPizzas.getString(2));
                listaUsuarios.add(usuario);
            }while(cursorPizzas.moveToNext());
        }

        cursorPizzas.close();



        return listaUsuarios;
    }

}
