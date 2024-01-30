package com.rmc.app.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private LocalDate fechaRegistro;
    private Rol rol;
    private String password;
}
