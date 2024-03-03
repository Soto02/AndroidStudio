package CONTROLADOR;

import DAO.DAOClientes;
import DAO.DAOVehiculos;
import POJOS.Cliente;
import POJOS.Servicio;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import POJOS.Vehiculo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ControllerCRUD{
	
    public static void cargarTablaVehiculos( JTable tablaVehiculos, Integer id) throws SQLException{ 
        ArrayList<Vehiculo> lstVehiculos = Servicio.getInstance().getVehiculos(id);	
        DefaultTableModel modelo=new DefaultTableModel();
	modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Matricula");
   
	Object[] registroLeido = new Object [3];
	 
	for(Vehiculo vehiculo:lstVehiculos){	 
            registroLeido[0]= vehiculo.getMarca();
            registroLeido[1]= vehiculo.getModelo();
            registroLeido[2]=  vehiculo.getMatricula();
            modelo.addRow(registroLeido);
	}
        tablaVehiculos.setModel(modelo);
    }
    
    public static void cargarTablaClientes( JTable tablaClientes) throws SQLException{ 
	ArrayList<Cliente> lstClientes = Servicio.getInstance().getClientes();
	DefaultTableModel modelo=new DefaultTableModel();
	modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CONTRASEÑA");
   
	Object[] registroLeido = new Object [3];
	 
	for(Cliente cliente: lstClientes){	 
            registroLeido[0]= cliente.getId();
            registroLeido[1]= cliente.getNombre();
            registroLeido[2]=  cliente.getContrasena();
            modelo.addRow(registroLeido);
	}
        tablaClientes.setModel(modelo);
    }
	
    public static Object casillaSeleccionada(JTable tabla,Integer nColumna){
        int filaSeleccionada = tabla.getSelectedRow();
        int columnaSeleccionada = nColumna;
        Object valorSeleccionado = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
        return valorSeleccionado;
    }

}
