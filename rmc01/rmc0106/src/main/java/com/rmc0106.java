/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.tmct;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author ruben.munozcumbreras
 */
/*
1.6. Realizar una clase llamada Primitiva que tenga definido una colección de 6 elementos con el
resultado de un sorteo de la primitiva (serán 6 enteros con valores comprendidos entre 1 y 49 y sin
repetidos). Los números se deberán mostrar ordenados ascendentemente así que decide cual es la
colección que mejor se adapta a estos requisitos.
La clase dispondrá de un constructor en el que se generan y almacenen esos números al azar, también
tendrá un método al que se le pase una combinación jugada como parámetro (no necesariamente
ordenada) y devuelva el número de aciertos. Realiza a continuación un programa en el que el usuario
introduzca boletos (6 números sin repetidos) y le diga cuantos acertó.
Realizar control de errores, tanto si el usuario introduce valores no numéricos, números repetidos o
valores no comprendidos entre 1 y 49.
*/
public class rmc0106 {

   
    static Scanner teclado = new Scanner (System.in );
    static TreeSet<Integer> boleto = new TreeSet<>();
    static Primitiva boletoSorteo = new Primitiva();

    public static void main(String[] args) {

        String numBoleto, numBueno [];

        
        Primitiva ();
            do{

                System.out.println("Introduce los 6 números de su boleto: (números entre 1 y 49) ");

                try{
                
                    int num = Integer.parseInt(teclado.nextLine());


                    if(num <1 || num > 49){
                    
                        
                        if(!boleto.add(num)){

                            System.out.println("Numero repetido");
                        }
                        else{
                            boleto.add(num);
                        }

                    }
                    else{
                        System.out.println("Número no comprendido entre 1 y 49");
                    }

                }
                catch (NumberFormatException e) {
                System.out.println("El dato proporcionado no es un número");
                }
               
            }while(boleto.size()<=6);

            if(comprobarBoleto() == 6){
        
                System.out.println("Ha acertado todos los números");
            }
            else if(comprobarBoleto() >= 1 && comprobarBoleto() <=5 ) {
                System.out.println("Se han acertado: " + comprobarBoleto() + "números");
            }
            else{
                System.out.println("No se han acertado nigun número");
            }

    }
      
    public static Int comprobarBoleto(){
       int aciertos;

        aciertos = boletoSorteo.hashCode(boleto);

        return aciertos;
    }
    
}
