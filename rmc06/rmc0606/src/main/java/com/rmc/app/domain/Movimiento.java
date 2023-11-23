package com.rmc.app.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "IBAN")
public class Movimiento {
    private LocalDateTime data;
    private Float importe;
    private String IBAN;
}
