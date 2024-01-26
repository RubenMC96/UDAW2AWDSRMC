package com.rmc.app.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimiento {
    @Id
    private Long id;
    private Float importe;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cuenta cuenta;

}


