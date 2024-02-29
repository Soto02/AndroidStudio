package Modelo;

import java.util.ArrayList;

public class Pregunta {

    private ArrayList<String> palabras;

    public Pregunta(String palabra) {
        palabras = new ArrayList<>();
        palabras.add(palabra);
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public String obtenerStringPalabras() {
        StringBuilder resp = new StringBuilder();
        int cont = 0;
        for (String palabra : palabras) {
            resp.append(cont == 1 ? palabra + "\n" : (cont == 3 ? palabra : palabra + ", "));
            cont++;
        }
        return resp.toString();
    }
}
