package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.domain.Departamento;


@Service
public interface DepartamentoService {
Departamento añadir(Departamento departamento);
List<Departamento> obtenerTodos();
Departamento obtenerPorId(long id);
Departamento editar(Departamento departamento);
void borrar(Departamento departamento);
Departamento obtenerPorNombre(String nombre);
}
