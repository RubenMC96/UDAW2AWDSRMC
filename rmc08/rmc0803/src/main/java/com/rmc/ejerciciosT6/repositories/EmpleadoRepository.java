package com.rmc.ejerciciosT6.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rmc.ejerciciosT6.domain.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

//Metodos Nativos o interfaces repository Pag 80 Cuadro

 
/* Metodos derivados
 Podemos generar nuestras propias funciones siguendo una syntaxis especial
*/
List<Empleado> findByNombre (String nombre);
List<Empleado> findByNombreAndEmail (String nombre, String email);
List<Empleado> findByNombreEquals (String nombre);
List<Empleado> findBySalarioGreaterThanEqualOrderBySalario (double salario);

//Metodo query
/*
 Ponemos la query seguido del método que la utiliza
 */
@Query("select e from Empleado e " +
"where e.salario > (select avg (e2.salario) from Empleado e2)")
List <Empleado> getEmployeWhereSalaryUPAvg ();
                

@Query("select e from Empleado e where e.nombre=?1 and e.email=?2")
List<Empleado> getEmployeeByNameAndEmail (String nombre,String email);

}

