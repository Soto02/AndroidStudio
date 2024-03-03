package DAO;
import POJOS.Vehiculo;
import java.sql.ResultSet;

public class DAOVehiculos{
	
    	private static DAOVehiculos dao = null; 

	private DAOVehiculos() {
            super();
            Conexion.establecerConexion();
	}
        
        public static DAOVehiculos getInstance() {
            if (dao == null) dao = new DAOVehiculos();
            return dao;
	}

	public void insertarVehiculo(Vehiculo vehiculo, int id) {
            Conexion.consultaSinRetorno("INSERT INTO vehiculo (marca, modelo, matricula, id) VALUES ('" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getMatricula() +"'," + id +");");
	}

	public void eliminarVehiculo(String m) {
            Conexion.consultaSinRetorno("DELETE FROM vehiculo WHERE matricula = '" + m + "';");
	}

        public ResultSet todosLosVehiculos(Integer idCliente) {
            return Conexion.consultaConRetorno("SELECT * FROM vehiculo WHERE id="+idCliente);
        }

}
