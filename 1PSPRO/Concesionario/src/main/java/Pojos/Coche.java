/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.util.Objects;

/**
 *
 * @author alexs
 */
public class Coche {
    
    private int matricula;
    private String modelo;
    private String marca;
    private int id_persona;

    public Coche(int matricula, String modelo, String marca, int id_persona) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.id_persona = id_persona;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", id_persona=" + id_persona + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.matricula;
        hash = 53 * hash + Objects.hashCode(this.modelo);
        hash = 53 * hash + Objects.hashCode(this.marca);
        hash = 53 * hash + this.id_persona;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        if (this.id_persona != other.id_persona) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.marca, other.marca);
    }
    
    
}
/*
CREATE TABLE `concesionario`.`coches` (
  `matricula` INT NOT NULL,
  `modelo` VARCHAR(45) NULL,
  `marca` VARCHAR(45) NULL,
  `id_persona` INT NULL,
  PRIMARY KEY (`matricula`),
  FOREIGN KEY (`id_persona`) REFERENCES `concesionario`.`personas` (`id`)
);
*/
