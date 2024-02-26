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

import com.rmc.app.domain.Producto;
import com.rmc.app.service.CategoriaService;
import com.rmc.app.service.ProductoService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/api")
public class ProductoControllerApi {

    @Autowired
    public ProductoService productoService;
    @Autowired
    public CategoriaService categoriaService;


    @GetMapping({"/producto"})
    public ResponseEntity<?> getList(){
        List<Producto> lista = productoService.obteberLista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
    @GetMapping("/producto/{idCat}")
        public ResponseEntity<?> productoPorCategoria(@PathVariable Long idCat) {
        
        List<Producto> lista = productoService.findByCategory(idCat);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
    @PostMapping("/producto")
    public ResponseEntity<?> nuevoProducto(@Valid @RequestBody Producto nuevoproducto){
        Producto producto = productoService.añadir(nuevoproducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> editProducto(@Valid @RequestBody Producto editProducto, @PathVariable long id) {
        Producto producto = productoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        return ResponseEntity.status(HttpStatus.OK).body(producto);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable long id) {
        productoService.obtenerPorId(id);
        productoService.borrar(id);
        return ResponseEntity.noContent().build();
    }

    
}