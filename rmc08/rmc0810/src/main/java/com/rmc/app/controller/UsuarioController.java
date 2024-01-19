package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Usuario;
import com.rmc.app.service.UsuarioService;
import com.rmc.app.service.ProductoService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/usuario") 
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProductoService productoService;

        @GetMapping({"/", "/list"})
        public String showList(Model model){
            model.addAttribute("listaUsuario", usuarioService.obteberLista());
            return "UsuarioView/ListUsuView";
        }
        @GetMapping("/nuevo")
        public String showNuevo(Model model){
            model.addAttribute("usuarioForm", new Usuario());
            return "UsuarioView/UsuFormNew";
        }
        @PostMapping("/nuevo/submit")
        public String showNuevoSubmit (
            @Valid Usuario usuarioForm,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/usuario/nuevo";
                usuarioService.añadir(usuarioForm);
                    return "redirect:/usuario/list";
        }
        @PostMapping("/editar/submit")
        public String showEditSubmit (
            @Valid Usuario usuarioForm,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/usuario/editar/{id}";
                usuarioService.editar(usuarioForm);
                    return "redirect:/usuario/list";
        }

        @GetMapping("/editar/{id}")
        public String showEditForm(@PathVariable long id, Model model) {
            Usuario usuario = usuarioService.obtenerPorId(id);
            // el commandobject del formulario es el empleado con el id solicitado
            if (usuario != null) {
                model.addAttribute("usuarioForm", usuario);
                return "usuarioView/UsuFormEdit";
            }
            // si no lo encuentra vuelve a la página de inicio.
            return "redirect:/usuario/list";
        }

        @GetMapping("/borrar/{id}")
        public String showDelete(@PathVariable long id) {
            if(productoService.findByCategory(id).size() == 0){
                usuarioService.borrar(id);
                return "redirect:/usuario/list";
            }
            return "redirect:/usuario/";
            
        }


    
}