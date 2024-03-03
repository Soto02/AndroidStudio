/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.Conexion;
import Pojos.Persona;
import java.sql.ResultSet;

public class DAOPersona {
    
    private static DAOPersona dao;

    private DAOPersona() {
        
        Conexion.establecerConexion();
    }
    
    public static DAOPersona getInstance() {
        if(dao == null) {
            dao = new DAOPersona();
        }
        return dao;
    }
    
    public void insertarPersona(Persona p) {
        Conexion.consultaSinRetorno("INSERT INTO personas (id,nombre,edad,correo,divorciado) VALUES(" + p.getId() + ", '" + p.getNombre() + "', " + p.getEdad() + ", '" + p.getCorreo() + "', '" + p.isDivorciado() + "');" ); 
    }
    
    public void borrarPersona(int id) {
        Conexion.consultaSinRetorno("DELETE FROM coches WHERE id_persona=" + id +";");
        Conexion.consultaSinRetorno("DELETE FROM personas WHERE id=" + id + ";");
    }
    
    public ResultSet listarPersonas() {
        return Conexion.consultaConRetorno("SELECT * FROM personas;");
    }
    
    public ResultSet listarPersonasP(String consulta) {
        return Conexion.consultaConRetorno(consulta);
    }
    
}
