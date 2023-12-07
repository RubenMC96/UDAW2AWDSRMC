package com.rmc.ejerciciosT6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.service.CategoriaService;
import com.rmc.ejerciciosT6.service.DepartamentoService;
import com.rmc.ejerciciosT6.service.EmpleadoService;

import jakarta.validation.Valid;

@Controller
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;
    
    @Autowired
    public DepartamentoService departamentoService;

    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", 0);
        return "indexView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        // el commandobject del formulario es una instancia de empleado vacia
        model.addAttribute("empleadoForm", new Empleado());
        model.addAttribute("departamento", departamentoService.obtenerTodos());
        model.addAttribute("categoria", categoriaService.obtenerTodos());
        return "FormNew";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(
            @Valid Empleado empleadoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/nuevo";
        empleadoService.añadir(empleadoForm);
        return "redirect:/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (empleado != null) {
            model.addAttribute("empleadoForm", empleado);
            return "FormEdit";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/list";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmit(
            @Valid Empleado empleadoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoService.editar(empleadoForm);
        return "redirect:/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return "redirect:/list";
    }

    @GetMapping("/porDepto/{dep}")
    public String showPorDepartamento(@PathVariable long dep, Model model){
    
        model.addAttribute("listaEmpleados", empleadoService.obtenerPorDto(dep));
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", dep);
        return "indexView";
    }

    
}