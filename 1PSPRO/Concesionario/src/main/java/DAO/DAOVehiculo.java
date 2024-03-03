/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.Conexion;
import Pojos.Coche;
import Pojos.Persona;
import java.sql.ResultSet;

/**
 *
 * @author alexs
 */
public class DAOVehiculo {
    
    private static DAOVehiculo dao;

    private DAOVehiculo() {
        
        Conexion.establecerConexion();
    }
    
    public static DAOVehiculo getInstance() {
        if(dao == null) {
            dao = new DAOVehiculo();
        }
        return dao;
    }
    
    public void insertarVehiculo(Coche c) {
        Conexion.consultaSinRetorno("INSERT INTO coches (matricula,modelo,marca,id_persona) VALUES(" + c.getMatricula() + ", '" + c.getModelo() + "', '" + c.getMarca() + "', " + c.getId_persona() + ");" ); 
    }
    
    public void borrarVehiculo(int matricula) {
        Conexion.consultaSinRetorno("DELETE * FROM coches WHERE matricula=" + matricula +";");
    }
    
    public ResultSet listarVehiculosID(int id) {
        return Conexion.consultaConRetorno("SELECT * FROM coches WHERE id_persona=" + id + ";");
    }

    
}
