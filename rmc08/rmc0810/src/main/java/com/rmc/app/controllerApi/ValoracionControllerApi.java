package com.rmc.app.controllerApi;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmc.app.domain.Valoracion;
import com.rmc.app.service.ProductoService;
import com.rmc.app.service.ValoracionService;

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
public class ValoracionControllerApi {

    @Autowired
    public ValoracionService valoracionService;
    @Autowired
    public ProductoService productoService;

    @Operation(summary = "Valoraciones de productos",
        description = "Develve una lista con las valoraciones de un producto .",
        tags = {"get"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Valoracion.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })


        @GetMapping("/valoracion/{id}")
        public List<Valoracion> getValoracion(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable long id){
            List<Valoracion> lista = valoracionService.obtenerPorProducto(id);
            return lista;
        }

        @Operation(summary = "Valoraciones de usuarios",
        description = "Develve una lista con las valoraciones de un usuario .",
        tags = {"get"})
        
        @ApiResponses({
            @ApiResponse(responseCode = "200",
            content = {@Content(schema = @Schema(implementation = Valoracion.class),
            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
            content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
            content = { @Content(schema = @Schema()) }) 
        })

        @GetMapping("/valoracion/{idUsuario}")
        public List<Valoracion> showUsuario(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable long id, Model model){
            List<Valoracion> lista = valoracionService.obtenerPorUsuario(id);
            return lista;
        }

        @Operation(summary = "Nueva valoracion",
        description = "Crear una nueva valoracion.",
        tags = {"post"})
        
        @ApiResponses({
            @ApiResponse(responseCode = "201",
            content = {@Content(schema = @Schema(implementation = Valoracion.class),
            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
            content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
            content = { @Content(schema = @Schema()) }) 
        })
        @PostMapping("/valoracion")
        public ResponseEntity<?> showNuevo(@Valid @RequestBody Valoracion nuevaValoracion ){
            Valoracion valoracion = valoracionService.añadir(nuevaValoracion);
            return ResponseEntity.status(HttpStatus.CREATED).body(valoracion);
        }

        @Operation(summary = "Editar valoracion",
        description = "Editar una valoracion por su ID.",
        tags = {"put"})
        
        @ApiResponses({
            @ApiResponse(responseCode = "200",
            content = {@Content(schema = @Schema(implementation = Valoracion.class),
            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
            content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
            content = { @Content(schema = @Schema()) }) 
        })
        
        @PutMapping("/valoracion/{id}")
        public Valoracion showEditForm(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@Valid @RequestBody Valoracion editValoracion,@PathVariable long id) {
            valoracionService.obtenerPorId(id);
            
            return valoracionService.editar(editValoracion);
        }

        @Operation(summary = "Borrar valoracion",
        description = "Borrar una valoracion por su ID.",
        tags = {"delete"})
        
        @ApiResponses({
            @ApiResponse(responseCode = "204",
            content = {@Content(schema = @Schema(implementation = Valoracion.class),
            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
            content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
            content = { @Content(schema = @Schema()) }) 
        })

        @DeleteMapping("/valoracion/{id}")
        public ResponseEntity<?> showDelete(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable long id) {
            valoracionService.obtenerPorId(id);
            valoracionService.borrar(id);
            return ResponseEntity.noContent().build();
            
        }


    
}