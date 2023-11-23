package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Movimiento;
import com.rmc.app.service.MovimientoService;
import com.rmc.app.service.CuentaService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/movimiento") 
public class MovimientoController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;

        @GetMapping({"/", "/list"})
        public String showList(Model model){
            model.addAttribute("listaMovimiento", movimientoService.obteberLista());
            return "MovimientoView/ListMovView";
        }
        @GetMapping("/nuevo")
        public String showNuevo(Model model){
            model.addAttribute("movimientoForm", new Movimiento());
            return "MovimientoView/MovFormNew";
        }
        @PostMapping("/nuevo/submit")
        public String showNuevoSubmit (
            @Valid Movimiento movimientoForm,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/movimiento/nuevo";
                movimientoService.añadir(movimientoForm);
                    return "redirect:/movimiento/list";
        }
}