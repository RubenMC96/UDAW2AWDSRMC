package com.rmc.ejerciciosT6.service;
import java.util.List;
import com.rmc.ejerciciosT6.domain.Empleado;
import org.springframework.stereotype.Service;


@Service
public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);

    public List<Empleado> obtenerTodos();

    public Empleado obtenerPorId(long id);

    public Empleado editar(Empleado empleado);

    public void borrar(Long id);

    public List<Empleado> obtenerPorDto(Long id);

    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}
