package com.rmc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.Repositories.CuentaRepository;
import com.rmc.app.domain.Cuenta;

@Service
public class CuentaServiceImp implements CuentaService{


    @Autowired
    CuentaRepository cuentaRepo;

    public Cuenta añadir(Cuenta categoria){
        return cuentaRepo.save(categoria);
    }
    public void borrar(String iban){
        Cuenta cuenta = cuentaRepo.findById(iban).orElse(null);
        if (cuenta != null) {
            cuentaRepo.delete(cuenta);
        }
    }
    public List<Cuenta> obtenerTodos(){
        return cuentaRepo.findAll();
    }
    public List <Cuenta> obtenerCuentaMaxSaldo(){
        return cuentaRepo.findTopByOrderBySaldo();
    }
    
}
