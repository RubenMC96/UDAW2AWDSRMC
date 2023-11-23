/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.tmct;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author ruben.munozcumbreras
 */
/*
1.7. Realizar un programa donde el usuario introduce un String y se muestre la cantidad de veces que
aparece cada letra (ordenadas alfabéticamente, no por orden de aparición). Para tener un rendimiento
óptimo, se debe recorrer el String solo una vez. Elige la colección óptima para minimizar el código
necesario.
*/
public class RMCt01_07 {

   
    static Scanner teclado = new Scanner (System.in );
    static HashMap<Character , Integer> contador = new HashMap<>();
    

    public static void main(String[] args) {

        String frase;

        System.out.println("Introduce una frase: ");
        frase = teclado.nextLine();

        for(int i = 0; i<= frase.length(); i++){

            char letra = frase.charAt(i);
            if(contador.containsKey(letra)){

                contador.put(letra, contador.get(letra) + 1);
            }
            else{
                contador.put(letra, 0);
            }
        }
        for( Map.Entry<Character, Integer> entry : contador.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());

        }
        

        contador.entrySet().stream().sorted(HashMap.Entry.comparingByKey()).
        forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue()));
    }
}
