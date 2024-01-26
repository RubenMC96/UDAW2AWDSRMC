package com.rmc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Cuenta;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;







@Controller
@RequestMapping("/cuenta")


public class CuentaController {
     @GetMapping({"/"})
    public String showInicio(){
        return cuentaService.obtenerTodos();
    }

    @GetMapping("/nuevo")
    public String nuevaCuenta(Model model) {

        model.addAttribute("formCuenta", new Cuenta());
 
        return "CuentaView/CuentaFormNew";
    }
    @PostMapping("/nuevo/submit")
    public String showNuevoSubmit(@Valid Cuenta cuentaForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/cuenta/nuevo";
        }
        cuentaService.añadir(cuentaForm);
        return "redirect:/cuenta/";
    }

    @GetMapping("/editar/{iban}")
    public String getMethodName(@PathVariable String iban ,Model model) {

            Cuenta cuenta = cuentaService.obtenerPorIban(iban);

            if(cuenta != null){
                model.addAttribute("cuentaForm", cuenta);
                return "CuentaView/cuentaEdit";
            }


    }
    
    @PostMapping("/editar/submit")
    public String postMethodName(@Valid Cuenta cuentaEdit, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()){
            return "/cuenta/editar/{iban}";
        }
        else{
            categoriaService.editar(cuentaEdit);
            return "/cuenta/";
        }
    }

    @GetMapping("/borrar/{iban}")
    public String getMethodName(@PathVariable String iban) {
        Cuenta cuenta = cuentaService.obtenerPorIban(iban);
        if(cuenta != null){
            cuentaService.borrar(iban);
            return "redirect:/cuenta/";
        }
        else{
            return "redirect:/cuenta/";
        }
    }
    
    
    
    
}
