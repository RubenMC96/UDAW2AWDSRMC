package com.rmc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Producto;

@Service
public class ProductoServiceImp implements ProductoService{
    private List<Producto> listaProductos = new ArrayList<>();
    

    public Producto añadir(Producto producto) {
        listaProductos.add(producto);
        return producto; // podría no devolver nada, o boolean, etc.
    }
    public List<Producto> obteberLista() {
        return listaProductos;
    }
    public Producto obtenerPorId(long id) {
        for (Producto producto : listaProductos)
            if (producto.getId() == id)
                return producto;
        return null; // debería lanzar excepción si no encontrado
    }
    public Producto editar(Producto producto) {
        int pos = listaProductos.indexOf(producto);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        listaProductos.set(pos, producto); // si lo encuentra, lo sustituye
        return producto;
    }
    public void borrar(Long id) {
        Producto producto = this.obtenerPorId(id);
        if (producto != null) {
            listaProductos.remove(producto); // podría devolver boolean
        }
    }
    public List<Producto> findByCategory(Long idCat){
        List<Producto> listaProductosCat = new ArrayList<>();
        for (Producto producto : listaProductos){
            if (producto.getIdCategoria() == idCat)
                listaProductosCat.add(producto);
        }
        return listaProductosCat;
    }
}
