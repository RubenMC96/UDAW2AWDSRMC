package com.rmc.ejerciciosT6.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*Aqui es donde ponemos las ManyToOne*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity

public class Empleado {
   
    @Id
    @GeneratedValue
        private Long id;
    @NotEmpty
        private String nombre;
    @Email(message = "Debe tener formato email valido")
        private String email;
    private Double salario;
    private boolean enActivo;
    private Genero genero;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departamento departamento;

    @ToString.Exclude/*@ToString.Exclude a la Categoría ya que como una 
                        categoría a su vez incluye otros empleados, que 
                        tienen categoría... se puede producir un bucle infinito.*/
    @ManyToOne
    private Categoria categoria;
}
