package com.rmc.ejerciciosT6.domain;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Puesto {






    @Id
    @GeneratedValue
    private Long id;;

    @NotEmpty
    private String puesto;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Empleado empleado;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Proyecto proyecto;
}
