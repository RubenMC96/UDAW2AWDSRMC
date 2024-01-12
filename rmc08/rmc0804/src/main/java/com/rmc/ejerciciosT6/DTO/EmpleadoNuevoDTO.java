package com.rmc.ejerciciosT6.DTO;

import com.rmc.ejerciciosT6.domain.Genero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoNuevoDTO {
    
    private String nombre;
    private String email;
    private Double salario;
    private boolean enActivo;
    private Genero genero;
    private Long departementoId;
}