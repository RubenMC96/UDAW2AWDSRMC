package com.rmc.app.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.app.domain.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String>{
} 
