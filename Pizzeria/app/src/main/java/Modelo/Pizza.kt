package Modelo

class Pizza {

    private var nombre: String? = null
    private var ingredientes: ArrayList<String>? = null
    private var tamaño: String? = null


    constructor(
        nombre: String?,
        ingrediente1: String,
        ingrediente2: String,
        ingrediente3: String,
        ingrediente4: String,
        tamaño: String?
    ) {
        this.nombre = nombre
        this.tamaño = tamaño
        ingredientes = ArrayList()
        ingredientes!!.add(ingrediente1)
        ingredientes!!.add(ingrediente2)
        ingredientes!!.add(ingrediente3)
        ingredientes!!.add(ingrediente4)
    }

    fun getIngredientes(): ArrayList<String>? {
        return ingredientes
    }

    fun setIngredientes(ingredientes: ArrayList<String>?) {
        this.ingredientes = ingredientes
    }

    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }

    fun obtenerStringIngredientes(): String? {
        var resp = ""
        var cont = 0
        for (ingrediente in ingredientes!!) {
            resp += if (cont == 1) {
                "$ingrediente\n"
            } else if (cont == 3) {
                "$ingrediente"
            } else {
                "$ingrediente, "
            }
            cont++
        }
        return resp
    }

    fun getTamaño(): String? {
        return tamaño
    }

    fun setTamaño(tamaño: String?) {
        this.tamaño = tamaño
    }
}