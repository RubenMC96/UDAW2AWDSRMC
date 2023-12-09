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

    public void borrar(Puesto puesto);

    public List<Proyecto> obtenerPorEmpleado (Empleado empleado);
    public List<Proyecto> obtenerPorProyeto (Proyecto proyecto);
    public List<Proyecto> obtenerPorPuesto (Empleado empleado, Proyecto proyecto);
}
