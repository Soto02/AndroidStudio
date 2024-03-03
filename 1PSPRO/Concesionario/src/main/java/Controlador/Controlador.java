/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Pojos.Coche;
import Pojos.ComparadorPersona;
import Pojos.Persona;
import Pojos.Servicio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexs
 */
public class Controlador {
    
    public static void cargarTablaPersonas( JTable tablaPersona) throws SQLException { 
        ArrayList<Persona> lstPersonas = Servicio.getInstance().getPersonas();
        Collections.sort(lstPersonas, new ComparadorPersona());
        DefaultTableModel modelo=new DefaultTableModel();
	modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Correo");
        modelo.addColumn("Divorciado");
   
	Object[] registroLeido = new Object [5];
	 
	for(Persona persona:lstPersonas){	 
            registroLeido[0]= persona.getId();
            registroLeido[1]= persona.getNombre();
            registroLeido[2]= persona.getEdad();
            registroLeido[3]= persona.getCorreo();
            registroLeido[4]= persona.isDivorciado();
            
            modelo.addRow(registroLeido);
	}
        tablaPersona.setModel(modelo);
    }
    
    public static void cargarTablaConsulta( JTable tablaVehiculos, ArrayList<Persona> personas) throws SQLException { 
        ArrayList<Persona> lstPersonas = personas;
        DefaultTableModel modelo=new DefaultTableModel();
	modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Correo");
        modelo.addColumn("Divorciado");
   
	Object[] registroLeido = new Object [5];
	 
	for(Persona persona:lstPersonas){	 
            registroLeido[0]= persona.getId();
            registroLeido[1]= persona.getNombre();
            registroLeido[2]= persona.getEdad();
            registroLeido[3]= persona.getCorreo();
            registroLeido[4]= persona.isDivorciado();
            
            modelo.addRow(registroLeido);
	}
        
        if(lstPersonas.size() < 1){
            JOptionPane.showMessageDialog(tablaVehiculos, "No hay datos");
        }
        
        tablaVehiculos.setModel(modelo);
    }
    
    public static void cargarTablaVehiculo( JTable tablaVehiculos, int id) throws SQLException { 
        ArrayList<Coche> lstPersonas = Servicio.getInstance().getCoches(id);
        DefaultTableModel modelo=new DefaultTableModel();
	modelo.addColumn("Matricula");
        modelo.addColumn("Modelo");
        modelo.addColumn("Marca");
        modelo.addColumn("Id persona");
   
	Object[] registroLeido = new Object [4];
	 
	for(Coche coche:lstPersonas){	 
            registroLeido[0]= coche.getMatricula();
            registroLeido[1]= coche.getModelo();
            registroLeido[2]= coche.getMarca();
            registroLeido[3]= coche.getId_persona();
            
            modelo.addRow(registroLeido);
	}
        tablaVehiculos.setModel(modelo);
    }
    
    public static Object casillaSeleccionada(JTable tabla, int numColumna) {
        
        int filaSeleccionada = tabla.getSelectedRow();
        int columnaSeleccionada = numColumna;
        Object valor = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
        
        return valor;
    }
    
    
}
