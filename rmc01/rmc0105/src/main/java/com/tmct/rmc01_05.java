/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.tmct;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ruben.munozcumbreras
 */
/*1.5. Se desea desarrollar un programa gestione los dispositivos domóticos de un edificio. Para ello
tendremos un ArrayList que contenga en principio 3 elementos, uno para el termostato de la
calefacción, otro para el ascensor y otro para el dial de la radio del hilo musical, pero en el futuro
podríamos tener más elementos.
El termostato tiene una fecha de última revisión, un valor entero en grados centígrados: mínimo 15,
máximo 80 y la temperatura inicial es 20. El ascensor tiene una planta en la que se encuentra, pudiendo
ser desde 0 a 8. La planta inicial es la cero. El dial de radio va desde 88.0 a 104.0 avanzando de décima
en décima, siendo el valor inicial 88.0.
De cada elemento (y los futuros que aparezcan) deben ser capaces de realizar las siguientes funciones:
• subir(), incrementa una unidad el elemento domótico. Devuelve true si la operación se realiza
correctamente o false si no se puede hacer por estar al máximo.
• bajar(): decrementa una unidad el elemento domótico. Devuelve true si la operación se realiza
correctamente o false si no se puede hacer por estar al mínimo.
• reset(): pone en la situación inicial el elemento domótico. No devuelve nada.
• verEstado(): Devuelve un String con el tipo de dispositivo y su estado actual.
Además, el termostato debe incluir un nuevo método:
• revisar(). Fija a la fecha de revisión a la fecha actual. No devuelve nada.
Una vez definido el sistema, crea un programa que inicie un ArrayList con una instancia de cada uno
de los 3 dispositivos y luego mediante un menú nos permita hacer operaciones, primero qué operación
queremos realizar (0:Salir, 1:subir un dispositivo, 2:bajar un dispositivo, 3: resetear un dispositivo,
4:revisar termostato) y luego seleccionar sobre que elemento queremos trabajar (verificando que sea
un valor entre 0 y el tamaño del ArrayList -1)
• El menú, además de las opciones nos mostrará siempre el estado de todos los dispositivos.
*/
public class rmc01_05 {

    static int opcion;
    static ArrayList<Elemento> domotica = new ArrayList<>();
    static Termostato termostato;
    static Ascensor ascensor;
    static Dial dial;
    static Scanner teclado = new Scanner (System.in );
    public static void main(String[] args) {
               
        boolean salir = false;
        Domotica();
        
        do{
            System.out.println("Seleccione una opción:\n "
                    + "0.Salir.\n "
                    + "1.Subir dispositivo.\n "
                    + "2.Bajar dispositivo.\n "
                    + "3.Resetear dispositivo.\n"
                    + "4.Ver estado.\n"
                    + "5.Resisar termostato");

            opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion){
                case 1 -> 
                    {
                        do{
                            System.out.println("Seleccione el elemento:\n "
                                    + "1.Termostato.\n "
                                    + "2.Ascensor.\n "
                                    + "3.Dial.\n "
                                    + "4.Salir");

                            opcion = Integer.parseInt(teclado.nextLine());

                            switch(opcion){
                                case 1 -> subirTermostato();
                                case 2 -> subirAscensor();
                                case 3 -> subirDial();
                                default -> System.out.println("Opción no valida\n");
                            }
                        }while(opcion != 4);
                    }
                case 2 -> 
                    {
                        do{
                            System.out.println("Seleccione el elemento:\n "
                                    + "1.Termostato.\n "
                                    + "2.Ascensor.\n "
                                    + "3.Dial.\n "
                                    + "4.Salir");

                            opcion = Integer.parseInt(teclado.nextLine());

                            switch(opcion){
                                case 1 -> bajarTermostato();
                                case 2 -> bajarAscensor();
                                case 3 -> bajarDial();
                                default -> System.out.println("Opción no valida\n");
                            }
                        }while(opcion != 4);
       
                    }
                case 3 -> 
                {
                    do{
                        System.out.println("Seleccione el elemento:\n "
                            + "1.Termostato.\n "
                            + "2.Ascensor.\n "
                            + "3.Dial.\n "
                            + "4.Salir");

                            opcion = Integer.parseInt(teclado.nextLine());

                            switch(opcion){
                                case 1 -> bajarTermostato();
                                case 2 -> bajarAscensor();
                                case 3 -> bajarDial();
                                default -> System.out.println("Opción no valida\n");
                                }
                    }while(opcion != 4);
                }
                case 4 ->
                {
                    do{
                        System.out.println("Seleccione el elemento:\n "
                                + "1.Termostato.\n "
                                + "2.Ascensor.\n "
                                + "3.Dial.\n "
                                + "4.Salir");

                        opcion = Integer.parseInt(teclado.nextLine());

                        switch(opcion){
                            case 1 -> bajarTermostato();
                            case 2 -> bajarAscensor();
                            case 3 -> bajarDial();
                            default -> System.out.println("Opción no valida\n");
                        }
                    }while(opcion != 4);
                }
                case 5 -> revisar();
                default -> System.out.println("Opción no valida\n");
            }
        }while(opcion != 0);
    }
    
    //Métodos subir para cada tipo de elemento
    public static void subirTermostato(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Termostato){
                    termostato.subir();
                    break;
                }
            }
    }
   
    public static void subirAscensor(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Ascensor){
                    ascensor.subir();
                    break;
                }
            }
    }
   
    public static void subirDial(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Dial){
                    dial.subir();
                    break;
                }
            }
    }       
       
    //Métodos bajar para cada tipo de elemento
    public static void bajarTermostato(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Termostato){
                    termostato.bajar();
                    break;
                }
            }
    }
   
    public static void bajarAscensor(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Ascensor){
                    ascensor.bajar();
                    break;
                }
            }
    }
   
    public static void bajarDial(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Dial){
                    dial.bajar();
                    break;
                }
            }
    }
    

    //Métodos reset para cada tipo de elemento
    public static void resetTermostato(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Termostato){
                    termostato.reset();
                    break;
                }
            }
    }
   
    public static void resetAscensor(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Ascensor){
                    ascensor.reset();
                    break;
                }
            }
    }
   
    public static void resetDial(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Dial){
                    dial.reset();
                    break;
                }
            }
    }

    //Métodos verEstado para cada tipo de elemento
    public static void verEstadoTermostato(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Termostato){
                    termostato.verEstado();
                    break;
                }
            }
    }
   
    public static void verEstadoAscensor(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Ascensor){
                    ascensor.verEstado();
                    break;
                }
            }
    }
   
    public static void verEstadoDial(){
        for(Elemento elemento : domotica){
            if(elemento instanceof Dial){
                    dial.verEstado();
                    break;
                }
            }
    }
    //Metodo revisar para termostato
    public static void revisar(){
       for(Elemento elemento : domotica){
            if(elemento instanceof Termostato){
                    termostato.revisar();
                    break;
                }
            }
      
       
    }
}
