package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rmc.app.domain.Producto;
import com.rmc.app.service.ProductoService;

import jakarta.validation.Valid;




@Controller
public class ProductoController {

    @Autowired
    public ProductoService productoService;

    @GetMapping({"/", "/list"})
    public String showList(Model model){
        model.addAttribute("listaProductos", productoService.obteberLista());
        return "indexView";
    }
    @GetMapping("/nuevo")
    public String showNuevo(Model model){
        model.addAttribute("productoForm", new Producto());
        return "FormNew";
    }
    @PostMapping("/nuevo/submit")
    public String showNuevoSubmit (
        @Valid Producto productoForm,
        BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "redirect:/nuevo";
            productoService.añadir(productoForm);
                return "redirect:/list";
    }
    @PostMapping("/editar/submit")
    public String showEditSubmit (
        @Valid Producto productoForm,
        BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "redirect:/editar/{id}";
            productoService.editar(productoForm);
                return "redirect:/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Producto producto = productoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (producto != null) {
            model.addAttribute("productoForm", producto);
            return "FormEdit";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        productoService.borrar(id);
        return "redirect:/list";
    }


    
}