package Modelo

class Pedido {

    private var arrayPizzasPedidas: ArrayList<Pizza>? = null


    constructor(arrayPizzasPedidas: ArrayList<Pizza>?) {
        this.arrayPizzasPedidas = arrayPizzasPedidas
    }

    fun getPizza(): ArrayList<Pizza>? {
        return arrayPizzasPedidas
    }

    fun setPizza(arrayPizzasPedidas: ArrayList<Pizza>?) {
        this.arrayPizzasPedidas = arrayPizzasPedidas
    }

}