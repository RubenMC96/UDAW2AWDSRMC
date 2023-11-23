package com.tmct;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Random;


public class Primitiva {
    TreeSet<Integer> boleto = new TreeSet<>();
    int numBoletos = 6;    
        
    Primitiva () {
        Random random = new Random();
        for(int i = 0; i < numBoletos; i++ ){

            boleto.add(random.nextInt(1,50));

        }

    }
    public TreeSet getBoleto() {

        return boleto;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((boleto == null) ? 0 : boleto.hashCode());
        result = prime * result + numBoletos;
        result = prime * result + max;
        result = prime * result + min;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Primitiva other = (Primitiva) obj;
        if (boleto == null) {
            if (other.boleto != null)
                return false;
        } else if (!boleto.equals(other.boleto))
            return false;
        if (numBoletos != other.numBoletos)
            return false;
        if (max != other.max)
            return false;
        if (min != other.min)
            return false;
        return true;
    }
   
    
}

