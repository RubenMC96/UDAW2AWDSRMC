package com.rmc.app.controllerApi;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmc.app.domain.Usuario;
import com.rmc.app.service.ProductoService;
import com.rmc.app.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;




@Tag(name = "Nombre de la clase", description = "Descripción de la clase")
@RestController
@RequestMapping("/api") 
public class UsuarioControllerApi {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProductoService productoService;

    @Operation(summary = "Lista usuarios",
        description = "Develve una lista con todos los usuarios.",
        tags = {"get"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Usuario.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })

        @GetMapping({"/usuario"})
        public List<Usuario> getList(){
            List<Usuario> lista = usuarioService.obteberLista();
            return lista;
        }

    @Operation(summary = "Nuevo usuario",
        description = "Crear un muevo usuario.",
        tags = {"post"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "201",
        content = {@Content(schema = @Schema(implementation =Usuario.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })
        @PostMapping("/usuario")
        public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody Usuario nuevoUsuario){
            Usuario usuario = usuarioService.añadir(nuevoUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }

        @Operation(summary = "Editar usuario",
        description = "Editar un muevo usuario por su ID.",
        tags = {"put"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation =Usuario.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })
        @PutMapping("/usuario/{id}")
        public Usuario editUsuario(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@Valid @RequestBody Usuario editUsuario, @PathVariable long id) {
            usuarioService.obtenerPorId(id);
        
            return usuarioService.editar(editUsuario);
        }

         @Operation(summary = "Borrar usuario",
            description = "Borrar un usuario por su ID.",
            tags = {"delete"})
        
        @ApiResponses({
            @ApiResponse(responseCode = "204",
            content = {@Content(schema = @Schema(implementation =Usuario.class),
            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
            content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
            content = { @Content(schema = @Schema()) }) 
        })

        @DeleteMapping("/usuario/{id}")
        public ResponseEntity<?> deleteUsuario(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable long id) {
            usuarioService.obtenerPorId(id);
            usuarioService.borrar(id);
            return ResponseEntity.noContent().build();
            
        }


    
}