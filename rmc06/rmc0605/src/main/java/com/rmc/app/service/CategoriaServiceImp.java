package com.rmc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Categoria;

@Service
public class CategoriaServiceImp implements CategoriaService{
    private List<Categoria> listaCategorias = new ArrayList<>();

    public Categoria añadir(Categoria categoria) {
        listaCategorias.add(categoria);
        return categoria; // podría no devolver nada, o boolean, etc.
    }
    public List<Categoria> obteberLista() {
        return listaCategorias;
    }
    public Categoria obtenerPorId(long id) {
        for (Categoria categoria : listaCategorias)
            if (categoria.getId() == id)
                return categoria;
        return null; // debería lanzar excepción si no encontrado
    }
    public Categoria editar(Categoria categoria) {
        int pos = listaCategorias.indexOf(categoria);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        listaCategorias.set(pos, categoria); // si lo encuentra, lo sustituye

        System.out.println(categoria);
        System.out.println(listaCategorias);
        return categoria;
    }
    public void borrar(Long id) {
        Categoria categoria = this.obtenerPorId(id);
        if (categoria != null) {
            listaCategorias.remove(categoria); // podría devolver boolean
        }
    }
}
