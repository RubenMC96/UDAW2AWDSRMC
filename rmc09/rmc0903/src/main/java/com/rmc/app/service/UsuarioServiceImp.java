package com.rmc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmc.app.Repositories.UsuarioRepository;
import com.rmc.app.domain.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    public Usuario añadir(Usuario usuario){
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        try {
        return usuarioRepository.save(usuario);

}
catch (DataIntegrityViolationException e) {e.printStackTrace(); return null;}
    }

    public Usuario editar(Usuario usuario) {
    String passCrypted = passwordEncoder.encode(usuario.getPassword());
    usuario.setPassword(passCrypted);
    try { return usuarioRepository.save(usuario); }
    catch (DataIntegrityViolationException e) {e.printStackTrace(); return null;} }

    public void borrar(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario != null){
            usuarioRepository.delete(usuario);
        }
        
    }
    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    public Usuario obtenerPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario != null){
           return usuario;
        }
        else{
            return null;
        }
    }
    
}
