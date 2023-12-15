package com.rmc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return usuario;
        }
        return null;
         
    }
    public Usuario editar(Usuario usuario) {
          
        return usuRepo.save(usuario);
    }
    public void borrar(Long id) {
        Usuario usuario = usuRepo.findById(id).orElse(null);
        if(usuario != null){
            usuRepo.delete(usuario);
        }
        
    }

    public List<Usuario> obtenerPorUsuario(Long id){
        Usuario usu=usuRepo.findById(id).orElse(null);
        if(usu == null) return null;
        
        return usuRepo.findByUsuario(usu);
    }

    public Usuario obtenerPorNombre(String nombre){

        return usuRepo.findByNombre(nombre);
    }
}
