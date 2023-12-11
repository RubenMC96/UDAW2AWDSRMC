package com.rmc.ejerciciosT6.service;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.ejerciciosT6.DepartamentoRepository;
import com.rmc.ejerciciosT6.EmpleadoRepository;
import com.rmc.ejerciciosT6.DTO.EmpleadoDTO;
import com.rmc.ejerciciosT6.domain.Departamento;
import com.rmc.ejerciciosT6.domain.Empleado;


@Service
public class EmpleadoServiceImp implements EmpleadoService{
    @Autowired
    EmpleadoRepository repositorio;
    @Autowired
    DepartamentoRepository repositoryDto;

    @Autowired
    public ModelMapper modelMapper;

    public Empleado añadir(Empleado empleado) {
        repositorio.save(empleado);
        return empleado; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }

    public Empleado obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerPorDto(Long id){
        
        Departamento depart = repositoryDto.findById(id).orElse(null);

        if(depart != null){
            return repositorio.findByDepartamento (depart);
        }
        else return null;
       

    }

    public List<Empleado> obtenerEmpleadosSalarioMayor (double salario){
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }

    public List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados) {
    List<EmpleadoDTO> listaEmpleadoDTO = new ArrayList<>();
    for (Empleado empleado : listaEmpleados)
    listaEmpleadoDTO.add(modelMapper.map(empleado, EmpleadoDTO.class));
    return listaEmpleadoDTO;
    }
}
