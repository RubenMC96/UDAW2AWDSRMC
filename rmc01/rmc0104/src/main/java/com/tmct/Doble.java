package com.tmct;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
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
Cuestión 2: ¿Es útil que el método toString () en la clase Habitación?*/

import java.time.LocalDateTime;


public class Doble extends Habitacion{

    protected int habitaciones = 10;
    protected int numHabitacion;
    
    Doble () {}
    Doble (int habitacion) {
        this.numHabitacion = habitacion;
    }
    
    Doble (boolean ocupada) {
        
     super(ocupada);
     
    }
    
     public int getHabitaciones(){
        return habitaciones;
    }
    
    public int getNumHabitacion(){
        return numHabitacion;
    }
    
    public float checkOut(){
        float importe = 0;
        LocalDateTime fechaSalida = LocalDateTime.now();
        int tiempoEstancia = fechaSalida.getSecond()- fechaEntrada.getSecond();
        importe = tiempoEstancia * precio;
        int mes = fechaSalida.getMonth().getValue();
        if(mes == 3 || mes == 6 || mes == 7) {
            importe += suplemento;
        }
        
        ocupadas = false;
        return importe;
    }
    
}

