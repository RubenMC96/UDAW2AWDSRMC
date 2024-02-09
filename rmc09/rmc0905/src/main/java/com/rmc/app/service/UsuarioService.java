package com.rmc.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Usuario;

@Service
public interface UsuarioService {
<<<<<<< HEAD
    
    public Usuario añadir(Usuario usuario);
    public List<Usuario> obteberLista();
    public Usuario obtenerPorId(long id);
    public Usuario editar(Usuario usuario);
    public void borrar(Long id);
    public Usuario obtenerPorUsuario(Long id);
    public Usuario obtenerPorNombre(String nombre);

    
=======

    public Usuario añadir(Usuario usuario);

    public List<Usuario> obteberLista();

    public Usuario obtenerPorId(long id);

    public Usuario editar(Usuario usuario);

    public void borrar(Long id);

    public Usuario obtenerPorUsuario(Long id);

    public Usuario obtenerPorNombre(String nombre);

    public Usuario obtenerUsuarioConectado();

>>>>>>> 545afc3b02556fc70d674011db0edcce3801c0a6
}
