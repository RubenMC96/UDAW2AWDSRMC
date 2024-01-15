package com.rmc.app.Exception;

public class MovimientoNotFoundException extends RuntimeException {
    public MovimientoNotFoundException(Long id){
        super("Movimiento no encontrado");
    }
}
