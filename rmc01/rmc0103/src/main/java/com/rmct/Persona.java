/*1.3. Realiza una sencilla aplicación de consola que tenga definida una clase llamada Persona con
atributos privados: dni, nombre y edad. Añádele un constructor que incluya todos los atributos,
getters, setters, toString y equals y hashcode basado en el dni.
Incluye un programa que defina un ArrayList con 6 personas (puedes meter sus valores por hardcode
o hacer un sencillo método para que el usuario introduzca sus valores).
Desarrolla distintos métodos en el programa anterior con las siguientes características:
• Método al que se le pasa un ArrayList de Persona y devuelve la edad del mayor.
• Método al que se le pasa un ArrayList de Persona y devuelve la edad media.
• Método al que se le pasa un ArrayList de Persona y devuelve el nombre del mayor.
• Método al que se le pasa un ArrayList de Persona y devuelve la Persona mayor.
• Método al que se le pasa un ArrayList de Persona y devuelve todos los mayores de edad.
• Método al que se le pasa un ArrayList de Persona y devuelve todos los que tienen una edad
mayor o igual a la media.
En el main del programa haz llamadas a los métodos anteriores y muestra por pantalla su resultado.*/
package com.rmct;
import java.util.Objects;

public class Persona {
    
    private String dni;
    private String nombre;
    private int edad;
    

    Persona () {}   
    Persona (String dni, String nombre, int edad) {
    
        this.nombre= nombre;
        this.edad= edad;
    }   
   public void setDNI(String DNI){
            this.dni=DNI;
        }
    public String getDNI (){
        return dni;
    }
    public void setNombre(String nomb){
            this.nombre=nomb;
        }
    public String getNombre(){
        return nombre;
    }
    public void setEdad(int edad){
            this.edad=edad;
        }
    public int getEdad(){
        
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "DNI=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + edad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.dni);
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
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.edad, other.edad);
    }
} // fin clase