package com.rmc.ejerciciosT6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.ejerciciosT6.domain.Departamento;
import com.rmc.ejerciciosT6.service.DepartamentoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
    
    @Autowired
    public DepartamentoService departamentoService;

    

    @GetMapping({ "/", "/list" })
    public String showListDTO(Model model) {
        model.addAttribute("listaEmpleados", departamentoService.obtenerTodos());
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", 0);
        return "departementoView";
    }

    @GetMapping("/nuevo")
    public String showNewDTO(Model model) {
        // el commandobject del formulario es una instancia de empleado vacia
        model.addAttribute("departamentoForm", new Departamento());
        return "FormNewDTO";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmitDTO(
            @Valid Departamento departementoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/departamento/nuevo";
        departamentoService.añadir(departementoForm);
        return "redirect:/departamento/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditFormDTO(@PathVariable long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (departamento != null) {
            model.addAttribute("departementoForm", departamento);
            return "FormEditDTO";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/departamento/list";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmitDTO(
            @Valid Departamento departamentoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            departamentoService.editar(departamentoForm);
        return "redirect:/departamento/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDeleteDTO(@PathVariable long id) {
        departamentoService.borrar(id);
        return "redirect:/departamento/list";
    }
}