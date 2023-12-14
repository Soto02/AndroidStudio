package DAOs;

import android.content.Context;

import java.util.ArrayList;

import Modelo.AdaptadorBD;
import Modelo.Pizza;

public class DAOPizza {

    private static DAOPizza daoPizza = null;
    private static AdaptadorBD adaptadorBD = null;

    private DAOPizza(){

    }
    //Singleton, solo se instancia una vez
    public static DAOPizza getInstance(Context context){
        if(daoPizza == null){
            daoPizza = new DAOPizza();
        }
        if(adaptadorBD == null){
            adaptadorBD = new AdaptadorBD(context);
            adaptadorBD.insertarPizza("Queen BBQ", "Queso mozarella", "Salsa barbacoa", "Pollo", "Bacon", "");
            adaptadorBD.insertarPizza("Italian Carbonara", "Queso mozarella", "Nata", "Bacon", "Champiñones", "");
            adaptadorBD.insertarPizza("King Cheese", "Queso mozarella", "Queso de cabra", "Queso roquefort", "Queso gouda", "");
            adaptadorBD.insertarPizza("Green Fit", "Queso mozarella", "Pimiento verde", "Cebolla", "Aceituna negra", "");
            adaptadorBD.insertarPizza("Joseroni", "Queso mozarella", "Peperoni", "Carne picada", "Extra de queso", "");
            adaptadorBD.insertarPizza("Red Devil", "Queso mozarella", "Pimiento chili", "Guindilla", "Pimiento Habanero", "");

        }
        return daoPizza;
    }



    public ArrayList<Pizza> getPizzas(){

        return adaptadorBD.obtenerPizzas();
    }

    public void añadirPizza(String nombre, String ingrediente1, String ingrediente2, String ingrediente3, String ingrediente4){


        adaptadorBD.insertarPizza(nombre, ingrediente1, ingrediente2, ingrediente3, ingrediente4, "");

    }

    public  ArrayList getListaPizza() {
        return adaptadorBD.obtenerPizzas();
    }

}
