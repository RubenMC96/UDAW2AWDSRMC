package com.rmc.ejerciciosT6.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Categoria {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String nombre;


    @OneToMany(mappedBy = "categoria")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private List<Empleado> empleados = new ArrayList<>();


    public Categoria(Long id, String nombre){
   
    this.id = id;
    this.nombre = nombre;
}
}



