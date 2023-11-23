package com.tmct;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ruben.munozcumbreras
 */
/*1.4. Se desea hacer la gestión de las habitaciones de un hotel. Todas las habitaciones tienen un número
de habitación y un proceso de check-in y check-out. En el hotel hay tres tipos de habitaciones, aunque
podría haber más en el futuro:
- 3 habitaciones Lowcost (cuesta 50 euros/día todo el año).
- 10 habitaciones dobles. Tienen una tarifa normal de 100 euros/día y un incremento del 20%
si el día de salida es abril, julio o agosto.
- 5 habitaciones Suite. 200 euros/día con 20% de descuento para estancias de 10 o más días.
• Debes crear una o más clases para las habitaciones y una clase para el Hotel. La clase Hotel
tendrá las 18 habitaciones en un ArrayList y las marcará inicialmente como “no ocupadas”.
• El programa tendrá un menú para hacer check-in entre las habitaciones libres, check-out entre
las ocupadas y listar habitaciones libres y ocupadas.
• El check-in es común para todas las habitaciones, consiste en marcar la habitación como
ocupada. El check-out consiste en marcar la habitación como libre y calcular el importe a pagar
que se calculará en función del tipo de habitación y de los días de estancia (quizás sea
necesario almacenar la fecha de llegada en el momento del check-in)
• Sugerencia: Para probar el programa, al hacer el check-out, puedes considerar cada día como
un segundo, así, si han pasado 3 segundos, considerar 3 días.
Cuestión 1: ¿Habitación debería ser una clase abstracta o una interfaz? ¿Por qué?
    Debería ser una clase abstacta porque los tres tipos de habitaciones comparten la variable "ocupada" y el método checkIn definidos en la clase padre,
    por lo que estamos ante un caso de clase abstracta y no de interfaz.
Cuestión 2: ¿Es útil que el método toString () en la clase Habitación?
    Tal y como he planteado el programa no sería necesario el método toString debido a que todas las
    las salidas por consola las controlo desde el programa principal y dejo las clases solo para las operaciones, además de que 
    no hago uso de ninguna funcionalidad que requisiera del metodo tuString(), aun así es un método útil y nunca está de más 
    definirlo en las clases.
*/
public class rmc0104 {

    static int edad, opcion;
    static String nombre, dni;
    static Hotel hotel;
    static LowCost low;
    static Doble doble;
    static Suit suit = new Suit();
    static Scanner teclado = new Scanner (System.in );
    public static void main(String[] args) {
               
        boolean salir = false;
        Hotel();
        
        do{
            System.out.println("Seleccione una opción:\n "
                    + "1.Check-In.\n "
                    + "2.Check-Out.\n "
                    + "3.Lista de habitaciones.\n "
                    + "4.Salir");

            opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion){
                case 1 -> checkIn();
                case 2 -> checkOut();
                case 3 -> Lista();
                default -> System.out.println("Opción no valida\n");
            }
        }while(opcion != 4);
    }
      
    
    public static void checkIn(){
       
       do{
            System.out.println("Seleccione un tipo de habitación:\n "
                    + "1.Habitación LowCost.\n "
                    + "2.Habitación doble.\n "
                    + "3.Habitación Suit.\n "
                    + "4.Salir");

            opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion){
                case 1 -> checkInLowCost();
                case 2 -> checkInDoble();
                case 3 -> checkInSuit();
                default -> System.out.println("Opción no valida\n");
            }
        }while(opcion != 4);
       
    }
    //Métodos checkIn para cada tipo de habitacion
    public static void checkInLowCost(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            if(habitacion instanceof LowCost){
                if(habitacion.getOcupadas()!= true){
                    habitacion.checkIn();
                    break;
                }
            }
        }
    }
    public static void checkInDoble(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            if(habitacion instanceof Doble){
                if(habitacion.getOcupadas()!= true){
                    habitacion.checkIn();
                    break;
                }
            }
        }
    }
    public static void checkInSuit(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            if(habitacion instanceof Suit){
                if(habitacion.getOcupadas()!= true){
                    habitacion.checkIn();
                    break;
                }
            }
        }
    }

    public static void checkOut(){
       
       do{
            System.out.println("Seleccione un tipo de habitación:\n "
                    + "1.Habitación LowCost.\n "
                    + "2.Habitación doble.\n "
                    + "3.Habitación Suit.\n "
                    + "4.Salir");

            opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion){
                case 1 -> checkOutLowCost();
                case 2 -> checkOutDoble();
                case 3 -> checkOutSuit();
                default -> System.out.println("Opción no valida\n");
            }
        }while(opcion != 4);
       
    }
    //Procesos de checkOut para cada tipo de habitacion.
    public static void checkOutLowCost(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            if(habitacion instanceof LowCost){
                if(habitacion.getOcupadas()== true){
                    System.out.println("El importe es: " + low.checkOut());
                    break;
                }
            }
        }
    }
    public static void checkOutDoble(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            if(habitacion instanceof Doble){
                if(habitacion.getOcupadas()== true){
                    System.out.println("El importe es: " + doble.checkOut());
                    break;
                }
            }
        }
    }
    public static void checkOutSuit(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            if(habitacion instanceof Suit){
                if(habitacion.getOcupadas()== true){
                    System.out.println("El importe es: " + suit.checkOut());
                    break;
                }
            }
        }
    }
    public static void Lista(){
        for(Habitacion habitacion : hotel.getlistaHabitaciones()){
            //Habitaciones libres:
           if(habitacion.getOcupadas() == false){
           
               if(habitacion instanceof LowCost){
               
                   System.out.println("Habitación LowCost nº:" + low.numHabitacion + "vacía.");
                   
               } 
               else if(habitacion instanceof Doble){
               
                    System.out.println("Habitación Doble nº:" + doble.numHabitacion + "vacía.");

               } 
               else if(habitacion instanceof Suit){
               
                    System.out.println("Habitación Suit nº:" + suit.numHabitacion + "vacía.");

               } 
              
           }
           //Habitaciones ocupadas
           else{
               
                if(habitacion instanceof LowCost){
               
                   System.out.println("Habitación LowCost nº:" + low.numHabitacion + "ocupada.");
                   
               } 
               else if(habitacion instanceof Doble){
               
                    System.out.println("Habitación Doble nº:" + doble.numHabitacion + "ocupada.");

               } 
               else if(habitacion instanceof Suit){
               
                    System.out.println("Habitación Suit nº:" + suit.numHabitacion + "ocupada.");

               }    
            }
        }
    }
}
