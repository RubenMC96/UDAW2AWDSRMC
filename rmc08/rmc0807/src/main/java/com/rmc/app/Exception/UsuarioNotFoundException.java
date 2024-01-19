package com.rmc.app.Exception;

public class UsuarioNotFoundException extends RuntimeException{
    
    public UsuarioNotFoundException(Long id){
        super("Usuario no encontrado");
    }
}
