package com.rmc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.Repositories.ContactoRepository;
import com.rmc.app.domain.Contacto;

@Service
public class ContactoServiceImp implements ContactoService{


    @Autowired
    ContactoRepository contRepo;

    public Contacto añadir(Contacto contacto) {
        contRepo.save(contacto);
        return contacto; // podría no devolver nada, o boolean, etc.
    }
}
