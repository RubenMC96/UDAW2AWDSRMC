package com.rmc.app;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import lombok.Data;
@Data
public class Pais implements CommandLineRunner{
    private String nombre;
    private String capital;
    private Long población;


    public Pais(String nombre, String capital, Long población){};
    
}


