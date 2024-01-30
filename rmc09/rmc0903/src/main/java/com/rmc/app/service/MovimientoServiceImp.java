package com.rmc.app.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public Movimiento añadir(Movimiento movimiento) throws RuntimeException{
        Cuenta cuenta = cuentaRepo.findById(movimiento.getCuenta().getIban()).orElse(null);
        if(cuenta == null){

            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserRol = authentication.getAuthorities().toString();
        if ((currentUserRol.equals("[ROLE_ADMIN]")) || (currentUserRol.equals("[ROLE_TITULAR]"))) {
            
            Float importe = movimiento.getImporte();
            Float saldo = cuenta.getSaldo();

            cuenta.setSaldo(saldo + importe);
            cuentaRepo.save(cuenta);
            return movRepo.save(movimiento);
                    
        }
        else{
            Float importe = movimiento.getImporte();
            Float saldo = cuenta.getSaldo();
                       
            if(importe > 0){
                cuenta.setSaldo(saldo + importe);
                cuentaRepo.save(cuenta);
                return movRepo.save(movimiento);
            }
            else{
                throw new RuntimeException("Solo puedes realizar ingresos");
            }
                        
        }

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
