package com.rmc.app;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;




@Controller
public class FormController {

    @GetMapping("/contacto")
    public String showIndex(Model model){
        
        model.addAttribute("formData", new FormData());

        return "contactoView";
    }

    @PostMapping("/formulario/submit")
    public String showFormulario(@Valid @ModelAttribute FormData formData, BindingResult bindingResult , Model model) {
        
        model.addAttribute("nombre", formData.getNombre());
        model.addAttribute("email", formData.getEmail());
        model.addAttribute("opcion", formData.getOpcion());
        model.addAttribute("comentario", formData.getComentario());
        if(formData.isAceptar()){
            String aceptar = "Has aceptado las condiciones";
            model.addAttribute("aceptar", aceptar);
        }
        else{
            String aceptar = "No has aceptado las condiciones";
            model.addAttribute("aceptar", aceptar);
        }
       
        if (bindingResult.hasErrors()) return "errorView";
        return "resultadoView";
    }
    
}