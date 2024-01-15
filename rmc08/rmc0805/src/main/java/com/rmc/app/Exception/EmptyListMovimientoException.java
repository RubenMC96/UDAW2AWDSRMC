package com.rmc.app.Exception;

public class EmptyListMovimientoException extends RuntimeException {
    public EmptyListMovimientoException () {
        super("No hay movimientos");
        
    }
    
}
