package com.rmc.app.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.app.domain.Contacto;
import com.rmc.app.domain.Usuario;

public interface ContactoRepository extends JpaRepository<Contacto, Long>{

   public Contacto findByUsuario(Usuario usuario);
} 
