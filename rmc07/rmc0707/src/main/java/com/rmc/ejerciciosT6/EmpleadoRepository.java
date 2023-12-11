package com.rmc.ejerciciosT6;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rmc.ejerciciosT6.domain.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}

