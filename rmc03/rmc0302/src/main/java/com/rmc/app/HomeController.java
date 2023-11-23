package com.rmc.app;


import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @GetMapping({"/index", "/", "/home"})
    public String showIndex(Model model){
        
        LocalDate fecha = LocalDate.now();
        int annoNum = fecha.getYear();
        String anno = Integer.toString(annoNum);
        model.addAttribute("fecha", anno);

        return "indexView";
    }

    @GetMapping("/quienes-somos")
    public String showAbouUs(Model model){

        String nombre = "Ruben";
        model.addAttribute("nombre", nombre);

        return "quienesSomosView";
    }

    @GetMapping("/contacto")
    public String contacto(Model model){

        

        return "contactoView";
    }
    @GetMapping("/productos")
    public String productos(Model model){

        String tipo = "Alumno";
        model.addAttribute("tipo", tipo);

        ArrayList <String> produc = new ArrayList<>();

        produc.add("Boligrafo");
        produc.add("Lapiz");
        produc.add("Libreta");

        model.addAttribute("nombProduct", produc);
                   
        return "productosView";
    }
}