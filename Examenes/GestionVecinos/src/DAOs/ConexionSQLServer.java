/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

/**
 *
 * @author dam
 */
import java.sql.*;

//Gestion vecinos
public class ConexionSQLServer {
    
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/sys";
    private String usuario = "root";
    private String contraseña = "dam1";
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    
    public ConexionSQLServer() {
        try {
            Class.forName(driver);
            
            connection = DriverManager.getConnection(url, usuario, contraseña);
            
            if(connection != null) {
                System.out.println("Conexion realizada correctamente.");
            }
            
        } catch(Exception e) {
            
            System.out.println("Hubo un error en la conexión.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        
        ConexionSQLServer conexion = new ConexionSQLServer();
    }
}
