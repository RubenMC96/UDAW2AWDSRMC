package com.rmc.app.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
public class Movimiento {
    @Id
    @GeneratedValue
    private Long id;
    private Float importe;
    private LocalDateTime fecha;


    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Cuenta cuenta;
}



