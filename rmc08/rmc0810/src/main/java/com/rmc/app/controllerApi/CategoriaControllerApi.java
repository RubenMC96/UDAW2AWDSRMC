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

import com.rmc.app.domain.Categoria;
import com.rmc.app.service.CategoriaService;
import com.rmc.app.service.ProductoService;

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
public class CategoriaControllerApi {

    @Autowired
    public CategoriaService categoriaService;
    @Autowired
    public ProductoService productoService;

    @Operation(summary = "Lista categorias",
        description = "Develve una lista con todas las categorias.",
        tags = {"get"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Categoria.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })

        @GetMapping({"/categoria"})
        public List<Categoria> getList(){
            List<Categoria> lista = categoriaService.obteberLista();
            return lista;
        }


    @Operation(summary = "Nueva categoria",
        description = "Crear una nueva categoria.",
        tags = {"post"})

        
    @ApiResponses({
        @ApiResponse(responseCode = "201",
        content = {@Content(schema = @Schema(implementation = Categoria.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })
    
        @PostMapping("/categoria")
        public ResponseEntity<?> nuevaCategoria(@Valid @RequestBody Categoria nuevaCategoria){
            Categoria categoria = categoriaService.añadir(nuevaCategoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }

    @Operation(summary = "Obtener una categoria",
            description = "Obtener una categoria por su ID.",
            tags = {"put"})

        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Categoria.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })

        
        @PutMapping("/categoria/{id}")
        public Categoria editCategoria(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@Valid @RequestBody Categoria categoria,@PathVariable long id) {
            
            categoriaService.obtenerPorId(id);//Si en el servicio no se encuentra se genera ahí la excepcion
            
            return categoriaService.editar(categoria);
        }

         @Operation(summary = "Obtener una categoria",
            description = "Obtener una categoria por su ID.",
            tags = {"delete"})

        
    @ApiResponses({
        @ApiResponse(responseCode = "204",
        content = {@Content(schema = @Schema(implementation = Categoria.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })


        @DeleteMapping("/categoria/{id}")
        public ResponseEntity<?> borrarCategoria(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable long id) {
            categoriaService.obtenerPorId(id);
             categoriaService.borrar(id);
             return ResponseEntity.noContent().build();
            
        }


    
}