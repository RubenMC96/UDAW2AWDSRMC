package com.rmc.ejerciciosT6.Exception;

public class EmptyListEmpleadosException extends RuntimeException {
    public EmptyListEmpleadosException(){
        super("La lista está vacía");
    }
}
