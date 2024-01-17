package com.rmc.ejerciciosT6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.ejerciciosT6.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//Metodos Nativos o interfaces repository Pag 80 Cuadro

 
/* Metodos derivados
 Podemos generar nuestras propias funciones siguendo una syntaxis especial
*/
    Usuario findByNombre (String nombre);
}

