package com.rmc.app.Exception;

public class CategoriaNotFoundException extends RuntimeException {
 
    public CategoriaNotFoundException(Long id){
        super("Categoria no encontrada");
    }
}
