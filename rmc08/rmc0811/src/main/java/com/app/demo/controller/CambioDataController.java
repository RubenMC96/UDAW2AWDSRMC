package com.app.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.service.CambioService;

import reactor.core.publisher.Mono;



@Controller
public class CambioDataController {
    
    @Autowired
    CambioService cambioService;

    @GetMapping("/")
    public Mono<ModelAndView> showForm(Model model) {
        List<String> monedas = Arrays.asList("Euro", "Libra Esterlina", "Yen", "Dolar");
        model.addAttribute("monedas", monedas);
        return Mono.just(new ModelAndView("indexView"));
    }

    @PostMapping("/convertir")
    @ResponseStatus(HttpStatus.OK)
    public String convertirMoneda(@RequestParam("importe") Float importe,
                                    @RequestParam("origen") String origen,
                                    @RequestParam("destino") String destino,
                                    Model model) {
        /*Creamos un mapa en el que indicamos el codigo
        que le corresponde a cada moneda
        */

        HashMap<String, String> codMoneda = new HashMap();

        codMoneda.put("Euro","EUR");
        codMoneda.put("libra esterlina","GBP");
        codMoneda.put("Libra Esterlina","JPY");
        codMoneda.put("Dolar","USD");
        //Con esto podemos asignar el codigo de moneda para hacer la conversion

        String codOrigen = codMoneda.get(origen);
        String codDestino = codMoneda.get(destino);
        Float cambio = cambioService.getExchangeRate(codOrigen, codDestino).block();
        Float resultado = importe * cambio;
        model.addAttribute("resultado", resultado);
        
        return "resultadoView";
    }
    
    


}
