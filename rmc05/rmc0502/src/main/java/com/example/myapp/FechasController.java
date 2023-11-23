package com.example.myapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping({"/fechas"})
public class FechasController {

@Autowired
FechasService fechasService;



    @GetMapping({"/"})
    public String showResultados(@RequestParam (required = false) String fecha1, @RequestParam (required = false) String fecha2 , Model model){
        
        if(fecha1 == null && fecha2 == null){
            long tiempo = fechasService.diasAnno();

            model.addAttribute("tiempo", tiempo);
        
        return "diasDesdeEneroView";
        }
        else if(fecha2 == null){
            model.addAttribute("fecha1", fecha1);
            model.addAttribute("fecha2", fecha2);
        
            long tiempo = fechasService.periodoFechas(fecha1, fecha2);

            model.addAttribute("tiempo", tiempo);
        
        return "diasAnnosView";

        }
        else{
            long tiempo = fechasService.diasPasadosEnero(fecha1);
            model.addAttribute("fecha", fecha1);
            model.addAttribute("tiempo", tiempo);
            return "diasPasadosView";

        }

            
        
    }
    

    
    @GetMapping({"/bisiesto"})
    public String showBisiestsos(@RequestParam (required = false) String fecha1, @RequestParam (required = false) String fecha2 , Model model){

        if(fecha2 == null) {
        boolean bisiesto = fechasService.bisiesto(fecha1);
    
        model.addAttribute("bisiesto", bisiesto);
        
        return "bisiestoView";
        }  
        else{
        List<Integer> annos = fechasService.annosBisiesto(fecha1, fecha2);

        model.addAttribute("annosBisiestos", annos);

        return "annosBisiestosView";
        } 
    }

    @GetMapping("/calcular")
         public String showForm(Model model){
            model.addAttribute("formFecha", new FormFecha());
            return "fechasView";
        
        }

    @PostMapping("/calcular/submit")
        public String showDias (@ModelAttribute FormFecha formFecha , Model model) {

            if(formFecha.getOpcion() == "dias"){
            model.addAttribute("dias", fechasService.periodoFechas(formFecha.getFecha1(), formFecha.getFecha2()));
        
            return "diasAnnosView";
            
            }
            model.addAttribute("bisiestos", fechasService.annosBisiesto(formFecha.getFecha1(), formFecha.getFecha2()));
            
            return "bisiestoView";       
        }

}
