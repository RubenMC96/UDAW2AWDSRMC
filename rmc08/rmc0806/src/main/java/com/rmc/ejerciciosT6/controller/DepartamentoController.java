package com.rmc.ejerciciosT6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmc.ejerciciosT6.Exception.DepartamentoNotFoundException;
import com.rmc.ejerciciosT6.Exception.EmptyListDepartamentosException;
import com.rmc.ejerciciosT6.domain.Departamento;
import com.rmc.ejerciciosT6.service.DepartamentoService;

import jakarta.validation.Valid;

@RestController
public class DepartamentoController {
    
    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping({"/departamento"})
    public ResponseEntity<?> getList() {
        List<Departamento> listaDepartamento = departamentoService.obtenerTodos();
        if(listaDepartamento.isEmpty()){
            throw new EmptyListDepartamentosException();
        }
        else{
            return ResponseEntity.ok(listaDepartamento);
        }
    }

    @PostMapping("/departamento")
    public ResponseEntity<?> newDTO(@Valid @RequestBody Departamento nuevoDepartamento) {
        // el commandobject del formulario es una instancia de empleado vacia
        //Completar con metodo findByNombre => buscar countByNombre
        Departamento departamento = departamentoService.añadir(nuevoDepartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
    }


    @PutMapping("/departamento/{id}")
    public ResponseEntity<?> editFormDTO(@Valid @RequestBody Departamento editDepartamento, @PathVariable long id) {
        departamentoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
       
        departamentoService.editar(editDepartamento);
        return ResponseEntity.ok(editDepartamento);
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteDTO(@PathVariable long id) {
        departamentoService.obtenerPorId(id);

            departamentoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}