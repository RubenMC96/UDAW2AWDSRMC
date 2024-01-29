package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Rol;
import com.rmc.app.domain.Usuario;
import com.rmc.app.service.UsuarioService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;


        @GetMapping({"/"})
        public String showList(Model model){
            model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
            return "UsuarioView/ListUsuarioView";
        }
        @GetMapping("/nuevo")
        public String showNuevo(Model model){
            model.addAttribute("usuarioForm", new Usuario());
            model.addAttribute("Rol", Rol.values());
            return "UsuarioView/UsuarioFormNew";
        }
        @PostMapping("/nuevo/submit")
        public String showNuevoSubmit (
            @Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/usuario/nuevo";
                usuarioService.añadir(nuevoUsuario);
                    return "redirect:/usuario/";
        }

        @GetMapping("/borrar/{id}")
        public String showDelete(@PathVariable Long id) {
            usuarioService.borrar(id);
            return "redirect:/usuario/";
            
        }


    
}