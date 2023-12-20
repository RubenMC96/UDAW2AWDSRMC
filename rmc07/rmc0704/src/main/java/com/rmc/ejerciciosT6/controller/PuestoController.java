package com.rmc.ejerciciosT6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Proyecto;
import com.rmc.ejerciciosT6.service.EmpleadoService;
import com.rmc.ejerciciosT6.service.ProyectoService;
import com.rmc.ejerciciosT6.service.PuestoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/puesto")
public class PuestoController {
    
    @Autowired
    public PuestoService PuestoService;

    @Autowired
    public EmpleadoService empleadoService;


    @Autowired

    public ProyectoService proyectoService;

    @Autowired

    public PuestoService puestoService;
    


    @GetMapping("/emp/{id}")
    public String showProyectByEmpl(@PathVariable long id, Model model){


        Empleado e = empleadoService.obtenerPorId(id);
        model.addAttribute("listaPuesto",
        puestoService.obtenerPorEmpleado(e));

        model.addAttribute("empleado", empleadoService.obtenerPorId(id));

        return "puesto/empListView";


    }

    
@GetMapping("/pro/{id}") // lista de empleados de un proyecto
public String showEmplbyProyect(@PathVariable long id, Model model) {
Proyecto p = proyectoService.obtenerPorId(id);
model.addAttribute("listaEmpleadoProyecto",puestoService.obtenerPorProyecto(p));
model.addAttribute("proyecto", proyectoService.obtenerPorId(id));
return "puesto/proListView";
}


@GetMapping("/delete/{id}")
public String showDeleteEmpl(@PathVariable long id) {
puestoService.borrar(puestoService.obtenerPorId(id));
return "redirect:/";
}
    

@GetMapping("/new")
public String showNewProjectEmpl(Model model) {
model.addAttribute("empleadoProyectoForm", new EmpleadoProyecto());
model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
return "empleadoProyecto/empProyNewFormView";
}
@PostMapping("/new/submit")
public String showNewProjectEmplSubmit(@Valid EmpleadoProyecto empleadoProyectoForm,
BindingResult bindingResult) {
if (!bindingResult.hasErrors())
empleadoProyectoService.añadir(empleadoProyectoForm);
return "redirect:/";
}
   
}