package com.rmc.ejerciciosT6;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rmc.ejerciciosT6.domain.Departamento;



public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

List<Departamento> findByNombre (String nombre);
List<Departamento> findByNombreAndEmail (String nombre, String email);
List<Departamento> findByNombreEquals (String nombre);

@Query("select e from Departamento e where e.nombre=?1 and e.email=?2")
Departamento obtenerEmpleadoPorNombreYEmail (String nombre,String email);

}

