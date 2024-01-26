package com.rmc.app.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.Repositories.CuentaRepository;
import com.rmc.app.Repositories.MovimientoRepository;
import com.rmc.app.domain.Cuenta;
import com.rmc.app.domain.Movimiento;

@Service
public class MovimientoServiceImp implements MovimientoService{

    @Autowired
    MovimientoRepository movRepo;
    
    @Autowired
    CuentaRepository cuentaRepo;

    public Movimiento añadir(Movimiento movimiento){
        Cuenta cuenta = cuentaRepo.findById(movimiento.getCuenta().getIban()).orElse(null);
        if(cuenta != null){
            Float importe = movimiento.getImporte();
            Float saldo = cuenta.getSaldo();

            cuenta.setSaldo(saldo + importe);
            cuentaRepo.save(cuenta);
            return movRepo.save(movimiento);
        }
        return null;
        
    }
    public List<Movimiento> obtenerTodos(){
        return movRepo.findAll();
    }
    public List <Movimiento> obtenerPorIdCuenta(String iban){
        Cuenta cuenta = cuentaRepo.findById(iban).orElse(null);
        if (cuenta != null) {
            return movRepo.findByCuenta(cuenta);
        }
        else return null;
        
    }
    public LocalDateTime fecha(){
        LocalDateTime date = LocalDateTime.now();
        return date;
    }
}
