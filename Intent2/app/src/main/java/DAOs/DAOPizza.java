package DAOs;

import android.content.Context;

import java.util.ArrayList;

import Modelo.AdaptadorBD;
import Modelo.Pizza;

public class DAOPizza {

    private static DAOPizza daoPizza = null;
    private static AdaptadorBD adaptadorBD = null;

    private DAOPizza() {}

    public static DAOPizza getInstance(Context context){
        if(daoPizza == null){
            daoPizza = new DAOPizza();
        }
        if(adaptadorBD == null){
            adaptadorBD = new AdaptadorBD(context);
            adaptadorBD.insertarPizza("BBQ", "Queso mozarella", "Salsa barbacoa", "Pollo", "Bacon", "");
            adaptadorBD.insertarPizza("Carbonara", "Queso mozarella", "Nata", "Bacon", "Champiñones", "");
            adaptadorBD.insertarPizza("4 Quesos", "Queso mozarella", "Queso de cabra", "Queso roquefort", "Queso gouda", "");
            adaptadorBD.insertarPizza("Peperoni", "Queso mozarella", "Peperoni", "Extra de queso", "Extra de Peperoni", "");
            adaptadorBD.insertarPizza("Alejandrina", "Queso mozarella", "Pollo", "Tomates Sherry", "Salsa Cesar", "");
            adaptadorBD.insertarPizza("La mileurista", "Queso mozarella", "Jamon Serrrano", "Huevo", "Champiñones", "");

        }
        return daoPizza;
    }
    public ArrayList<Pizza> getPizzas(){

        return adaptadorBD.obtenerPizzas();
    }

}
