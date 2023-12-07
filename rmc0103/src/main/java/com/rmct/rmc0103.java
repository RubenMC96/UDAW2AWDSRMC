/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.rmct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *
 * @author ruben.munozcumbreras
 */
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
public class rmc0103 {

     static int opcion;
     
    static String nombre, dni;
    static ArrayList<Persona> personas = new ArrayList<>();
    static Persona person = new Persona();
    static Scanner teclado = new Scanner (System.in );
    public static void main(String[] args) {
         
      
        ArrayList edad = new ArrayList<>();

          while (edad.size() < 3) {
            System.out.println("Edad");

            edad.add(teclado.nextInt());
        }
        
        for(int i = 0; i< edad.size(); i++){
            int media =+ i;
        }

        media = media / edad.size();

        edad.

        System.out.println("Media" + media);
       

    }
}
