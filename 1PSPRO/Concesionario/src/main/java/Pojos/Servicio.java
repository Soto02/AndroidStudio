/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import DAO.DAOPersona;
import DAO.DAOVehiculo;
import Excepciones.ExcepcionPersona;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class Servicio {
    
    private static Servicio servicio;

    private Servicio() {
    }
    
    public static Servicio getInstance() {
        if(servicio == null) {
            servicio = new Servicio();
        }
        return servicio;
    }
    
    public ArrayList<Persona> getPersonas() throws SQLException {
        ResultSet resultado = DAOPersona.getInstance().listarPersonas();
        ArrayList<Persona> personas = new ArrayList<>();
        
        while(resultado.next()) {
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            int edad = resultado.getInt("edad");
            String correo = resultado.getString("correo");
            boolean divorciado = resultado.getBoolean("divorciado");
            
            Persona persona = new Persona(id, nombre, edad, correo, divorciado);
            
            try {
                if(!(persona.getEdad() < 18)) {
                   personas.add(persona); 
                } else {
                    throw new ExcepcionPersona("La persona es menor de 18 años");
                }              
            } catch (Exception e) {
            }
            
            
        }
        return personas;
    }
    
    public ArrayList<Persona> getPersonasP(String consulta) throws SQLException {
        ResultSet resultado = DAOPersona.getInstance().listarPersonasP(consulta);
        ArrayList<Persona> personas = new ArrayList<>();
        
        while(resultado.next()) {
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            int edad = resultado.getInt("edad");
            String correo = resultado.getString("correo");
            boolean divorciado = resultado.getBoolean("divorciado");
            
            personas.add(new Persona(id, nombre, edad, correo, divorciado));
        }
        return personas;
    }
    
    public ArrayList<Coche> getCoches(int id) throws SQLException {
        ResultSet resultado = DAOVehiculo.getInstance().listarVehiculosID(id);
        ArrayList<Coche> coches = new ArrayList<>();
        
        while(resultado.next()) {
            int matricula = resultado.getInt("matricula");
            String modelo = resultado.getString("modelo");
            String marca = resultado.getString("marca");
            int id_persona = resultado.getInt("id_persona");
            
            coches.add(new Coche(matricula, modelo, marca, id_persona));
        }
        return coches;
    }    
}
