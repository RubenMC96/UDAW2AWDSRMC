package com.rmc.app;


import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {

    @GetMapping({"/index", "/", "/home"})
    public String showIndex2(@RequestParam("name") String nombre,Model model){
        
        model.addAttribute("nomb", nombre);


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