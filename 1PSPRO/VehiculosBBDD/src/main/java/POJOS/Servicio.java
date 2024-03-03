/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOS;

import DAO.DAOClientes;
import DAO.DAOVehiculos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Servicio {
    
    private DAO.DAOVehiculos daoVehiculos = DAOVehiculos.getInstance();
    private DAO.DAOClientes daoClientes = DAOClientes.getInstance();
    private static Servicio servicio = null;
    
    private Servicio(){}
    
    public static Servicio getInstance(){
        if(servicio==null) servicio = new Servicio();
        return servicio;
    }
    
    public ArrayList<Vehiculo> getVehiculos(int id) throws SQLException{
        ResultSet resultado = daoVehiculos.todosLosVehiculos(id);
        ArrayList<Vehiculo> aux = new ArrayList<>();
        while (resultado.next()) {            
            String marca = resultado.getString("marca");
            String modelo = resultado.getString("modelo");
            String matricula = resultado.getString("matricula");
            aux.add(new Vehiculo(marca, modelo, matricula));
        }
        return aux;
    }
    
    public ArrayList<Cliente> getClientes() throws SQLException{
        ResultSet resultado = daoClientes.todosLosClientes();
        ArrayList<Cliente> aux = new ArrayList<>();
        while (resultado.next()) {            
            Integer id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String contrasena = resultado.getString("contrasena");
            aux.add(new Cliente(id, nombre, contrasena));
        }
        return aux;
    }
    
    public void agregarCliente(int id, String nombre, String contrasena){
        daoClientes.insertarCliente(new Cliente(id, nombre, contrasena));
    }
    
    public void agregarVehiculo(int id, String marca, String modelo, String matricula){
        daoVehiculos.insertarVehiculo(new Vehiculo(marca, modelo, matricula), id);
    }
    
    public void borrarCliente(int id){
        daoClientes.borrarCliente(id);
    }
    
    public void borrarVehiculo(String m){
        daoVehiculos.eliminarVehiculo(m);
    }
    
}
