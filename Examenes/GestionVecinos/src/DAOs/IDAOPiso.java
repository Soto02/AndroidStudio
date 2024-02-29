/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import POJO.Piso;
import java.util.List;

/**
 *
 * @author dam
 */
public interface IDAOPiso {
    public List<Piso> listarPiso();
    public boolean insertarPropietario(Piso piso);
    public boolean comprobarMoroso(boolean moroso);
}
