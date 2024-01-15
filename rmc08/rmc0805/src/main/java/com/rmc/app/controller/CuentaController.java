package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rmc.app.domain.Cuenta;
import com.rmc.app.service.CuentaService;
import com.rmc.app.service.MovimientoService;

import jakarta.validation.Valid;




@Controller
public class CuentaController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;

        @GetMapping({"/"})
        public String showList(Model model){
            model.addAttribute("listacuentas", cuentaService.obtenerTodos());
            model.addAttribute("cuentaMaxSaldo", cuentaService.obtenerCuentaMaxSaldo());
            return "CuentaView/ListCuentaView";
        }
        @GetMapping("/new")
        public String showNuevo(Model model){
            model.addAttribute("cuentaForm", new Cuenta());
            return "CuentaView/CuentaFormNew";
        }
        @PostMapping("/new/submit")
        public String showNuevoSubmit (
            @Valid @ModelAttribute("cuentaForm") Cuenta nuevaCuenta,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/cuenta/new";
                cuentaService.añadir(nuevaCuenta);
                    return "redirect:/";
        }

        @GetMapping("/delete/{iban}")
        public String showDelete(@PathVariable String iban) {
            cuentaService.borrar(iban);
            return "redirect:/";
            
        }


    
}