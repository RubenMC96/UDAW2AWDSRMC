package com.rmc.app.controllerApi;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Valoracion;
import com.rmc.app.service.ProductoService;
import com.rmc.app.service.ValoracionService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/api") 
public class ValoracionControllerApi {

    @Autowired
    public ValoracionService valoracionService;
    @Autowired
    public ProductoService productoService;

        @GetMapping("/valoracion/{id}")
        public List<Valoracion> getValoracion(@PathVariable long id){
            List<Valoracion> lista = valoracionService.obtenerPorProducto(id);
            return lista;
        }

        @GetMapping("/valoracion/{idUsuario}")
        public List<Valoracion> showUsuario(@PathVariable long id, Model model){
            List<Valoracion> lista = valoracionService.obtenerPorUsuario(id);
            return lista;
        }
        @PostMapping("/valoracion")
        public ResponseEntity<?> showNuevo(@Valid @RequestBody Valoracion nuevaValoracion ){
            Valoracion valoracion = valoracionService.añadir(nuevaValoracion);
            return ResponseEntity.status(HttpStatus.CREATED).body(valoracion);
        }
        
        @PutMapping("/valoracion/{id}")
        public Valoracion showEditForm(@Valid @RequestBody Valoracion editValoracion,@PathVariable long id) {
            valoracionService.obtenerPorId(id);
            
            return valoracionService.editar(editValoracion);
        }

        @DeleteMapping("/valoracion/{id}")
        public ResponseEntity<?> showDelete(@PathVariable long id) {
            valoracionService.obtenerPorId(id);
            valoracionService.borrar(id);
            return ResponseEntity.noContent().build();
            
        }


    
}