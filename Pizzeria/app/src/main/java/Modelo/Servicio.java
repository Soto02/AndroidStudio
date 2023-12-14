package Modelo;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pizzeria.ActivityInicioSesion;

import java.util.ArrayList;

import DAOs.DAOPedidos;
import DAOs.DAOPizza;
import DAOs.DAOUsuario;

public class Servicio {
    DAOPizza daoPizza;
    DAOUsuario daoUsuario;
    DAOPedidos daoPedidos;
    HistorialInicioSesion historialInicioSesion;

    public Servicio(Context context) {

        daoPizza = DAOPizza.getInstance(context);
        daoUsuario = DAOUsuario.getInstance(context);
        daoPedidos = DAOPedidos.getInstance();
        historialInicioSesion = HistorialInicioSesion.getInstance();
    }


    public ArrayList<ArrayList<Pizza>> getServicioPedido() {
        return daoPedidos.getListaPedidos();
    }

    public void setServicioPedido(ArrayList<ArrayList<Pizza>> servicioPedido) {
        daoPedidos.setListaPedidos(servicioPedido);
    }

    public ArrayList<Pizza> getServicioPizzas() {
        return daoPizza.getPizzas();
    }




    public void añadirPedido( ArrayList<Pizza> array){

        daoPedidos.añadirPedido(array);


    }
    public ArrayList<Usuario> getUsuarios() {
        return daoUsuario.getListaUsuario();
    }



    public void añadirUsuario(Usuario usuario){

        daoUsuario.añadirUsuario(usuario);

    }

    public int obtenerUltimoIndice(){

        return daoPedidos.getListaPedidos().size()-1;
    }

    public ArrayList<Usuario> getServicioHistorial() {
        return historialInicioSesion.getArrayHistorial();
    }

    public void setServicioHistorial(ArrayList<Usuario> servicioHistorial) {
        historialInicioSesion.setArrayHistorial(servicioHistorial);
    }

    public void añadirAlHistorial(Usuario usuario){

        historialInicioSesion.añadirUsuario(usuario);

    }

    public Usuario obtenerUltimoUsuarioIniciado(){

        return historialInicioSesion.getArrayHistorial().get(historialInicioSesion.getArrayHistorial().size()-1);


    }
}
