package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.Repositories.PuestoRepository;
import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Proyecto;
import com.rmc.ejerciciosT6.domain.Puesto;


@Service
public class PuestoServiceImp implements PuestoService{

     @Autowired
    PuestoRepository repositorio;

    public Puesto añadir(Puesto puesto){

        return repositorio.save(puesto);
    }

    public Puesto obtenerPorId(long id){
        Puesto puesto = repositorio.findById(id).orElse(null);
        if(repositorio != null){
            return puesto;
        }
        else{
            return null;
        }
    }

    public void borrar(long id){
         repositorio.deleteById(id);
    }

    public List<Puesto> obtenerPorEmpleado (Empleado empleado){

        return repositorio.findByEmpleado(empleado);
        
    }
    public List<Puesto> obtenerPorProyeto (Proyecto proyecto){
        return repositorio.findByProyecto(proyecto);
    }
    public Puesto obtenerPorEmpleadoAndProyecto (Empleado empleado, Proyecto proyecto){
        return repositorio.obtenerPorEmpleadoAndProyecto(empleado, proyecto);
    }
}
