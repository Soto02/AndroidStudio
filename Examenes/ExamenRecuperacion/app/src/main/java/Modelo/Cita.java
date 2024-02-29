package Modelo;

public class Cita {

    private Integer codigo;
    private String cita;
    private String autor;
    private Integer numVeces;
    private String valoracion;

    public Cita(String cita, String autor, Integer numVeces, String valoracion) {
        this.cita = cita;
        this.autor = autor;
        this.numVeces = numVeces;
        this.valoracion = valoracion;
    }

    public Integer getCodigo() {
        return codigo;
    }
    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumVeces() {
        return numVeces;
    }

    public void setNumVeces(Integer numVeces) {
        this.numVeces = numVeces;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Cita(cita='" + cita +"')";
    }
}
