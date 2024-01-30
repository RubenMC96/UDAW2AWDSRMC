package com.rmc.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rmc.app.domain.Rol;
import com.rmc.app.domain.Usuario;
import com.rmc.app.service.UsuarioService;




@SpringBootApplication
public class AppApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Bean
		CommandLineRunner initData(UsuarioService usuarioService) {
			return args -> {

				usuarioService.añadir(new Usuario(0L,"admin", "1234", Rol.ADMIN));
			};
	}
}
