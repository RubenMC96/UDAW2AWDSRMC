package com.rmc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.Exception.CuentaNotFoundException;
import com.rmc.app.Exception.EmptyListCuentaException;
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
        List<Cuenta> lista = cuentaRepo.findAll();
        if(lista.isEmpty()){
            throw new EmptyListCuentaException();
        }
        return lista;
    }
    public List <Cuenta> obtenerCuentaMaxSaldo(){
        return cuentaRepo.findTopByOrderBySaldo();
    }
    public Cuenta obtenerPorId(String iban){
        Cuenta cuenta = cuentaRepo.findById(iban).orElse(null);
        if(cuenta == null){
            throw new CuentaNotFoundException(null);
        }
        return cuenta;
    }
}
