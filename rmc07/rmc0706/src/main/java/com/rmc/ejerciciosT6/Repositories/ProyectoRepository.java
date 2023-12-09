package com.rmc.ejerciciosT6.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rmc.ejerciciosT6.domain.Proyecto;



public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

public List<Proyecto> findByNombre (String nombre);
public List<Proyecto> findByNombreEquals (String nombre);


}

