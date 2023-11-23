package com.rmc.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Producto {
    long id;
    String nombre;
    boolean oferta;
    TipoIva tipoIva;
    double precio;
}

