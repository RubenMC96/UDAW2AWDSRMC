package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Movimiento;

@Service
public interface MovimientoService {
    
    public Movimiento añadir(Movimiento movimiento);
    public List<Movimiento> obteberLista();
    public Movimiento obtenerPorIBAN(String IBAN);
    public Movimiento editar(Movimiento movimiento);
    public void borrar(String IBAN);
    public List<Movimiento> findByCuenta(String IBAN);


}
