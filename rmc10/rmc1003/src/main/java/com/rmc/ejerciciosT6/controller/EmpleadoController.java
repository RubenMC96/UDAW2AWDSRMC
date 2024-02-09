package com.rmc.ejerciciosT6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {

        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if(listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(listaEmpleados);
    }
    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOnElement(@PathVariable Long id) {

        Empleado empleado = empleadoService.obtenerPorId(id);
        if(empleado == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(empleado);
    }


    @PostMapping("/empleado")
    public ResponseEntity <?> newElement(@Valid @RequestBody Empleado nuevEmpleado) {
    //@Valid si no se cumple la validación devuelve BAD_REQUEST        model.addAttribute("empleadoForm", new Empleado());
        Empleado empleado = empleadoService.añadir(nuevEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id){
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.noContent().build();
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

    @PutMapping("/editar/submit")
    public String showEditSubmit(
            @Valid Empleado empleadoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoService.editar(empleadoForm);
        return "redirect:/list";
    }

    @DeleteMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return "redirect:/list";
    }

    @GetMapping("/listado1/{salario}")
    public String showListado1(@PathVariable Double salario, Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosSalarioMayor (salario);
        model.addAttribute("tituloListado", "Empleados salario mayor que" + salario.toString());
        model.addAttribute("listaEmpleados", empleados);
        return "listadosView";
    }
    @GetMapping("/listado2")
    public String showListado2(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        model.addAttribute("tituloListado", "Empleados salario mayor que la media");
        model.addAttribute("listaEmpleados", empleados);
        return "listadosView";
    }
}