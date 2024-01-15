package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.Exception.EmpleadoNotFoundException;
import com.rmc.ejerciciosT6.Exception.EmptyListEmpleadosException;
import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.repositories.EmpleadoRepository;


@Service
public class EmpleadoServiceImp implements EmpleadoService{
    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        repositorio.save(empleado);
        return empleado; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {
        List<Empleado> lista = repositorio.findAll();
        
        if(lista.isEmpty()) throw new EmptyListEmpleadosException();
        
        return lista;
        
    }

    public Empleado obtenerPorId(long id) {

        Empleado empleado = repositorio.findById(id).orElse(null);
        if(empleado == null){
            throw new EmpleadoNotFoundException(null);
        }
        return empleado;
    }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor (double salario){
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.getEmployeWhereSalaryUPAvg();
    }
}
