/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJOS.Cliente;
import java.sql.ResultSet;

/**
 *
 * @author dam
 */
public class DAOClientes{
    
    	private static DAOClientes dao = null;

	public DAOClientes() {
            Conexion.establecerConexion();
	}
        
        public static DAOClientes getInstance() {
            if (dao == null) dao = new DAOClientes();
            return dao;
	}

	public void insertarCliente(Cliente c) {
            Conexion.consultaSinRetorno("INSERT INTO cliente(id,nombre,contrasena) VALUES ('"+ c.getId() + "','" + c.getNombre() + "', '" + c.getContrasena() +"');");
	}
        
        public void borrarCliente(int id) {
            Conexion.consultaSinRetorno("DELETE FROM vehiculo WHERE id="+id);
            Conexion.consultaSinRetorno("DELETE FROM cliente WHERE id="+id);
	}

        public ResultSet todosLosClientes() {
            return Conexion.consultaConRetorno("SELECT * FROM cliente");
        }
}
