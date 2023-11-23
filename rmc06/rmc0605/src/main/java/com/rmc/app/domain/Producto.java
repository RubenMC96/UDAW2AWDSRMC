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
    private Long id;
    private String nombre;
    private Boolean oferta;
    private TipoIva tipoIva;
    private Double precio;
    private Long idCategoria;
}

