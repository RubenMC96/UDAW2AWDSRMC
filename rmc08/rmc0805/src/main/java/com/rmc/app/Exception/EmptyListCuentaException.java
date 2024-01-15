package com.rmc.app.Exception;

public class EmptyListCuentaException extends RuntimeException {
 
    public EmptyListCuentaException(){
        super("La cuenta está vacía");
    }
}
