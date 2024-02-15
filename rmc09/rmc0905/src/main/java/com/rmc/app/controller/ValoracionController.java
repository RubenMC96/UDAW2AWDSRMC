package com.rmc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmc.app.domain.Producto;
import com.rmc.app.domain.Rol;
import com.rmc.app.domain.Usuario;
import com.rmc.app.domain.Valoracion;
import com.rmc.app.service.ProductoService;
import com.rmc.app.service.UsuarioService;
import com.rmc.app.service.ValoracionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valoracion")
public class ValoracionController {

    @Autowired
    public ValoracionService valoracionService;
    @Autowired
    public ProductoService productoService;
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({ "/producto/{idProd}" })
    public String showProducto(@PathVariable long idProd, Model model) {
        Producto producto = productoService.obtenerPorId(idProd);
        model.addAttribute("listaValoracion", valoracionService.obtenerPorProducto(idProd));
        model.addAttribute("producto", producto);
        return "valoracionView/ListValView";
    }

    @GetMapping("/usuario/{idUsuario}")
    public String showUsuario(@PathVariable long idUsuario, Model model) {
        model.addAttribute("listaValoracion", valoracionService.obtenerPorUsuario(idUsuario));
        return "valoracionView/ListValView";
    }

    @GetMapping("/nuevo/{idProd}")
    public String showNuevo(@PathVariable long idProd, Model model) {
        Producto producto = productoService.obtenerPorId(idProd);
        Usuario usuario = usuarioService.obtenerUsuarioConectado();
        model.addAttribute("valoracionForm", new Valoracion(0L, null, null, usuario, producto));
        model.addAttribute("producto", producto);
        return "valoracionView/ValFormNew";
    }

    @PostMapping("/nuevo/submit")
    public String showNuevoSubmit(
            @Valid Valoracion valoracionForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/valoracion/nuevo";
        valoracionService.añadir(valoracionForm);
        return "redirect:/valoracion/producto/" + valoracionForm.getProducto().getId();
    }

    @GetMapping("/borrar/{idValoracion}")     
    public String showDelete(@PathVariable long idValoracion) {
        Valoracion valoracion = valoracionService.obtenerPorId(idValoracion);
        if (valoracion != null) {
            Usuario usuario = usuarioService.obtenerUsuarioConectado();
            if(usuario.getRol() == Rol.USER){
                if(usuario.getId() == valoracion.getUsuario().getId()){
                    valoracionService.borrar(idValoracion);
                }
            }
            else{
                valoracionService.borrar(idValoracion);
            }
        }
        return "redirect:/valoracion/producto/" + valoracion.getProducto().getId();

    }

}