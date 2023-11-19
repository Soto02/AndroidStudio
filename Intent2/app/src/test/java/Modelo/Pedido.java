package Modelo;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Pizza> arrayPizzasPedidas;

    public Pedido(ArrayList<Pizza> arrayPizzasPedidas) {
        this.arrayPizzasPedidas = arrayPizzasPedidas;
    }

    public ArrayList<Pizza> getPizza() {
        return arrayPizzasPedidas;
    }

    public void setPizza(ArrayList<Pizza> arrayPizzasPedidas) {
        this.arrayPizzasPedidas = arrayPizzasPedidas;
    }
}
