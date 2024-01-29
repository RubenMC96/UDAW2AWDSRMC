package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Cuenta;

@Service
public interface CuentaService {
    
    public Cuenta añadir(Cuenta categoria);
    public void borrar(String iban);
    public List<Cuenta> obtenerTodos();
    
}
