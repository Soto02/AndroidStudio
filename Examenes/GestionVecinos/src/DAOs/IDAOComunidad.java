/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import POJO.Comunidad;
import java.util.List;

/**
 *
 * @author dam
 */
public interface IDAOComunidad {
    public List<Comunidad> listarComunidad();
    public boolean insertarComunidad(Comunidad comunidad);
    public boolean eliminarComunidad(String codigo);
    //public boolean deshacerEliminarComunidad();
    public List<Comunidad> getComunidades();
}
