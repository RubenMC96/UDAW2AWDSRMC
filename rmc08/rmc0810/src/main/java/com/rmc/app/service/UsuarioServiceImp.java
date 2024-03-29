package com.rmc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.Exception.UsuarioNotFoundException;
import com.rmc.app.Repositories.UsuarioRepository;
import com.rmc.app.domain.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService{


    @Autowired
    UsuarioRepository usuRepo;

    public Usuario añadir(Usuario usuario) {
        usuRepo.save(usuario);
        return usuario; // podría no devolver nada, o boolean, etc.
    }
    public List<Usuario> obteberLista() {
        return usuRepo.findAll();
    }
    public Usuario obtenerPorId(long id) {
        
        Usuario usuario = usuRepo.findById(id).orElse(null);// debería lanzar excepción si no encontrado
        if(usuario != null){
        throw new UsuarioNotFoundException(id);
        }
        return null;
         
    }
    public Usuario editar(Usuario usuario) {
          
        return usuRepo.save(usuario);
    }
    public void borrar(Long id) {
        Usuario usuario = usuRepo.findById(id).orElse(null);
        if(usuario != null){
            throw new UsuarioNotFoundException(id);
        }
        else usuRepo.delete(usuario);
        
    }

    public Usuario obtenerPorUsuario(Long id){
        Usuario usu=usuRepo.findById(id).orElse(null);
        if(usu == null) throw new UsuarioNotFoundException(id);
        
        else
        return usu;
    }

    public Usuario obtenerPorNombre(String nombre){

        return usuRepo.findByNombre(nombre);
    }
}
