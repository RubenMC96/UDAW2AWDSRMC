package com.rmc.ejerciciosT6;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rmc.ejerciciosT6.domain.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

List<Empleado> findByNombre (String nombre);
List<Empleado> findByNombreAndEmail (String nombre, String email);
List<Empleado> findByNombreEquals (String nombre);
List<Empleado> findBySalarioGreaterThanEqualOrderBySalario (double salario);
@Query("select e from Empleado e " +
"where e.salario > (select avg (e2.salario) from Empleado e2)")
List <Empleado> obtenerEmpleadoSalarioMayorMedia();

@Query("select e from Empleado e where e.nombre=?1 and e.email=?2")
Empleado obtenerEmpleadoPorNombreYEmail (String nombre,String email);

}

