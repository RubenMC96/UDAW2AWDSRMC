package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.Repositories.PuestoRepository;
import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Proyecto;
import com.rmc.ejerciciosT6.domain.Puesto;


@Service
public interface PuestoServiceImp extends PuestoService {

    @Autowired
    PuestoRepository repositorio;

    public Puesto añadir(Puesto puesto){
        return repositorio.save(puesto);
    }

    public Puesto obtenerPorId(long id){
        return repositorio.findById(id);
    }

    public void borrar(Puesto puesto){
        repositorio.deleteById(puesto);
    }

    public List<Proyecto> obtenerPorEmpleado (Empleado empleado){

        return repositorio.findByEmpleado(empleado);
        
    }
    public List<Proyecto> obtenerPorProyeto (Proyecto proyecto){


        return repositorio.findByProyecto(proyecto);
    }
    public List<Proyecto> obtenerPorPuesto (Empleado empleado, Proyecto proyecto){

                return repositorio.findByPuesto(empleado, proyecto);


    }


    
}
