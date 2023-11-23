package com.rmc.ejerciciosT6.service;
import java.util.ArrayList;
import java.util.List;
import com.rmc.ejerciciosT6.domain.Empleado;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();

    public Empleado añadir(Empleado empleado) {
        repositorio.add(empleado);
        return empleado; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {
        return repositorio;
    }

    public Empleado obtenerPorId(long id) {
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        return null; // debería lanzar excepción si no encontrado
    }

    public Empleado editar(Empleado empleado) {
        int pos = repositorio.indexOf(empleado);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        repositorio.set(pos, empleado); // si lo encuentra, lo sustituye
        return empleado;
    }

    public void borrar(Long id) {
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null) {
            repositorio.remove(empleado); // podría devolver boolean
        }
    }
}
