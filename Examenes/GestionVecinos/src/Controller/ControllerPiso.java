/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAOs.DAOPiso;
import POJO.Piso;
import java.util.List;

/**
 *
 * @author dam
 */
public class ControllerPiso {
    
    private DAOPiso dao;
    
    public ControllerPiso() {
        this.dao = new DAOPiso();
    }
    
    public List<Piso> listarPiso() {
        List<Piso> lstPiso = this.dao.listarPiso();
        return lstPiso;
    }
    
    public boolean insertarPropietario(Piso piso) {
        boolean insertado = this.dao.insertarPropietario(piso);
        return insertado;
    }
    
    public boolean comprobarMoroso(boolean moroso) {
        boolean noPaga = this.dao.comprobarMoroso(moroso);
        return noPaga;
    }
}
