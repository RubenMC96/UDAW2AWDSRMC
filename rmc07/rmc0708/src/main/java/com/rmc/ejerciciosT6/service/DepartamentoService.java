package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.domain.Departamento;


@Service
public interface DepartamentoService {

    public Departamento añadir(Departamento departamento);

    public List<Departamento> obtenerTodos();

    public Departamento obtenerPorId(long id);

    public Departamento editar(Departamento departamento);

    public void borrar(Long id);
}
