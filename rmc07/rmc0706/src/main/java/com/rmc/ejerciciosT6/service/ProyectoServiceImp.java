package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.Repositories.ProyectoRepository;
import com.rmc.ejerciciosT6.domain.Proyecto;


@Service
public class ProyectoServiceImp implements ProyectoService{
    @Autowired
    ProyectoRepository repositorio;

    public Proyecto añadir(Proyecto proyecto) {
        repositorio.save(proyecto);
        return proyecto; // podría no devolver nada, o boolean, etc.
    }

    public List<Proyecto> obtenerTodos() {
        return repositorio.findAll();
    }

    public Proyecto obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Proyecto editar(Proyecto Proyecto) {
        return repositorio.save(Proyecto);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

}
