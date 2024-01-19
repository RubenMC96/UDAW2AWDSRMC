package com.rmc.app.Exception;

public class ValoracionNotFoundException extends RuntimeException{
    
    public ValoracionNotFoundException(Long id){
        super("Valoración no encontrado");
    }
}
