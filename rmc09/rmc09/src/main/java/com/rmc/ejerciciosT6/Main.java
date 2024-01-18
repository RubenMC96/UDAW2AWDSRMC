package com.rmc.ejerciciosT6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rmc.ejerciciosT6.domain.Empleado;
import com.rmc.ejerciciosT6.domain.Genero;
import com.rmc.ejerciciosT6.domain.Rol;
import com.rmc.ejerciciosT6.domain.Usuario;
import com.rmc.ejerciciosT6.repositories.UsuarioRepository;
import com.rmc.ejerciciosT6.service.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@Bean
		CommandLineRunner initData(EmpleadoService empleadoService, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
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
			
				usuarioRepository.save(new Usuario(null, "admin1", passwordEncoder.encode("1234"),Rol.ADMIN));
				usuarioRepository.save(new Usuario(null, "user1", passwordEncoder.encode("1234"),Rol.USER));
			};
	}

}
