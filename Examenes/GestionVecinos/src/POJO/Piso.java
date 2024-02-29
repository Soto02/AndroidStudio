/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author dam
 */
public class Piso {
    
    private Integer codigoPiso;
    private Integer piso;
    private String letra;
    private String propietario;
    private Integer tarifa;
    private boolean moroso = false;

    public Integer getCodigoPiso() {
        return codigoPiso;
    }

    public void setCodigoPiso(Integer codigoPiso) {
        this.codigoPiso = codigoPiso;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isMoroso() {
        return moroso;
    }

    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }

    @Override
    public String toString() {
        return "Piso{" + "codigo=" + codigoPiso + ", piso=" + piso + ", letra=" + letra + ", propietario=" + propietario + ", tarifa=" + tarifa + ", moroso=" + moroso + '}';
    }
}
