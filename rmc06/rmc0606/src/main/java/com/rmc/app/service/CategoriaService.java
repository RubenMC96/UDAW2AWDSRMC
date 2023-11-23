package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Movimiento;

@Service
public interface CategoriaService {
    
    public Movimiento añadir(Movimiento categoria);
    public List<Movimiento> obteberLista();
    public Movimiento obtenerPorId(long id);
    public Movimiento editar(Movimiento categoria);
    public void borrar(Long id);

}
