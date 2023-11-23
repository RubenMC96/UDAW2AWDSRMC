package com.rmc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Movimiento;

@Service
public class CategoriaServiceImp implements CategoriaService{
    private List<Movimiento> listaCategorias = new ArrayList<>();

    public Movimiento añadir(Movimiento categoria) {
        listaCategorias.add(categoria);
        return categoria; // podría no devolver nada, o boolean, etc.
    }
    public List<Movimiento> obteberLista() {
        return listaCategorias;
    }
    public Movimiento obtenerPorId(long id) {
        for (Movimiento categoria : listaCategorias)
            if (categoria.getId() == id)
                return categoria;
        return null; // debería lanzar excepción si no encontrado
    }
    public Movimiento editar(Movimiento categoria) {
        int pos = listaCategorias.indexOf(categoria);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        listaCategorias.set(pos, categoria); // si lo encuentra, lo sustituye

        System.out.println(categoria);
        System.out.println(listaCategorias);
        return categoria;
    }
    public void borrar(Long id) {
        Movimiento categoria = this.obtenerPorId(id);
        if (categoria != null) {
            listaCategorias.remove(categoria); // podría devolver boolean
        }
    }
}
