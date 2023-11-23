package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Cuenta;
import com.rmc.app.domain.Movimiento;

@Service
public interface CuentaService {
    
    public Cuenta añadir(Cuenta cuenta);
    public List<Cuenta> obteberLista();
    public Cuenta obtenerPorIBAN(String IBAN);
    public Cuenta editar(Cuenta cuenta);
    public void borrar(String IBAN);
    public void actualizarSaldo(Movimiento movimiento);
}
