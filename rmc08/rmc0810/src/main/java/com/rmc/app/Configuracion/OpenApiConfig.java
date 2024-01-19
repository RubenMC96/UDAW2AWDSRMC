package com.rmc.app.Configuracion;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI myOpenAPI(){
        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:9000");
        prodServer.setDescription("Server URL in Production enviroment");

        Contact contact = new Contact();
        contact.setEmail("rubenmuozcumbreras@gmail.com");
        contact.setName("Ruben Muñoz");
        contact.setUrl("https://github.com/RubenMC96/UDAW2AWDSRMC.git");
        
        License mitLicense = new License().name("Mit license").url("License").url("https://choosealicense.com/licenses/mit/");
        Info info = new Info()
                            .title("Ejemplo de documentacion API")
                            .version("1.0")
                            .contact(contact)
                            .description("Ejemplo de documentacion API")
                            .termsOfService("https://github.com/RubenMC96/UDAW2AWDSRMC/blob/main/README.md")
                            .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(prodServer));
    }
}
