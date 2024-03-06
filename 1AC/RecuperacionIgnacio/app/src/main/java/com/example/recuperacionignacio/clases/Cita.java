package com.example.recuperacionignacio.clases;

public class Cita {
    private String frase;
    private String autor;
    private int numeroVeces;
    private  int valoracion;

    public Cita(String frase, String autor, int numeroVeces, int valoracion) {
        this.frase = frase;
        this.autor = autor;
        this.numeroVeces = numeroVeces;
        this.valoracion = valoracion;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroVeces() {
        return numeroVeces;
    }

    public void setNumeroVeces(int numeroVeces) {
        this.numeroVeces = numeroVeces;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
