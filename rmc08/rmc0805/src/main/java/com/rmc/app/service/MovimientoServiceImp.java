package com.rmc.app.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.Exception.EmptyListMovimientoException;
import com.rmc.app.Exception.MovimientoNotFoundException;
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
        return movRepo.save(movimiento);
    }
    public List<Movimiento> obteberTodos(){
        List<Movimiento> lista = movRepo.findAll();
        if(lista.isEmpty()){
            throw new EmptyListMovimientoException();
        }
        return lista;
    }
    public List <Movimiento> obtenerPorIdCuenta(String iban){
        Cuenta cuenta = cuentaRepo.findById(iban).orElse(null);
        if (cuenta != null) {
            return movRepo.findByCuenta(cuenta);
        }
        else throw new MovimientoNotFoundException(null);
        
    }
    public LocalDateTime fecha(){
        LocalDateTime date = LocalDateTime.now();
        return date;
    }
}
