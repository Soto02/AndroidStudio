/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAOs.DAOComunidad;
import POJO.Comunidad;
import java.util.List;

/**
 *
 * @author dam
 */
public class ControllerComunidad {
    
    private DAOComunidad dao;
    
    public ControllerComunidad(){
        this.dao = new DAOComunidad();
    }
    
    public List<Comunidad> listarComunidad() {
        List<Comunidad> lstComunidad = this.dao.listarComunidad();
        return lstComunidad;
    }
    
    public boolean insertarComunidad(Comunidad comunidad) {
        boolean insertado = this.dao.insertarComunidad(comunidad);
        return insertado;
    }
    
    public boolean eliminarComunidad(String codigo) {
        boolean eliminado = this.dao.eliminarComunidad(codigo);
        return eliminado;
    }
}
