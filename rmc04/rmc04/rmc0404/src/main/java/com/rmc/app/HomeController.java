package com.rmc.app;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class HomeController {

@Autowired
HomeService homeService;


   

    @GetMapping({"/", "/list", ""})
    public String showList(Model model){
         
        Set<Integer> lista = homeService.list;

        model.addAttribute("cantidadTotal", lista.size());
        model.addAttribute("listaNumeros", lista);

        return "listaView";
    }

    @GetMapping("/new")
    public String showNew(Model model){

        Set<Integer> lista = homeService.New();

        model.addAttribute("listaNumeros", lista);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id, Model model){



       Set<Integer> lista = homeService.Delete(id);

        model.addAttribute("listaNumeros", lista);

        return "redirect:/list";
    }
}