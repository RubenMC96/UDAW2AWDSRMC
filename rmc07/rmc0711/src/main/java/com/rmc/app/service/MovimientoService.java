package com.rmc.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Movimiento;

@Service
public interface MovimientoService {
    
    public Movimiento añadir(Movimiento movimiento);
    public List<Movimiento> obteberTodos();
    public List <Movimiento> obtenerPorIdCuenta(String iban);
    public LocalDateTime fecha();
}
