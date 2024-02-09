package com.rmc.app.service;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Contacto;

@Service
public interface ContactoService {
    
    public Contacto añadir(Contacto contacto);   
}
