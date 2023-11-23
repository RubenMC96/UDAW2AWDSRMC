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
1.5. Se desea desarrollar un programa gestione los dispositivos domóticos de un edificio. Para ello
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

import java.time.LocalDate;

public class Domotica implements Elemento{
    
    protected int numTermostato = 1;
    protected int numDial = 1;
    protected int numAscensor = 1;

    
    Domotica () {
        for(int i = 1; i <= numTermostato; i++){
                
            domotica.add(new Termostato());
         }
         for(int i = 1; i <= numAscensor; i++){
                 
            domotica.add(new Ascensor());
         }
         for(int i = 1; i <= numDial; i++){
                 
            domotica.add(new Dial());
         } 
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numTermostato;
        result = prime * result + numDial;
        result = prime * result + numAscensor;
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
        Domotica other = (Domotica) obj;
        if (numTermostato != other.numTermostato)
            return false;
        if (numDial != other.numDial)
            return false;
        if (numAscensor != other.numAscensor)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Domotica [numTermostato=" + numTermostato + ", numDial=" + numDial + ", numAscensor=" + numAscensor
                + "]";
    }
  
    
}
    
   

  
     


