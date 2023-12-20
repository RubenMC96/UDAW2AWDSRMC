package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Proyecto;
import com.rmc.ejerciciosT6.domain.Puesto;


@Service
public interface PuestoService {


    public Puesto añadir(Puesto puesto);

    public Puesto obtenerPorId(long id);

    public void borrar(long id);

    public List<Puesto> obtenerPorEmpleado (Empleado empleado);
    public List<Puesto> obtenerPorProyeto (Proyecto proyecto);
    public Puesto obtenerPorEmpleadoAndProyecto (Empleado empleado, Proyecto proyecto);
}
