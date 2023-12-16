package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping({"/{iban}"})
    public String showMovCuenta(@PathVariable String iban ,Model model){
        model.addAttribute("listaMovimientos", movimientoService.obtenerPorIdCuenta(iban));
        return "MovimientoView/ListMovView";
    }
    @GetMapping("/new")
    public String showNuevo(Model model){
        model.addAttribute("movimientoForm", new Movimiento());
        model.addAttribute("listaCuentas", cuentaService.obtenerTodos());
        return "MovimientoView/FormNew";
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