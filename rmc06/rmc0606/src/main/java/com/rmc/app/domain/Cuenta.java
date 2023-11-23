package com.rmc.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "IBAN")

public class Cuenta {
    private String IBAN;
    private String nombre;
    private Float saldo = 0f;
    
}

