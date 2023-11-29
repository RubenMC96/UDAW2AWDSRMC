package com.rmc.ejerciciosT6.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/*Aqui es donde ponemos las ManyToOne*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity

public class Empleado {
    @ManyToOne
    private Departamento departamento;
    @Id
    @GeneratedValue
    @Min(value = 0)
        private Long id;
    @NotEmpty
        private String nombre;
    @Email(message = "Debe tener formato email valido")
        private String email;
        private Double salario;
        private boolean enActivo;
        private Genero genero;
}
