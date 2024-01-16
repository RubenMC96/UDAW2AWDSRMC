package com.rmc.ejerciciosT6.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.service.DepartamentoService;
import com.rmc.ejerciciosT6.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @Autowired
    public DepartamentoService departamentoService;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("/empleado")
    public List<Empleado> getList() {
 
            List<Empleado> listaEmpleados = empleadoService.obtenerTodos(); 
            
            return listaEmpleados;
    }
    @GetMapping("/empleado/{id}")
    public Empleado getOnElement(@PathVariable Long id) {
    
            Empleado empleado = empleadoService.obtenerPorId(id);
        
            return empleado; 
    }


    @PostMapping("/empleado")
    public ResponseEntity <?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
    //@Valid si no se cumple la validación devuelve BAD_REQUEST 
    
        Empleado empleado = empleadoService.añadir(nuevoEmpleado);

        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping("/empleado/{id}")
    public Empleado editElement(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id){
        
        empleadoService.obtenerPorId(id);
        return empleadoService.editar(editEmpleado);
             
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        
        empleadoService.obtenerPorId(id);
        return ResponseEntity.noContent().build();       
    }

    
}