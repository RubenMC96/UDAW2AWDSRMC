package com.example.myapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
public class IndexController {

    
    @GetMapping("/home")
    public String showIndex(Model model){

        model.addAttribute("formData", new FormData());

        return "indexView";
    }
    @PostMapping("/home/submit")
    public String showForm(@ModelAttribute FormData formData) {
       
        formData.setNombre(formData.getNombre().toUpperCase());
        
        return "formView";
    }
    

}