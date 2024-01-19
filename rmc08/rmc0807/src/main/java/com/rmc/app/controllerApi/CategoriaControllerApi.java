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

import com.rmc.app.domain.Categoria;
import com.rmc.app.service.CategoriaService;
import com.rmc.app.service.ProductoService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/api") 
public class CategoriaControllerApi {

    @Autowired
    public CategoriaService categoriaService;
    @Autowired
    public ProductoService productoService;

        @GetMapping({"/categoria"})
        public List<Categoria> getList(){
            List<Categoria> lista = categoriaService.obteberLista();
            return lista;
        }
        @PostMapping("/categoria")
        public ResponseEntity<?> nuevaCategoria(@Valid @RequestBody Categoria nuevaCategoria){
            Categoria categoria = categoriaService.añadir(nuevaCategoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }
        
        @PutMapping("/categoria/{id}")
        public Categoria editCategoria(@Valid @RequestBody Categoria categoria,@PathVariable long id) {
            
            categoriaService.obtenerPorId(id);//Si en el servicio no se encuentra se genera ahí la excepcion
            
            return categoriaService.editar(categoria);
        }

        @DeleteMapping("/categoria/{id}")
        public ResponseEntity<?> borrarCategoria(@PathVariable long id) {
            categoriaService.obtenerPorId(id);
             categoriaService.borrar(id);
             return ResponseEntity.noContent().build();
            
        }


    
}