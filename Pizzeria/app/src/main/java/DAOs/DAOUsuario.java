package DAOs;

import android.content.Context;

import java.util.ArrayList;

import Modelo.AdaptadorBD;
import Modelo.Usuario;

public class DAOUsuario {

    private static DAOUsuario daoUsuario = null;
    private static AdaptadorBD adaptadorBD = null;


    //Singleton, solo se instancia una vez
    public static DAOUsuario getInstance(Context context){
        if(daoUsuario == null){
            daoUsuario = new DAOUsuario();
        }
        if(adaptadorBD == null){
            adaptadorBD = new AdaptadorBD(context);
            adaptadorBD.registrarUsuario("diego", "123");
        }
        return daoUsuario;
    }


    public ArrayList<Usuario> getListaUsuario() {
        return adaptadorBD.obtenerUsuarios();
    }



    public void añadirUsuario(Usuario usuario){


        adaptadorBD.registrarUsuario(usuario.getUsuario(), usuario.getContraseña());

    }
}
