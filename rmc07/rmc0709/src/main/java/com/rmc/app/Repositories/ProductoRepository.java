package com.rmc.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.app.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    
} 
