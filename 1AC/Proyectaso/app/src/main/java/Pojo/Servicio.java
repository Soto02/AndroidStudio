package Pojo;

import android.content.Context;

public class Servicio {

    private static Servicio servicio;
    public ConexionBD conexionBD;

    private Servicio(Context context) {
        this.conexionBD = new ConexionBD(context, "bd_personas", null, 1);
    }

    public static Servicio getInstance(Context context) {
        if(servicio == null) {
            servicio = new Servicio(context);
        }
        return servicio;
    }

    public static Servicio getInstance() {
        return servicio;
    }

    public void agregarPersona(int id, String nombre, int edad) {
        conexionBD.insertarPersona(new Persona(id, nombre, edad));
    }

    public void borrarPersona(int id) {
        conexionBD.borrarPersona(id);
    }

}
