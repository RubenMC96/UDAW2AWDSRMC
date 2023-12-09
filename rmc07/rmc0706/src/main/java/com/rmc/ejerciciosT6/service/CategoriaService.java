package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.domain.Categoria;


@Service
public interface CategoriaService {

    public Categoria añadir(Categoria categoria);

    public List<Categoria> obtenerTodos();

    public Categoria obtenerPorId(long id);

    public Categoria editar(Categoria categoria);

    public void borrar(Long id);
}
