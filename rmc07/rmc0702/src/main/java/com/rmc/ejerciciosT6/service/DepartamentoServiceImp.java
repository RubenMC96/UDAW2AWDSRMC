package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.DepartamentoRepository;
import com.rmc.ejerciciosT6.domain.Departamento;


@Service
public class DepartamentoServiceImp implements DepartamentoService{
    @Autowired
    DepartamentoRepository repositorio;

    public Departamento añadir(Departamento departamento) {
        repositorio.save(departamento);
        return departamento; // podría no devolver nada, o boolean, etc.
    }

    public List<Departamento> obtenerTodos() {
        return repositorio.findAll();
    }

    public Departamento obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

}
