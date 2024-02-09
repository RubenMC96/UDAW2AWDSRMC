package com.rmc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
     @GetMapping({"/","/home","/inicio"})
    public String showInicio(){
        return "indexView";
    }
    @GetMapping("/signin")
        public String showLogin() { return "Log/loginView"; }
    @GetMapping("/signout")
        public String showLogout() { return "Log/logoutView"; }
}
