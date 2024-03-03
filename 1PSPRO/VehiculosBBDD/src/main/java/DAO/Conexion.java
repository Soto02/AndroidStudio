/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cayet
 */
public class Conexion {
    
    private static Connection conn=null;
    private static Statement st=null;
    private static ResultSet rs=null;
    private static String bd="vehiculos";
    private static String login="cayetano";
    private static String password="1234";  
    private static String url="jdbc:mysql://localhost/"+bd;

    //ESTABLECE LA CONEXIÓN.
    public static void establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,login,password);
        } 
        catch (SQLException ex) {
            System.out.println("Excepción en la conexión.");
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la clase.");
        }
    }
    
    //PARA CONSULTAS SIN RETORNO (UPDATE,DELETE,INSERT)
    public static void consultaSinRetorno(String consulta) {
        try {
            st = conn.createStatement();
            st.executeUpdate(consulta);
        } 
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
    }
    
    //PARA CONSULTAS CON SELECT.
    public static ResultSet consultaConRetorno(String consulta) {
        try {
            st = conn.createStatement();
            st.executeQuery(consulta);
            rs=st.executeQuery(consulta);
        } 
        catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
        return rs;
    }
 
    //PARA CERRAR SESIÓN
    public static void cerrarSesion() {
        try {
            rs.close();
            st.close();
            conn.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
