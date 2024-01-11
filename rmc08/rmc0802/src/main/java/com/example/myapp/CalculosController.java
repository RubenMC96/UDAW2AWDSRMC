package com.example.myapp;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({"/calculos"})
public class CalculosController {

@Autowired
CalculosService calculosService;



    @GetMapping({"/primo/{numero}"})
    public ResponseEntity <?> showResultados(@PathVariable Integer numero){
        
        boolean primo = calculosService.esPrimo(numero);
            
        
        return ResponseEntity.ok(primo);
    }
    

    @GetMapping({"/hipotenusa/{num1}/{num2}"})
    public ResponseEntity <?> showHipotenusa(@PathVariable Integer num1, @PathVariable Integer num2){

        double hipo;

        hipo = calculosService.hipotenusa(num1, num2);

        if(hipo < 0) return ResponseEntity.notFound().build();
        else{
            return ResponseEntity.ok(hipo);
        }
        
    }
    @GetMapping({"/sinRepetidos/{num}"})
    public ResponseEntity <?> showSinRepetidos(@PathVariable Integer num){

            try{
                Set<Integer> lista = calculosService.sinRepetidos(num);
                
                return ResponseEntity.ok(lista);
                
            } catch (Exception e) {
            return ResponseEntity.notFound().build();
            }

    }

    @GetMapping("/divisores/{div}")
    public ResponseEntity <?> showDivisores (@PathVariable Integer div, Model model){
        
        List<Integer> lista = calculosService.divisores(div);

        return ResponseEntity.ok(lista);
    }
}
