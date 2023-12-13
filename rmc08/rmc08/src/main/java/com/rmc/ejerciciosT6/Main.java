package com.rmc.ejerciciosT6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Genero;
import com.rmc.ejerciciosT6.service.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@Bean
		CommandLineRunner initData(EmpleadoService empleadoService) {
			return args -> {
				empleadoService.añadir(
					new Empleado(0L, 
							"pepe", 
							"pepe@gmail.com", 
							1000d, 
							true,
							Genero.MASCULINO));
					
				empleadoService.añadir(
					new Empleado(0L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO));
			};
		}

}
