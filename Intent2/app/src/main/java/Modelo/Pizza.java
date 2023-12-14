package Modelo;

import java.util.ArrayList;

public class Pizza {
    private String nombre;
    private ArrayList<String> ingredientes;
    private String tamaño;

    public Pizza(String nombre, String ingrediente1, String ingrediente2, String ingrediente3, String ingrediente4, String tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        ingredientes = new ArrayList<>();
        ingredientes.add(ingrediente1);
        ingredientes.add(ingrediente2);
        ingredientes.add(ingrediente3);
        ingredientes.add(ingrediente4);
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerStringIngredientes() {
        StringBuilder resp = new StringBuilder();
        int cont = 0;
        for (String ingrediente : ingredientes) {
            resp.append(cont == 1 ? ingrediente + "\n" : (cont == 3 ? ingrediente : ingrediente + ", "));
            cont++;
        }
        return resp.toString();
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
