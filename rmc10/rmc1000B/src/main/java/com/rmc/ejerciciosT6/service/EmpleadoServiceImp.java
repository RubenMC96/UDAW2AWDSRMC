package com.rmc.ejerciciosT6.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        if (empleado.getSalario() >= 1000 && empleado.getSalario() < 5000) {
            return repositorio.save(empleado);
        }
        return null; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {

        List<Empleado> empleadosRepo = repositorio.findAll();
        List<Empleado> empleadosActivos = new ArrayList<>();

        for(Empleado empleado : empleadosRepo){
            if(empleado.isEnActivo()) empleadosActivos.add(empleado);
        }
        return empleadosActivos;

        //return repositorio.findAll();
    }

    public Empleado obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor(double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.getEmployeWhereSalaryUPAvg();
    }
}
