package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.Repositories.CategoriaRepository;
import com.rmc.ejerciciosT6.domain.Categoria;


@Service
public class CategoriaServiceImp implements CategoriaService{
    @Autowired
    CategoriaRepository repositorio;

    public Categoria añadir(Categoria categoria) {
        repositorio.save(categoria);
        return categoria; // podría no devolver nada, o boolean, etc.
    }

    public List<Categoria> obtenerTodos() {
        return repositorio.findAll();
    }

    public Categoria obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Categoria editar(Categoria categoria) {
        return repositorio.save(categoria);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

}
