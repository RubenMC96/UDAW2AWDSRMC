package com.rmc.ejerciciosT6.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rmc.ejerciciosT6.domain.Categoria;



public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

public List<Categoria> findByNombre (String nombre);
public List<Categoria> findByNombreEquals (String nombre);


}

