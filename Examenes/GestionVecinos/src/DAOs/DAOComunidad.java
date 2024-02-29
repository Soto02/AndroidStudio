/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import POJO.Comunidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam
 */
public class DAOComunidad implements IDAOComunidad{
    
    private ConexionSQLServer fabricaConexion;
    private static IDAOComunidad dao = null;
    
    public DAOComunidad() {
        super();
        this.fabricaConexion = new ConexionSQLServer();
    }
    
    @Override
    public List<Comunidad> listarComunidad() {
         List<Comunidad> listaComunidades = new ArrayList<>();

        try {
            String sql = "SELECT * from comunidad";
            Connection connection = this.fabricaConexion.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);

            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {

                Comunidad comunidad = new Comunidad();

                comunidad.setCodigoComunidad(resultado.getInt(0));
                comunidad.setCiudad(resultado.getString(1));
                comunidad.setNombre(resultado.getString(2));

                listaComunidades.add(comunidad);
            }

            resultado.close();
            sentencia.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Hubo un error al listar las comunidades.");
        }
        return listaComunidades;
    }

    @Override
    public boolean insertarComunidad(Comunidad comunidad) {
    
        try {

            String sql = "INSERT INTO comunidad(codigocom, ciudad, nombre) VALUES(?,?,?)";

            Connection connection = (Connection) this.fabricaConexion.getConnection();

            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setInt(0, comunidad.getCodigoComunidad());
            sentencia.setString(1, comunidad.getCiudad());
            sentencia.setString(2, comunidad.getNombre());

            sentencia.executeUpdate();
            sentencia.close();
            connection.close();

            return true;

        } catch (Exception e) {
            System.out.println("Hubo un error en el proceso de registrar una comunidad.");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarComunidad(String codigo) {
    
        try {
            String sql = "DELETE FROM comunidad WHERE codigocom=?";

            Connection connection = this.fabricaConexion.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            
            sentencia.setString(0, codigo);

            sentencia.executeUpdate();
            sentencia.close();
            connection.close();

            return true;

        } catch (Exception e) {
            System.out.println("Hubo un error al eliminar la comunidad.");
            e.printStackTrace();
            return false;
        }
    }

    /*
    @Override
    public boolean deshacerEliminarComunidad() {
    
    }
    */

    @Override
    public List<Comunidad> getComunidades() {
        return this.getComunidades();
    }
}
