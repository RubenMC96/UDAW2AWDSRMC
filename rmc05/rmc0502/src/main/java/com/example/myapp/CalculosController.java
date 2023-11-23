package com.example.myapp;


import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;



@Controller
@RequestMapping({"/calculos"})
public class CalculosController {

@Autowired
CalculosService calculosService;



    @GetMapping({"/primo"})
    public String showResultados(@RequestParam Integer numero, Model model){
        model.addAttribute("numero", numero);
        
        boolean primo = calculosService.esPrimo(numero);

            model.addAttribute("primo", primo);
        
        return "primoView";
    }
    

    @GetMapping({"/hipotenusa/{num1}/{num2}"})
    public String showHipotenusa(@PathVariable Integer num1, @PathVariable Integer num2, Model model){
        
        model.addAttribute("cat1", num1);
        model.addAttribute("cat2", num2);

        double hipo;

        hipo = calculosService.hipotenusa(num1, num2);

        if(hipo < 0) return "redirect:/index";
        else{
            model.addAttribute("hipotenusa", hipo);
            return "hipotenusaView";
        }
        
    }
    @GetMapping({"/sinRepetidos/{num}"})
    public String showSinRepetidos(@PathVariable Integer num, Model model){

            try{
                Set<Integer> lista = calculosService.sinRepetidos(num);
                model.addAttribute("listaAleatorios", lista);
                return "sinRepetidosView";
                
            } catch (Exception e) {
            return "redirect:/index";
            }

    }

    @GetMapping("/divisores/{div}")
    public String showDivisores (@PathVariable Integer div, Model model){

        model.addAttribute("num", div);
        
        List<Integer> lista = calculosService.divisores(div);

        model.addAttribute("divisores", lista);

        return "divisoresView";
    }
    @GetMapping("/divisores")
    public String showDivisores2 (@RequestParam ("num") Integer div, Model model){

        model.addAttribute("num", div);
        
        List<Integer> lista = calculosService.divisores(div);

        model.addAttribute("divisores", lista);

        return "divisores2View";
    }

    @GetMapping("/calc")
         public String showForm(Model model){
            model.addAttribute("formCalc1", new FormCalc());
            model.addAttribute("formCalc2", new FormCalc());
            model.addAttribute("formHipo", new FormHipo());
            return "calculosView";
        
        }

    @PostMapping("/primo/submit")
        public String showPrimos(@Valid @ModelAttribute FormCalc formCalc1, BindingResult bindingResult, Model model){
            
            model.addAttribute("primo", calculosService.esPrimo(formCalc1.getNum()));
            if (bindingResult.hasErrors()) return "errorView";
            else return "primoView";
        }
    @PostMapping("/hipotenusa/submit")
        public String showHipotenusa(@ModelAttribute FormHipo formHipo, Model model){
            
            model.addAttribute("hipotenusa", calculosService.hipotenusa(formHipo.getNum1(), formHipo.getNum2()));
            return "hipotenusaView";
        }
    @PostMapping("/divisores/submit")
        public String showDivisores(@Valid @ModelAttribute FormCalc formCalc2, BindingResult bindingResult, Model model){
            
            model.addAttribute("divisores", calculosService.divisores(formCalc2.getNum()));
            if (bindingResult.hasErrors()) return "errorView";
            else return "divisoresView";
        }

}
