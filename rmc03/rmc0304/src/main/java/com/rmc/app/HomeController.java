package com.rmc.app;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {

    Random random = new Random();
    public Set<Integer> lista = new LinkedHashSet<>();

    @GetMapping({"/", "/list", ""})
    public String showList(Model model){
        
        model.addAttribute("cantidadTotal", lista.size());
        model.addAttribute("listaNumeros", lista);

        return "listaView";
    }

    @GetMapping("/new")
    public String showNew(){

        int tamPrevioLista = lista.size();
        do{
            lista.add(random.nextInt(100)+1);
        }while(lista.size() == tamPrevioLista);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id){

        lista.remove(id);

        return "redirect:/list";
    }
}