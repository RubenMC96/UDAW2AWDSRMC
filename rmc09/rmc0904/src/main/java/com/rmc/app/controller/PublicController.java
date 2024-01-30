package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Contacto;
import com.rmc.app.service.ContactoService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/public") 
public class PublicController {

    @Autowired
    public ContactoService contactoService;

        @GetMapping({"/inicio"})
        public String showInicio(){
            
            return "indexView";
        }
        @GetMapping("/contacto")
        public String showContacto(Model model){
            model.addAttribute("contactoForm", new Contacto());
            return "ContactoView/ContFormNew";
        }
        @PostMapping("/contacto/submit")
        public String showContactoSubmit (
            @Valid Contacto contactoForm,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/public/contacto";
                contactoService.añadir(contactoForm);
                    return "redirect:/public/";
        }

        @GetMapping("/somos")
        public String showSomos() {
            // si no lo encuentra vuelve a la página de inicio.
            return "/SomosView/quienesSomosView";
        }

        @GetMapping("/signin")
        public String showLogin() { return "signinView"; }
        @GetMapping("/signout")
        public String showLogout() { return "signoutView"; }

    
}