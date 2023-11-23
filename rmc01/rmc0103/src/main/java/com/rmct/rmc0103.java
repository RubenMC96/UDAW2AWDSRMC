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

     static int edad, opcion;
    static String nombre, dni;
    static ArrayList<Persona> personas = new ArrayList<>();
    static Persona person = new Persona();
    static Scanner teclado = new Scanner (System.in );
    public static void main(String[] args) {
               
        boolean salir = false;
        
        
        do{
            System.out.println("Seleccione una opción:\n "
                    + "1.Devolver la edad del mayor.\n "
                    + "2.Devolver la edad media.\n "
                    + "3.Devolver el nombre del mayor.\n "
                    + "4.Devolver la persona mayor.\n "
                    + "5.Devolver todos los mayores de edad.\n "
                    + "6.Devolver todos los que tienen una edad mayor o igual a la media.\n"
                    + "7.Añaidr persona.\n"
                    + "8.Eliminar persona.\n"
                    + "9.Salir");

            opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion){
                case 1 -> System.out.println("La persona con mayor edad tiene: " + mayorEdad() + " años");
                case 2 -> System.out.println("La media de edad es: " + mediaEdad() + " años");
                case 3 -> System.out.println("El mayor se llama: " + nombreMayor());
                case 4 -> {
                            Persona mayor = new Persona();
                            mayor = personaMayor();
                            System.out.println("La persona mayor es:\n" + 
                            "Nombre: " + mayor.getNombre() + "\n" + 
                            "DNI: " + mayor.getDNI() + "\n" + 
                            "Edad: " + mayor.getEdad());
                            }
                case 5 -> {
                            List mayores = new ArrayList<>();
                            mayores = mayoresDeEdad();
                            for(Persona mayoresEdad : mayores)
                            System.out.println(mayoresEdad);
                            for(Persona mayoresEdadMedia : mayores){
                            System.out.println("La persona mayor es:\n" + 
                            "Nombre: " + mayoresEdad.getNombre() + "\n" + 
                            "DNI: " + mayoresEdad.getDNI() + "\n" + 
                            "Edad: " + mayoresEdad.getEdad());
                            }
                          }
                case 6 -> 
                        {
                            List mayores = new ArrayList<>();
                            mayores = edadMayorMedia();
                            for(Persona mayoresEdadMedia : mayores){
                            System.out.println("La persona mayor es:\n" + 
                            "Nombre: " + mayoresEdadMedia.getNombre() + "\n" + 
                            "DNI: " + mayoresEdadMedia.getDNI() + "\n" + 
                            "Edad: " + mayoresEdadMedia.getEdad());
                            }
                          }
                case 7 ->  {
                            System.out.println("Introduce el DNI, nombre y edad de la persona:");
                            dni = teclado.nextLine();
                            nombre = teclado.nextLine();
                            edad = Integer.parseInt(teclado.nextLine());
                            nuevo(dni,nombre,edad);
                            }
                case 8 -> {
                            String dni;
                            System.out.println("Introduce el DNI de la persona");
                            dni = teclado.nextLine();
                            if(eliminar(dni)){
                                system.out.println("Registro eliminado");
                            }
                            else{
                                system.out.println("DNI no encontrado");
                            }
                        
                          }
                default -> System.out.println("Opción errónea");
            }
        }while(opcion != 9);
    }
        
    public static int mayorEdad(){
        int mayor = 0;
        for (Persona persona : personas) {
            if(person.getEdad() > mayor){
                mayor = persona.getEdad();
            }
        }
            return mayor;
    }
    public static int mediaEdad(){
        int suma= 0, media = 0;
        for (Persona persona : personas) {
            suma += persona.getEdad();
            }
        media = suma/personas.size();

        return media;
    }
   
    public static Persona personaMayor(){
        
        Persona personaMayor = persona.get(0);
        for(Persona persona : personas){
            if(persona.getEdad() >= personaMayor.getEdad()){
                personaMayor = persona;
                
            }
        }
        return personaMayor;
    }
     public static String nombreMayor(){        
        return personaMayor().getNombre();
    }
    public static List<Persona> mayoresDeEdad(){
        List<Persona> mayores = new ArrayList<>();
        for(Persona persona : personas){
            if(person.getEdad() >= 18){

                return mayores.add(persona);
            }
        }
    }
    
    public static ArrayList<Persona> edadMayorMedia(){
        
        ArrayList<Persona> mayores = new ArrayList<>();
        for(Persona person : personas){
            if(person.getEdad() >= mediaEdad()){
                mayores.add(person);
               
            }
        }
         return mayores;
    }
    public static void nuevo(String dni, String nombre, int edad)
    {
        String DNI = dni;
        String name = nombre;
        int age = edad;
            person = new Persona(DNI,name,age);
            personas.add(person);
    }
    public static boolean eliminar(String dni){
        String buscarDNI = dni;
        for(Persona persona : personas){
            if(person.getDNI().equals(buscarDNI)){
                personas.remove(persona);
                return true;
            }
        }
        return false;
    }
   
}
