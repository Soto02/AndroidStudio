/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author dam
 */
public class Comunidad {
    
    private Integer codigoComunidad;//Clave foranea
    private String ciudad;
    private String nombre;

    public Integer getCodigoComunidad() {
        return codigoComunidad;
    }

    public void setCodigoComunidad(Integer codigoComunidad) {
        this.codigoComunidad = codigoComunidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Comunidad{" + "codigo de la comunidad=" + codigoComunidad + ", ciudad=" + ciudad + ", nombre=" + nombre + '}';
    }
}
