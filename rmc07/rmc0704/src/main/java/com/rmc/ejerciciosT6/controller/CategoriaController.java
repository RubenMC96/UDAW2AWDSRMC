package com.rmc.ejerciciosT6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.ejerciciosT6.domain.Categoria;
import com.rmc.ejerciciosT6.service.CategoriaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    public CategoriaService categoriaService;

    

    @GetMapping({ "/", "/list" })
    public String showListDTO(Model model) {
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "CrudCategoria/categoriaView";
    }

    @GetMapping("/nuevo")
    public String showNewDTO(Model model) {
        // el commandobject del formulario es una instancia de empleado vacia
        model.addAttribute("categoriaForm", new Categoria());
        return "CrudCategoria/categoriaNew";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmitDTO(
            @Valid Categoria departementoView,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/categoria/nuevo";
        categoriaService.añadir(departementoView);
        return "redirect:/categoria/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditFormDTO(@PathVariable long id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (categoria != null) {
            model.addAttribute("categoriaForm", categoria);
            return "CrudCategoria/categoriaEdit";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/categoria/list";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmitDTO(
            @Valid Categoria categoriaForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            categoriaService.editar(categoriaForm);
        return "redirect:/categoria/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDeleteDTO(@PathVariable long id) {
        categoriaService.borrar(id);
        return "redirect:/categoria/list";
    }
}