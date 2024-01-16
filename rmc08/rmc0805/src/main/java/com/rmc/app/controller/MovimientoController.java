package com.rmc.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.rmc.app.DTO.NuevaCuentaDTO;
import com.rmc.app.DTO.NuevoMovimientoDTO;
import com.rmc.app.Exception.EmptyListMovimientoException;
import com.rmc.app.domain.Movimiento;
import com.rmc.app.service.CuentaService;
import com.rmc.app.service.MovimientoService;

import jakarta.validation.Valid;




@Controller
public class MovimientoController {

    @Autowired
    public MovimientoService movimientoService;
    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public NuevaCuentaDTO nuevaCuentaDTO;
/*Modificar el /new*/

    @GetMapping({"/movimiento/{iban}"})
    public ResponseEntity<?> showMovCuenta(@PathVariable String iban ,Model model){
        try{
            List<Movimiento> listaMovimientos = movimientoService.obtenerPorIdCuenta(iban);
            
            return ResponseEntity.ok(listaMovimientos);
        }
        catch(EmptyListMovimientoException m){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, m.getMessage());
        }

    }
    @PostMapping("/movimiento")
    public ResponseEntity<?> showNuevo(@Valid @RequestBody NuevoMovimientoDTO nuevoMovimientoDTO){
        Movimiento movimiento = new Movimiento(null,
        nuevoMovimientoDTO.getImporte(),
        null,
        cuentaService.obtenerPorId(nuevoMovimientoDTO.getIban()));
        Movimiento movimientoSave = movimientoService.añadir(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoSave);
    }
    @PostMapping("/new/submit")
    public String showNuevoSubmit (
        @Valid Movimiento movimientoForm,
        BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "redirect:/movimiento/new";
            movimientoService.añadir(movimientoForm);
                return "redirect:/";
    }
    
}