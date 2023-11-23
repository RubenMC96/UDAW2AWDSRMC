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


import java.util.ArrayList;
import java.util.List;

public class Hotel {
    protected ArrayList<Habitacion> hoteles = new ArrayList<>();
    protected int numHabitacion;
    protected int habitacionesLowCost = 3;
    protected int habitacionesDoble = 10;
    protected int habitacionesSuit = 5;
    protected final float precioLowCost;
    protected final float precioDoble;
    protected final float precioSuit;
    protected final float suplementoDoble;
    protected final float descuentoSuit;


    
    
   

    Hotel () {
   
            this.precioLowCost = 50;
            this.precioDoble = 100;
            this.precioSuit = 200;
            this.suplementoDoble = precioDoble*0.2f;
            this.descuentoSuit = precioSuit*0.2f;

            for(int i = 1; i <= habitacionesLowCost; i++){
                    
               hotel.addHabitacion(new LowCost(i));
            }
            for(int i = 1; i <= habitacionesLowCost; i++){
                    
               hotel.addHabitacion(new Doble(i));
            }
            for(int i = 1; i <= habitacionesLowCost; i++){
                    
               hotel.addHabitacion(new Suit(i));
            }

    }
   
    public Integer gethabitacionesLowCost(){
        return habitacionesLowCost;
    }
    public Integer gethabitacionesDoble(){
        return habitacionesDoble;
    }
    public Integer gethabitacionesSuit(){
        return habitacionesSuit;
    }
    public List<Habitacion> getlistaHabitaciones(){
        return hotel;
    } 

     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
        result = prime * result + numHabitacion;
        result = prime * result + habitacionesLowCost;
        result = prime * result + habitacionesDoble;
        result = prime * result + habitacionesSuit;
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
        Hotel other = (Hotel) obj;
        if (hotel == null) {
            if (other.hotel != null)
                return false;
        } else if (!hotel.equals(other.hotel))
            return false;
        if (numHabitacion != other.numHabitacion)
            return false;
        if (habitacionesLowCost != other.habitacionesLowCost)
            return false;
        if (habitacionesDoble != other.habitacionesDoble)
            return false;
        if (habitacionesSuit != other.habitacionesSuit)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Hotel [hotel=" + hotel + ", numHabitacion=" + numHabitacion + ", habitacionesLowCost="
                + habitacionesLowCost + ", habitacionesDoble=" + habitacionesDoble + ", habitacionesSuit="
                + habitacionesSuit + "]";
    }
}

