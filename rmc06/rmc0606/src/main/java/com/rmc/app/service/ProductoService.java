package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Cuenta;

@Service
public interface ProductoService {
    
    public Cuenta añadir(Cuenta producto);
    public List<Cuenta> obteberLista();
    public Cuenta obtenerPorIBAN(String IBAN);
    public Cuenta editar(Cuenta producto);
    public void borrar(String IBAN);
    public List<Cuenta> findByCategory(String IBAN);
}
