package com.rmc.ejerciciosT6.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Proyecto;
import com.rmc.ejerciciosT6.domain.Puesto;





public interface  PuestoRepository extends JpaRepository<Puesto, Long> {

public List<Puesto> findByEmpleado (Empleado empleado);
public List<Puesto> findByProyecto (Proyecto proyecto);
public List<Proyecto> findBProyecto(Empleado emp, Proyecto proy);


}

