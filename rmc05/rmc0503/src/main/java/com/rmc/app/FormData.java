package com.rmc.app;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class FormData {
    
    private String nombre;
    @Email
    private String email;
    private String opcion;
    private String comentario;
    private boolean aceptar;

}
