package com.rmc.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @GetMapping({"/index", "/", "/home"})
    public String showIndex(){
        
        return "indexView";
    }

    @GetMapping("/quienes-somos")
    public String showAbouUs(Model model){

        String nombre = "Ruben";
        model.addAttribute("nombre", nombre);

        return "quienesSomosView";
    }

    @GetMapping("/contacto")
    public String contacto(){
        return "contactoView";
    }
    @GetMapping("/productos")
    public String productos(Model model){

        String tipo = "Alumno";
        model.addAttribute("tipo", tipo);
                   
        return "productosView";
    }
}