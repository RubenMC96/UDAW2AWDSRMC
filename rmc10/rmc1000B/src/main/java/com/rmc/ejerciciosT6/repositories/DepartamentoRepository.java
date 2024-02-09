package com.rmc.ejerciciosT6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmc.ejerciciosT6.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
Departamento findByNombre(String nombre); }