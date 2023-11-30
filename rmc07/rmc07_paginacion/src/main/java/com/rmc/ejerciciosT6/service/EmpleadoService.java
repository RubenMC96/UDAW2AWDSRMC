package com.rmc.ejerciciosT6.service;
import java.util.List;
import com.rmc.ejerciciosT6.domain.Empleado;
import org.springframework.stereotype.Service;


@Service
public interface EmpleadoService {

    public int getTotalPaginas();
    public List<Empleado> getEmpleadosPaginados(Integer pageNum);
}
