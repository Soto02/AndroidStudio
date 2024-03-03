
import ConexionBD.Conexion;
import DAO.DAOPersona;
import Pojos.Persona;
import Pojos.Servicio;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

/**
 *
 * @author alexs
 */
public class DAOTests {
    
    @Test
    public void testListarPersonas() throws SQLException {
        // Mock de Conexion
        Conexion conexionMock = mock(Conexion.class);
        //when(Conexion.establecerConexion()).thenReturn(conexionMock);
        
        // Mock de ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false); // Devolver un solo conjunto de datos
        when(conexionMock.consultaConRetorno(anyString())).thenReturn(resultSetMock);
        
        // Crear DAOPersona
        DAOPersona daoPersona = DAOPersona.getInstance();
        
        // Listar personas
        ResultSet result = daoPersona.listarPersonas();
        
        // Verificar que se llame a consultaConRetorno con la consulta correcta
        verify(conexionMock).consultaConRetorno("SELECT * FROM personas;");
        
        // Verificar que se devuelve un ResultSet no nulo
        Assertions.assertNotNull(result);
    }
}
