package com.rmc.ejerciciosT6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.Exception.DepartamentoNotFoundException;
import com.rmc.ejerciciosT6.Exception.EmptyListDepartamentosException;
import com.rmc.ejerciciosT6.domain.Departamento;
import com.rmc.ejerciciosT6.repositories.DepartamentoRepository;


@Service
public class DepartamentoServiceImp implements DepartamentoService{
    @Autowired
    DepartamentoRepository repositorio;

    public Departamento añadir(Departamento departamento) {
        repositorio.save(departamento);
        return departamento; // podría no devolver nada, o boolean, etc.
    }

    public List<Departamento> obtenerTodos() {

        List<Departamento> lista = repositorio.findAll();
        
        if(lista.isEmpty()) throw new EmptyListDepartamentosException();
        
        return lista;
    }

    public Departamento obtenerPorId(long id) {

        Departamento departamento = repositorio.findById(id).orElse(null);
        if(departamento == null){
            throw new DepartamentoNotFoundException(id);
        }
        return departamento;
    }

    public Departamento editar(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

}
