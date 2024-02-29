/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import POJO.Piso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam
 */
public class DAOPiso implements IDAOPiso {
    
    private ConexionSQLServer fabricaConexion;
    private static IDAOPiso dao = null;
    
    public DAOPiso() {
        super();
        this.fabricaConexion = new ConexionSQLServer();
    }
    
    @Override
    public List<Piso> listarPiso() {
        List<Piso> listaPisos = new ArrayList<>();
        
        try {
            String sql = "SELECT * from vecinos";
            
            Connection connection = this.fabricaConexion.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);

            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Piso piso = new Piso();
                
                piso.setCodigoPiso(resultado.getInt(0));
                piso.setPiso(resultado.getInt(1));
                piso.setLetra(resultado.getString(2));
                piso.setPropietario(resultado.getString(3));
                piso.setTarifa(resultado.getInt(4));
                piso.setMoroso(resultado.getBoolean(5));
            }
            
            resultado.close();
            sentencia.close();
            connection.close();
            
        } catch (Exception ex) {
            System.out.println("Hubo un error al listar los pisos.");
        }
        return listaPisos;
    }
    
    @Override
    public boolean insertarPropietario(Piso piso) {
        
        try {
            String sql = "INSERT INTO vecinos(codigo, piso, letra, propietario, tarifa, moroso) VALUES(?,?,?,?,?,?)";
            
            Connection connection = (Connection) this.fabricaConexion.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);
            
            sentencia.setInt(0, piso.getCodigoPiso());
            sentencia.setInt(1, piso.getPiso());
            sentencia.setString(2, piso.getLetra());
            sentencia.setString(3, piso.getPropietario());
            sentencia.setInt(4, piso.getTarifa());
            sentencia.setBoolean(5, piso.isMoroso());
            
            sentencia.executeUpdate();
            sentencia.close();
            connection.close();
            
            return true;
        }  catch (Exception e) {
            System.out.println("Hubo un error en el proceso de registrar un propietario.");
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean comprobarMoroso(boolean moroso) {
        
        try {
            String sql = "SELECT moroso from vecinos WHERE moroso = true";
            
            Connection connection = this.fabricaConexion.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);

            ResultSet resultado = sentencia.executeQuery();
            
            Piso piso = new Piso();
            
            if(piso.isMoroso() == true) {
                return moroso == true;
            }
            
            resultado.close();
            sentencia.close();
            connection.close();
            
            return moroso;
        } catch(Exception ex) {
            System.out.println("Hubo un error en el proceso de comprobar propietarios morosos.");
            ex.printStackTrace();
            return false;
        }
    }
}
