package com.example.myapp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping({"/fechas"})
public class FechasController {

@Autowired
FechasService fechasService;



@GetMapping({"/{fecha1}/{fecha2}"})
public ResponseEntity <?> showResultados(@PathVariable String fecha1, @PathVariable String fecha2){
    
    if(fecha1 == null && fecha2 == null){
        long tiempo = fechasService.diasAnno();
    
    return ResponseEntity.ok(tiempo);
    }
    else if(fecha2 == null){
    
        long tiempo = fechasService.periodoFechas(fecha1, fecha2);

    return ResponseEntity.ok(tiempo);

    }
    else{
        long tiempo = fechasService.diasPasadosEnero(fecha1);
        return ResponseEntity.ok(tiempo);

    }

        
    
}
    

    /////
@GetMapping({"/bisiesto/{fecha}/{fecha2}"})
public ResponseEntity <?> showBisiestsos(@PathVariable String fecha1, @PathVariable String fecha2){

    if(fecha2 == null) {
    boolean bisiesto = fechasService.bisiesto(fecha1);
   
    return ResponseEntity.ok(bisiesto);
    }  
    else{
    List<Integer> annos = fechasService.annosBisiesto(fecha1, fecha2);

    return ResponseEntity.ok(annos);
    } 
}

}
