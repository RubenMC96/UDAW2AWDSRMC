package com.rmc.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rmc.app.domain.Cuenta;
import com.rmc.app.service.CuentaService;
import com.rmc.app.service.MovimientoService;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(MovimientoService movimientoService, CuentaService cuentaService) {

		return args -> {
			cuentaService.añadir(new Cuenta("ES61 1234 3456 42 0456323532", "Salarios", 0f));
			cuentaService.añadir(new Cuenta("ES16 4321 3456 24 0456323532", "Gastos", 0f));
			cuentaService.añadir(new Cuenta("ES20 9874 5687 24 0456326572", "Gastos", 0f));
		};
	}

}
