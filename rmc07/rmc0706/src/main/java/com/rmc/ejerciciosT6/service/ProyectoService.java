package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.domain.Proyecto;


@Service
public interface ProyectoService {

    public Proyecto añadir(Proyecto Proyecto);

    public List<Proyecto> obtenerTodos();

    public Proyecto obtenerPorId(long id);

    public Proyecto editar(Proyecto Proyecto);

    public void borrar(Long id);
}
