package com.rmc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
<<<<<<< HEAD
=======
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
>>>>>>> 545afc3b02556fc70d674011db0edcce3801c0a6
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmc.app.Repositories.UsuarioRepository;
import com.rmc.app.domain.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Usuario añadir(Usuario usuario) {
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        try {
            return usuRepo.save(usuario);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> obteberLista() {
        return usuRepo.findAll();
    }

    public Usuario obtenerPorId(long id) {

        Usuario usuario = usuRepo.findById(id).orElse(null);// debería lanzar excepción si no encontrado
        if (usuario != null) {
            return usuario;
        }
        return null;

    }

    public Usuario editar(Usuario usuario) {
        String passCrypted = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passCrypted);
        try {
            return usuRepo.save(usuario);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void borrar(Long id) {
        Usuario usuario = usuRepo.findById(id).orElse(null);
        if (usuario != null) {
            usuRepo.delete(usuario);
        }

    }

    public Usuario obtenerPorUsuario(Long id) {
        Usuario usu = usuRepo.findById(id).orElse(null);
        if (usu == null)
            return null;

        return usu;
    }

    public Usuario obtenerPorNombre(String nombre) {

        return usuRepo.findByNombre(nombre);
    }
<<<<<<< HEAD
=======

    public Usuario obtenerUsuarioConectado() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String nombreUsuarioConectado = authentication.getName();

            return usuRepo.findByNombre(nombreUsuarioConectado);
        }
        return null;
    }
>>>>>>> 545afc3b02556fc70d674011db0edcce3801c0a6
}
