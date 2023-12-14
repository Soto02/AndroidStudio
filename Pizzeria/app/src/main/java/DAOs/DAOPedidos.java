package DAOs;

import java.util.ArrayList;

import Modelo.Pizza;

public class DAOPedidos {


    private static DAOPedidos daoPedidos = null;
    private static ArrayList<ArrayList<Pizza>> listaPedidos = null;


    //Singleton, solo se instancia una vez
    public static DAOPedidos getInstance(){
        if(daoPedidos == null){
            daoPedidos = new DAOPedidos();
        }
        if(listaPedidos == null){
            listaPedidos = new ArrayList();

        }
        return daoPedidos;
    }
    public  ArrayList<ArrayList<Pizza>> getListaPedidos() {
        return listaPedidos;
    }

    public  void setListaPedidos(ArrayList<ArrayList<Pizza>> listaPedidos) {
        DAOPedidos.listaPedidos = listaPedidos;
    }

    public void  añadirPedido(ArrayList<Pizza> listaPedidos){
        DAOPedidos.listaPedidos.add(listaPedidos);
    }
}
