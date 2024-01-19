package com.rmc.ejerciciosT6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
@Id
@GeneratedValue
private Long id;
@Column(unique = true) //evita duplicados a nivel base de datos
private String nombre;
private String password;
private Rol rol;
}