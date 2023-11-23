package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Movimiento;
import com.rmc.app.domain.Cuenta;
import com.rmc.app.service.CategoriaService;
import com.rmc.app.service.ProductoService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    public ProductoService productoService;
    @Autowired
    public CategoriaService categoriaService;


    @GetMapping({"/", "/list"})
    public String showList(Model model){
        model.addAttribute("listaProductos", productoService.obteberLista());
        model.addAttribute("listaCategorias", categoriaService.obteberLista());
        model.addAttribute("categoriaSeleccionada", new Movimiento(0L,"Todas"));
        return "ProductosView/ListProducView";
    }
    @GetMapping("/list/{idCat}")
        public String showListInCategory(@PathVariable Long idCat, Model model) {
        if(idCat == 0){
            return "redirect:/producto/";
        }   
        model.addAttribute("listaProductos", productoService.findByCategory(idCat));
        model.addAttribute("listaCategorias", categoriaService.obteberLista());
        model.addAttribute("categoriaSeleccionada", categoriaService.obtenerPorId(idCat));
        return "ProductosView/ListProducView";
    }
    @GetMapping("/nuevo")
    public String showNuevo(Model model){
        model.addAttribute("productoForm", new Cuenta());
        model.addAttribute("listaCategorias", categoriaService.obteberLista());
        return "ProductosView/FormNew";
    }
    @PostMapping("/nuevo/submit")
    public String showNuevoSubmit (
        @Valid Cuenta productoForm,
        BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "redirect:/producto/nuevo";
            productoService.añadir(productoForm);
                return "redirect:/producto/list";
    }
    @PostMapping("/editar/submit")
    public String showEditSubmit (
        @Valid Cuenta productoForm,
        BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "redirect:/producto/editar/{id}";
            productoService.editar(productoForm);
                return "redirect:/producto/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Cuenta producto = productoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (producto != null) {
            model.addAttribute("productoForm", producto);
            return "ProductosView/FormEdit";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/producto/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        if( productoService.findByCategory(id).size() == 0){
            productoService.borrar(id);
        }
        return "redirect:/producto/list";
    }


    
}