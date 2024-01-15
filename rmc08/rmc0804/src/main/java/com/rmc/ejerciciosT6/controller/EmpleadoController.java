package com.rmc.ejerciciosT6.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

        
        try{
            List<Empleado> listaEmpleados = empleadoService.obtenerTodos(); 
            List<EmpleadoDTO> listaEmpleadoDTOs = new ArrayList<>();
            
            for (Empleado e : listaEmpleados) {
                EmpleadoDTO empleadoDTO = modelMapper.map(e, EmpleadoDTO.class); 
                  listaEmpleadoDTOs.add(empleadoDTO);
            }
            return ResponseEntity.ok(listaEmpleadoDTOs);
        }
        catch(EmptyListEmpleadosException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOnElement(@PathVariable Long id) {

        try{
            Empleado empleado = empleadoService.obtenerPorId(id);
            EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class); 
            return ResponseEntity.ok(empleadoDTO);
        }
        catch(EmpleadoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
           
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