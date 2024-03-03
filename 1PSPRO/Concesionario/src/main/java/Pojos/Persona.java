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
public class Persona {
    
    private int id;
    private String nombre;
    private int edad;
    private String correo;
    private boolean divorciado;
    

    public Persona(int id, String nombre, int edad, String correo, boolean divorciado) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.divorciado = divorciado;
    }

    public Persona(String nombre, int edad, String correo, boolean divorciado) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.divorciado = divorciado;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public boolean isDivorciado() {
        return divorciado;
    }

    public void setDivorciado(boolean divorciado) {
        this.divorciado = divorciado;
    }
    

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", correo=" + correo + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + this.edad;
        hash = 29 * hash + Objects.hashCode(this.correo);
        hash = 29 * hash + (this.divorciado ? 1 : 0);
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
        final Persona other = (Persona) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (this.divorciado != other.divorciado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.correo, other.correo);
    }
}
/*
Integer [] array = {5,3,6,4,5,5,2,33,45,2};
    	Integer n = 5;
    	
    	//ACTIVIDAD 1.
    	MediaArray media = (numeros)->{
    		Integer suma = 0;
    		for (Integer numero : numeros) {
				suma += numero;
			}
    		return suma/numeros.length;
    	};
    	
    	System.out.println(media.HacerMedia(array));
    	
    	//ACTIVIDAD 2.
    	FactorialNumero factorial = (numero)->{
    		Integer res = 1;
    		for (int i = 1; i <= numero; i++) {
				res = res * i;
			}
    		return res;
    	};
    	System.out.println(factorial.HacerFactorial(n));
    	
    	//ACTIVIDAD 3.
    	NumeroPar par = (numero)->{
    		if (numero%2==0)return true;
    		else return false;
    	};
    	System.out.println(par.EsPar(n));
    	
    	//ACTIVIDAD 4.
    	NumeroMayor mayor = (numeros)->{
    		Integer numMayor = 0;
    		for (Integer i = 0; i < numeros.length; i++) {
				if(i==0)numMayor=numeros[i];
				else {
					if(numeros[i]>numMayor)numMayor=numeros[i];
				}
			}
    		return numMayor;
    	};
    	System.out.println(mayor.Mayor(array));
    	
    	//ACTIVIDAD 5.
    	NumeroMenor menor = (numeros)->{
    		Integer numMenor = 0;
    		for (Integer i = 0; i < numeros.length; i++) {
				if(i==0)numMenor=numeros[i];
				else {
					if(numeros[i]<numMenor)numMenor=numeros[i];
				}
			}
    		return numMenor;
    	};
    	System.out.println(menor.Menor(array));
    	
    	//ACTIVIDAD 6.
    	NumeroMasRepetido masRepetido = (numeros)->{
    		Integer numMasRepetido = 0;
    		Integer maxAbsoluto = 0;
    		Integer maxActual =0;
    		for (Integer i = 0; i < numeros.length; i++) {
    			for (int j = 0; j < numeros.length; j++) {
					if(numeros[i]==numeros[j]) maxActual++;
				}
    			if (maxActual>maxAbsoluto) {
    				maxAbsoluto=maxActual;
    				numMasRepetido = numeros[i];
    			}
    			maxActual=0;
			}
    		return numMasRepetido;
    	};
    	System.out.println(masRepetido.MasRepetido(array));
    	
    	//ACTIVIDAD 7.
    	MayorDeTres mayorTres = (n1,n2,n3)->{
    		if(n1>n2&&n1>n3)return n1;
    		else if(n2>n1&&n2>n3)return n2;
    		else if(n3>n1&&n3>n2)return n3;
    		else return null;
    	};
    	System.out.println(mayorTres.MayorTres(4, 8, 1));
    	
    	//ACTIVIDAD 8.
    	Multiplicar multiplicar = (numero,string)->{
    		try {
				Integer parse = Integer.parseInt(string);
				return parse*numero; 
			} catch (Exception e) {
				return 0;
			}
    	};
    	System.out.println(multiplicar.HacerMultiplicacion(6, "2k"));
    	
    }
    
    interface MediaArray {
        Integer HacerMedia(Integer [] array);
    }
    interface FactorialNumero {
        Integer HacerFactorial(Integer num);
    }
    interface NumeroPar {
        Boolean EsPar(Integer num);
    }
    interface NumeroMayor {
        Integer Mayor(Integer[] array);
    }
    interface NumeroMenor {
        Integer Menor(Integer[] array);
    }
    interface NumeroMasRepetido {
        Integer MasRepetido(Integer[] array);
    }
    interface MayorDeTres {
        Integer MayorTres(Integer a, Integer b, Integer c);
    }
    interface Multiplicar {
        Integer HacerMultiplicacion(Integer a, String b);
    }
*/