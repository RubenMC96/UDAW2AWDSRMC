package com.rmc.ejerciciosT6;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rmc.ejerciciosT6.domain.Departamento;



public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

public List<Departamento> findByNombre (String nombre);
public List<Departamento> findByNombreEquals (String nombre);


}

