package com.rmc.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.app.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

   public List <Categoria> findByCategoria (Categoria categoria); 
} 
