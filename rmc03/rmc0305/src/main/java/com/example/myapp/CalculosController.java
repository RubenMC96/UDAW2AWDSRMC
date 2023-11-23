package com.example.myapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping({"/calculos"})
public class CalculosController {

    @GetMapping({"/primo"})
    public String showResultados(@RequestParam Integer numero, Model model){
        model.addAttribute("numero", numero);
        if(numero == null) return "redirect:/index";
        else{
            boolean primo = true;
            for (int i = 2; i <= numero / 2; i++) {
                if (numero % i == 0) {
                    primo = false;
                    break;
                }
            }
            model.addAttribute("primo", primo);
        }
        return "primoView";

    }

    @GetMapping({"/hipotenusa/{num1}/{num2}"})
    public String showHipotenusa(@PathVariable Integer num1, @PathVariable Integer num2, Model model){
        
        model.addAttribute("cat1", num1);
        model.addAttribute("cat2", num2);

        double hipo;

        hipo = Math.round(Math.sqrt((Math.pow(num1, 2) + Math.pow(num2, 2))));

        if(hipo < 0) return "redirect:/index";
        else{
            model.addAttribute("hipotenusa", hipo);
            return "hipotenusaView";
        }
        
    }
    @GetMapping({"/sinRepetidos/{num}"})
    public String showSinRepetidos(@PathVariable Integer num, Model model){

        
        Set<Integer> lista = new TreeSet<Integer>();
        if(num > 1 && num < 100){
            for(int i = 1; i <= num; i++){

                int aleatorio = (int) ((Math.random()*100)+1);

                lista.add(aleatorio);
            }
            model.addAttribute("listaAleatorios", lista);
            return "sinRepetidosView";
        }
        else{

            return "redirect:/index";

        }
           
    }

    @GetMapping("/divisores/{div}")
    public String showDivisores (@PathVariable Integer div, Model model){

        model.addAttribute("num", div);
        List <Integer> lista = new ArrayList<>();
        
        for(int i = div; i>= 1 ; i--){
            
            if(div % i == 0){
                lista.add(i);
            }
        }

        model.addAttribute("divisores", lista);

        return "divisoresView";
    }
    @GetMapping("/divisores")
    public String showDivisores2 (@RequestParam ("num") Integer div, Model model){

        model.addAttribute("num", div);
        List <Integer> lista = new ArrayList<>();
        
        for(int i = div; i>= 1 ; i--){
            
            if(div % i == 0){
                lista.add(i);
            }
            
        }

        model.addAttribute("divisores", lista);

        return "divisores2View";
    }



}