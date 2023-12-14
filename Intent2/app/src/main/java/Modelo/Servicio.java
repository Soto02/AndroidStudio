package Modelo;

import java.util.ArrayList;

import DAOs.DAOPedidos;
import DAOs.DAOPizza;
import android.content.Context;

public class Servicio {

    DAOPizza daoPizza;
    DAOPedidos daoPedidos;

    public Servicio(Context context) {
        daoPizza = DAOPizza.getInstance(context);
        daoPedidos = DAOPedidos.getInstance();
    }

    public ArrayList<ArrayList<Pizza>> getServicioPedido() {
        return daoPedidos.getListaPedidos();
    }
    public ArrayList<Pizza> getServicioPizzas() {
        return daoPizza.getPizzas();
    }
    public void añadirPedido( ArrayList<Pizza> array){
        daoPedidos.añadirPedido(array);
    }
    public int obtenerUltimoIndice(){
        return daoPedidos.getListaPedidos().size()-1;
    }
}
