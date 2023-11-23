package com.rmc.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Cuenta;
import com.rmc.app.service.CuentaService;
import com.rmc.app.service.MovimientoService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/cuenta") 
public class CuentaController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;

        @GetMapping({"/", "/list"})
        public String showList(Model model){
            model.addAttribute("listaCuentas", cuentaService.obteberLista());
            return "CuentaView/ListCuentaView";
        }
        @GetMapping("/nuevo")
        public String showNuevo(Model model){
            model.addAttribute("cuentaForm", new Cuenta());
            return "CuentaView/CuentaFormNew";
        }
        @PostMapping("/nuevo/submit")
        public String showNuevoSubmit (
            @Valid Cuenta cuentaForm,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/cuenta/nuevo";
                cuentaService.añadir(cuentaForm);
                    return "redirect:/cuenta/list";
        }
        @PostMapping("/editar/submit")
        public String showEditSubmit (
            @Valid Cuenta cuentaForm,
            BindingResult bindingResult){
                if(bindingResult.hasErrors())
                    return "redirect:/cuenta/editar/{IBAN}";
                cuentaService.editar(cuentaForm);
                    return "redirect:/cuenta/list";
        }

        @GetMapping("/editar/{IBAN}")
        public String showEditForm(@PathVariable String IBAN, Model model) {
            Cuenta cuenta = cuentaService.obtenerPorIBAN(IBAN);
            // el commandobject del formulario es el empleado con el id solicitado
            if (cuenta != null) {
                model.addAttribute("cuentaForm", cuenta);
                return "CuentaView/CuentaFormEdit";
            }
            // si no lo encuentra vuelve a la página de inicio.
            return "redirect:/cuenta/list";
        }
        @GetMapping("/borrar/{IBAN}")
        public String showBorrar(@PathVariable String IBAN) {
            Cuenta cuenta = cuentaService.obtenerPorIBAN(IBAN);
            // el commandobject del formulario es el empleado con el id solicitado
            if (cuenta != null) {
                cuentaService.borrar(IBAN);
                return "redirect:/cuenta/list";
            }
            // si no lo encuentra vuelve a la página de inicio.
            return "redirect:/cuenta/list";
        }

       


    
}