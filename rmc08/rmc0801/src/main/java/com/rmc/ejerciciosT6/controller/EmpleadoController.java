package com.rmc.ejerciciosT6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {

        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if(listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(listaEmpleados);
    }
    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOnElement(@PathVariable Long id) {

        Empleado empleado = empleadoService.obtenerPorId(id);
        if(empleado == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(empleado);
    }


    @PostMapping("/empleado")
    public ResponseEntity <?> newElement(@Valid @RequestBody Empleado nuevEmpleado) {
    //@Valid si no se cumple la validación devuelve BAD_REQUEST        model.addAttribute("empleadoForm", new Empleado());
        Empleado empleado = empleadoService.añadir(nuevEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id){
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build();
        else
        empleadoService.editar(empleado);
            return ResponseEntity.ok(empleado);
    }

   
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}