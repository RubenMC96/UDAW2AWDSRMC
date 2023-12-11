package com.rmc.ejerciciosT6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmc.ejerciciosT6.service.EmpleadoService;



@Controller
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;


    @GetMapping("/")
    public String showList(@RequestParam(required = false) Integer pag, Model model) {
        int ultPag = empleadoService.getTotalPaginas() - 1;
        if (pag == null || pag < 0 || pag > ultPag) pag = 0;
        Integer pagSig = ultPag > pag ? pag + 1 : ultPag;
        Integer pagAnt = pag > 0 ? pag - 1 : 0;
        model.addAttribute("listaEmpleados", empleadoService.getEmpleadosPaginados(pag));
        model.addAttribute("pagSiguiente", pagSig);
        model.addAttribute("pagAnterior", pagAnt);
        model.addAttribute("pagFinal", ultPag);
        return "indexView";
    }
}