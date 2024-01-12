package com.rmc.ejerciciosT6.Exception;

public class EmptyListDepartamentosException extends RuntimeException {
    public EmptyListDepartamentosException(){
        super("La lista está vacía");
    }
}
 