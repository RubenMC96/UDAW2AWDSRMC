package com.rmc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Cuenta;

@Service
public class ProductoServiceImp implements ProductoService{
    private List<Cuenta> listaProductos = new ArrayList<>();
    

    public Cuenta añadir(Cuenta producto) {
        listaProductos.add(producto);
        return producto; // podría no devolver nada, o boolean, etc.
    }
    public List<Cuenta> obteberLista() {
        return listaProductos;
    }
    public Cuenta obtenerPorIBAN(String IBAN) {
        for (Cuenta producto : listaProductos)
            if (producto.getIBAN() == IBAN)
                return producto;
        return null; // debería lanzar excepción si no encontrado
    }
    public Cuenta editar(Cuenta producto) {
        int pos = listaProductos.indexOf(producto);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        listaProductos.set(pos, producto); // si lo encuentra, lo sustituye
        return producto;
    }
    public void borrar(String IBAN) {
        Cuenta producto = this.obtenerPorIBAN(IBAN);
        if (producto != null) {
            listaProductos.remove(producto); // podría devolver boolean
        }
    }
    public List<Cuenta> findByCategory(String IBAN){
        List<Cuenta> listaProductosCat = new ArrayList<>();
        for (Cuenta producto : listaProductos){
            if (producto.getIBAN() == IBAN)
                listaProductosCat.add(producto);
        }
        return listaProductosCat;
    }
}
