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

import com.rmc.app.domain.Producto;
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
public class ProductoControllerApi {

    @Autowired
    public ProductoService productoService;
    @Autowired
    public CategoriaService categoriaService;


    @Operation(summary = "Lista productos",
        description = "Develve una lista con todos los productos.",
        tags = {"get"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Producto.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })

    @GetMapping({"/producto"})
    public List<Producto> getList(){
        List<Producto> lista = productoService.obteberLista();
        return lista;
    }

    @Operation(summary = "Producto por ID",
        description = "Develve un producto por su ID.",
        tags = {"get"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Producto.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })


    @GetMapping("/producto/{idCat}")
        public List<Producto> productoPorCategoria(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable Long idCat) {
        
        List<Producto> lista = productoService.findByCategory(idCat);
        return lista;
    }

    @Operation(summary = "Nuevo producto",
        description = "Crear un producto nuevo.",
        tags = {"post"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "201",
        content = {@Content(schema = @Schema(implementation = Producto.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })


    @PostMapping("/producto")
    public ResponseEntity<?> nuevoProducto(@Valid @RequestBody Producto nuevoproducto){
        Producto producto = productoService.añadir(nuevoproducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @Operation(summary = "Editar producto",
        description = "Editar un producto por su ID.",
        tags = {"put"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "200",
        content = {@Content(schema = @Schema(implementation = Producto.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })

    @PutMapping("/producto/{id}")
    public Producto editProducto(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@Valid @RequestBody Producto editProducto, @PathVariable long id) {
        Producto producto = productoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        return productoService.editar(producto);
    }

     @Operation(summary = "Borrar producto",
        description = "Borrar un producto por su ID.",
        tags = {"delete"})
        
    @ApiResponses({
        @ApiResponse(responseCode = "204",
        content = {@Content(schema = @Schema(implementation = Producto.class),
        mediaType = "application/json") }),
        @ApiResponse(responseCode = "404",
        content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500",
        content = { @Content(schema = @Schema()) }) 
    })


    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> deleteProducto(@Parameter(name = "id",description = "identific. único del producto", example = "1", required = true)@PathVariable long id) {
        productoService.obtenerPorId(id);
        productoService.borrar(id);
        return ResponseEntity.noContent().build();
    }


    
}