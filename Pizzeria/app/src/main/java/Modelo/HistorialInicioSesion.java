package Modelo;

import java.util.ArrayList;

public class HistorialInicioSesion {


    private static HistorialInicioSesion historial = null;
    private static ArrayList<Usuario> arrayHistorial = null;


    //Singleton, solo se instancia una vez
    public static HistorialInicioSesion getInstance(){
        if(historial == null){
            historial = new HistorialInicioSesion();
        }
        if(arrayHistorial == null){
            arrayHistorial = new ArrayList();

        }
        return historial;
    }

    public ArrayList<Usuario> getArrayHistorial() {
        return arrayHistorial;
    }

    public void setArrayHistorial(ArrayList<Usuario> arrayHistorial) {
        HistorialInicioSesion.arrayHistorial = arrayHistorial;
    }


    public void añadirUsuario(Usuario usuario){

        this.arrayHistorial.add(usuario);

    }
}
