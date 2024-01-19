package com.rmc.app.controllerApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerApi {
     @GetMapping({"/","/inicio"})
    public String showInicio(){
        return "indexView";
    }
}
