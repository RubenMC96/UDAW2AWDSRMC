package com.rmc.app.Exception;

public class ProductoNotFoundException extends RuntimeException{
    
    public ProductoNotFoundException(Long id){
        super("Producto no encontrado");
    }
}
