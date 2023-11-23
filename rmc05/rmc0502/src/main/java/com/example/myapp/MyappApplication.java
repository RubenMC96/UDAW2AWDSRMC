package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {
	/*5.2. Haz una copia del proyecto 4.3. y vamos a cambiar la forma de comunicaros con la aplicación.
Vamos a sustituir las URL con variables en la parte query y en la parte path por formularios. Veremos
como la capa de servicio permanece intacta (así comprobamos las ventajas de la separación por capas).
Lo haremos paso a paso:*/

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

}
