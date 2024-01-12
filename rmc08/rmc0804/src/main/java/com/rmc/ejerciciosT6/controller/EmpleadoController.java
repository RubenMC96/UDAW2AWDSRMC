package com.rmc.ejerciciosT6.controller;

import java.util.ArrayList;
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

import com.rmc.ejerciciosT6.DTO.EmpleadoDTO;
import com.rmc.ejerciciosT6.DTO.EmpleadoNuevoDTO;
import com.rmc.ejerciciosT6.Exception.EmpleadoNotFoundException;
import com.rmc.ejerciciosT6.Exception.EmptyListEmpleadosException;
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
    public ResponseEntity<?> getList() {

        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if(listaEmpleados.isEmpty()){
            throw new EmptyListEmpleadosException();
        }
        else{
            List<EmpleadoDTO> listaEmpleadoDTO = new ArrayList<>();
            for(Empleado e : listaEmpleados){
                listaEmpleadoDTO.add(modelMapper.map(e,EmpleadoDTO.class));
                return ResponseEntity.ok(listaEmpleadoDTO);
            }

            return ResponseEntity.ok(listaEmpleados);
        }
    }
    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOnElement(@PathVariable Long id) {

        Empleado empleado = empleadoService.obtenerPorId(id);
        if(empleado == null)
            throw new EmpleadoNotFoundException(id);
        else
            return ResponseEntity.ok(empleado);
    }


    @PostMapping("/empleado")
    public ResponseEntity <?> newElement(@Valid @RequestBody EmpleadoNuevoDTO empleadoNuevoDTO) {
    //@Valid si no se cumple la validación devuelve BAD_REQUEST 
    
        Empleado empleado = new Empleado(null, 
            empleadoNuevoDTO.getNombre(),
            empleadoNuevoDTO.getEmail(),
            empleadoNuevoDTO.getSalario(),
            empleadoNuevoDTO.isEnActivo(),
            empleadoNuevoDTO.getGenero(),
            departamentoService.obtenerPorId(empleadoNuevoDTO.getDepartementoId()));

            Empleado empleadoSave = empleadoService.añadir(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSave);
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@Valid @RequestBody EmpleadoNuevoDTO editEmpleado, @PathVariable Long id){
        
        Empleado empleado = empleadoService.obtenerPorId(id);
        
        if (empleado == null)
        throw new EmpleadoNotFoundException(id);
         
        else{
            empleado = new Empleado(id,
                editEmpleado.getNombre(),
                editEmpleado.getEmail(),
                editEmpleado.getSalario(),
                editEmpleado.isEnActivo(),
                editEmpleado.getGenero(),
                departamentoService.obtenerPorId(editEmpleado.getDepartementoId()));
        
            Empleado empleadoSave = empleadoService.editar(empleado);
            return ResponseEntity.ok(empleadoSave);
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        
        Empleado empleado = empleadoService.obtenerPorId(id);
        
        if (empleado == null)
            throw new EmpleadoNotFoundException(id);

        empleadoService.borrar(id);

        return ResponseEntity.noContent().build();
    }

    
}