package com.rmc.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.app.domain.Cuenta;
import com.rmc.app.domain.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

       public List <Movimiento> findByCuenta (Cuenta cuenta); 

} 
