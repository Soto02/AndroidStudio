/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOS;

/**
 *
 * @author dam
 */
public class Cliente {
    
    private String nombre;
    private String contrasena;
    private Integer id;

    public Cliente(Integer id, String nombre,String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.id = id;
    }

    public Cliente(){
        this.id=0;
        this.nombre="";
        this.contrasena="";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
