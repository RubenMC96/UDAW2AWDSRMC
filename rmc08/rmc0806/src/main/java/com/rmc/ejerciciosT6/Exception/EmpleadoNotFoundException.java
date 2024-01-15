package com.rmc.ejerciciosT6.Exception;

public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(Long id){
        super("Empleado no encontrado");
    }
    
}
