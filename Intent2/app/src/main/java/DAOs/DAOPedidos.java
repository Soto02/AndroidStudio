package DAOs;

import java.util.ArrayList;

import Modelo.Pizza;

public class DAOPedidos {
    private static DAOPedidos daoPedidos = null;
    private static ArrayList<ArrayList<Pizza>> listadoPedidos = null;

    public static DAOPedidos getInstance() {
        if(daoPedidos == null) {
            daoPedidos = new DAOPedidos();
        }
        if(listadoPedidos == null) {
            listadoPedidos = new ArrayList<>();
        }
        return daoPedidos;
    }
    public  ArrayList<ArrayList<Pizza>> getListaPedidos() {
        return listadoPedidos;
    }
    public void setListadoPedidos(ArrayList<ArrayList<Pizza>> listadoPedidos) {
        DAOPedidos.listadoPedidos = listadoPedidos;
    }
    public void añadirPedido(ArrayList<Pizza> listadoPedidos) {
        DAOPedidos.listadoPedidos.add(listadoPedidos);
    }
}
