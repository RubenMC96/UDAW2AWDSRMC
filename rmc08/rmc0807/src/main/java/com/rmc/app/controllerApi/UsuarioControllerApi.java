package com.rmc.app.controllerApi;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Usuario;
import com.rmc.app.service.ProductoService;
import com.rmc.app.service.UsuarioService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/api") 
public class UsuarioControllerApi {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProductoService productoService;

        @GetMapping({"/usuario"})
        public List<Usuario> getList(){
            List<Usuario> lista = usuarioService.obteberLista();
            return lista;
        }
        @PostMapping("/usuario")
        public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody Usuario nuevoUsuario){
            Usuario usuario = usuarioService.añadir(nuevoUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }

        @PutMapping("/usuario/{id}")
        public Usuario editUsuario(@Valid @RequestBody Usuario editUsuario, @PathVariable long id) {
            usuarioService.obtenerPorId(id);
        
            return usuarioService.editar(editUsuario);
        }

        @DeleteMapping("/usuario/{id}")
        public ResponseEntity<?> deleteUsuario(@PathVariable long id) {
            usuarioService.obtenerPorId(id);
            usuarioService.borrar(id);
            return ResponseEntity.noContent().build();
            
        }


    
}