package com.rmc.app.Exception;

public class CuentaNotFoundException extends RuntimeException {
    public CuentaNotFoundException(String iban){
        super("Cuenta no encontrada");
    }    
}
