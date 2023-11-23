package com.rmc.app;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FormServiceImp implements FormService {
 List<Pais> paises = new ArrayList<>();

    public boolean cargarPaisesDesdeFichero(){
         List<String> lineas;
         String[] partes = new String[3];
         try{
            Path path = Paths.get("/paises2019.csv");
            lineas = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
         } catch(IOException ex){
            System.err.printf("%nError:%s", ex.getMessage());
            return false;
         }
         for(String linea : lineas){
            partes = linea.split(";");
            if(partes.length == 3){
                paises.add(new Pais(partes [0], partes[1],Long.parseLong(partes[2])));
            }
            else 
            return false;
         }
         return true;
    }
}
