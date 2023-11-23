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
        
        model.addAttribute("formData", new Pais());

        return "contactoView";
    }

    @PostMapping("/formulario/submit")
    public String showFormulario(@Valid @ModelAttribute Pais formData, BindingResult bindingResult , Model model) {
        
        model.addAttribute("nombre", formData.getNombre());

        return "IndexView";
    }
    
}