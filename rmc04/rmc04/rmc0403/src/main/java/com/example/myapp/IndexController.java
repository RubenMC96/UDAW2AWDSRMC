package com.example.myapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class IndexController {

    
    @GetMapping({"/", "/home", "/index", " "})
    public String showIndex(Model model){

        return "indexView";
    }

}