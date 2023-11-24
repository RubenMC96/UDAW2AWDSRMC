package com.rmc.ejerciciosT6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rmc.ejerciciosT6.domain.Departamento;
import com.rmc.ejerciciosT6.service.DepartamentoService;

import jakarta.validation.Valid;

@Controller
public class DepartamentoController {
    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        return "departementoView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        // el commandobject del formulario es una instancia de empleado vacia
        model.addAttribute("departamentoForm", new Departamento());
        return "departementoFormNew";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(
            @Valid Departamento departementoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/nuevo";
        departamentoService.añadir(departementoForm);
        return "redirect:/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        // el commandobject del formulario es el empleado con el id solicitado
        if (departamento != null) {
            model.addAttribute("departementoForm", departamento);
            return "departamentoFormEdit";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/list";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmit(
            @Valid Departamento departamentoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            departamentoService.editar(departamentoForm);
        return "redirect:/list";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        departamentoService.borrar(id);
        return "redirect:/list";
    }
}