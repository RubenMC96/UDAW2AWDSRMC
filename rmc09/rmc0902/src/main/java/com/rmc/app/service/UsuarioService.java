package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Usuario;

@Service
public interface UsuarioService {
    
    public Usuario añadir(Usuario usuario);
    public void borrar(String id);
    public List<Usuario> obtenerTodos();
    public Usuario obtenerPorId(String id);
    
}
