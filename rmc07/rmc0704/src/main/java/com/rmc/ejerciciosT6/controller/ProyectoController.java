package com.rmc.ejerciciosT6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.ejerciciosT6.domain.Proyecto;
import com.rmc.ejerciciosT6.service.ProyectoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {
    
    @Autowired
    public ProyectoService proyectoService;

    

    @GetMapping({ "/", "/list" })
    public String showListDTO(Model model) {
        model.addAttribute("listaproyectos", proyectoService.obtenerTodos());
        return "CrudProyecto/proyectoView";
    }

    @GetMapping("/nuevo")
    public String showNewDTO(Model model) {
        // el commandobject del formulario es una instancia de empleado vacia
        model.addAttribute("proyectoForm", new Proyecto());
        return "CrudProyecto/proyectoNew";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmitDTO(
            @Valid Proyecto proyectoView,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/proyecto/nuevo";
        proyectoService.añadir(proyectoView);
        return "redirect:/proyecto/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditFormDTO(@PathVariable long id, Model model) {
        Proyecto proyecto = proyectoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (proyecto != null) {
            model.addAttribute("proyectoForm", proyecto);
            return "CrudProyecto/proyectoEdit";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/proyecto/list";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmitDTO(
            @Valid Proyecto proyectoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            proyectoService.editar(proyectoForm);
        return "redirect:/proyecto/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDeleteDTO(@PathVariable long id) {
        proyectoService.borrar(id);
        return "redirect:/proyecto/list";
    }
}