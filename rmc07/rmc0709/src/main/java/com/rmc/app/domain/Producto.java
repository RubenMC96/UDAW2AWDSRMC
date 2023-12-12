package com.rmc.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Producto {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Boolean oferta;
    private TipoIva tipoIva;
    private Double precio;
    private Long idCategoria;

    @ManyToOne
    private Categoria categoria;
}



