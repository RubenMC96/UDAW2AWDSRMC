package com.rmc.ejerciciosT6.Exception;

public class DepartamentoNotFoundException extends RuntimeException{
    public DepartamentoNotFoundException(Long id){
        super("Departamento no encontrado");
    }
    
}
