package com.rmc.ejerciciosT6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping({"/empleado"})
    public ResponseEntity<?> getElements() {
        List<Empleado>  listaEmpleados = empleadoService.obtenerTodos();
        //return ResponseEntity.status(HttpStatus.OK).body(listaEmpleados);
        return ResponseEntity.ok(listaEmpleados);
    }


    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(
            @Valid @RequestBody Empleado nuevoEmpleado){

            Empleado empleadoAñadido = empleadoService.añadir(nuevoEmpleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoAñadido);
            }
    

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@PathVariable long id, @RequestBody Empleado empleado) {
        
        Empleado empleadoBusca = empleadoService.obtenerPorId(id);
        if(empleadoBusca == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


         Empleado empleadoEditado =empleadoService.editar(empleado);

            return ResponseEntity.status(HttpStatus.OK).body(empleadoEditado);
        }
    


    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable long id) {
        
        Empleado empleadoBusca = empleadoService.obtenerPorId(id);
        if(empleadoBusca == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        empleadoService.borrar(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
}