package com.rmc.app.controller;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rmc.app.DTO.NuevaCuentaDTO;
import com.rmc.app.Exception.EmptyListCuentaException;
import com.rmc.app.domain.Cuenta;
import com.rmc.app.service.CuentaService;
import com.rmc.app.service.MovimientoService;

import jakarta.validation.Valid;




@RestController
public class CuentaController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;
    @Autowired
    public ModelMapper modelMapper;

        @GetMapping({"/cuenta"})
        public ResponseEntity<?> showList(){

            try{
                List<Cuenta>listaCuentas = cuentaService.obtenerTodos();
            
                return ResponseEntity.ok(listaCuentas);
            }
            catch(EmptyListCuentaException c){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, c.getMessage());
            }
            // model.addAttribute("listacuentas", );
            // model.addAttribute("cuentaMaxSaldo", cuentaService.obtenerCuentaMaxSaldo());
            // return "CuentaView/ListCuentaView";
           /*Preguntar como devuelvo dos datos (lista cuenta y Max Saldo) */

        }
        @PostMapping("/cuenta")
        public ResponseEntity<?> showNuevo(@Valid @RequestBody NuevaCuentaDTO nuevaCuentaDTO){
            Cuenta cuenta = new Cuenta(
                nuevaCuentaDTO.getIban(),
                null);
            Cuenta cuentaSave = cuentaService.añadir(cuenta);
            return ResponseEntity.status(HttpStatus.CREATED).body(cuentaSave);
        }

        @DeleteMapping("/cuenta/{iban}")
        public ResponseEntity<?> showDelete(@PathVariable String iban) {
            cuentaService.borrar(iban);
            return ResponseEntity.noContent().build();
            
        }


    
}