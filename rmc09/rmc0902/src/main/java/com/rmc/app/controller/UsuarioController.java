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
import com.rmc.app.domain.Usuario;
import com.rmc.app.service.CuentaService;
import com.rmc.app.service.MovimientoService;

import jakarta.validation.Valid;




@Controller
public class UsuarioController {

    @Autowired
    public UsarioService usuarioService;


        @GetMapping({"/"})
        public String showList(Model model){
            model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
            return "UsuarioView/ListUsuarioView";
        }
        @GetMapping("/nuevo")
        public String showNuevo(Model model){
            model.addAttribute("usuarioForm", new Usuario());
            return "UsuarioView/UsuarioFormNew";
        }
        @PostMapping("/nuevo/submit")
        public String showNuevoSubmit (
            @Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/usuario/nuevo";
                usuarioService.añadir(nuevoUsuario);
                    return "redirect:/";
        }

        @GetMapping("/borrar/{iban}")
        public String showDelete(@PathVariable String iban) {
            usuarioService.borrar(iban);
            return "redirect:/";
            
        }


    
}