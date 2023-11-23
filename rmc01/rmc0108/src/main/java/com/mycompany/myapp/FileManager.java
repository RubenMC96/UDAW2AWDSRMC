package com.mycompany.myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;


public class FileManager {

    public static ArrayList<Empleado> leerFichero() {

        File f = new File("empleados.csv"); 
        String cadena;
        ArrayList <Empleado> empleados = new ArrayList<>();
            try (FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8"); //"ISO-8859-1"
            BufferedReader bfr = new BufferedReader(isr)) {
            while((cadena=bfr.readLine()) != null){
    
                String[] partes = cadena.split(";");
                if (partes.length == 3){
                    long id = Long.parseLong(partes[0]);
                    String nombre = partes[1];
                    double salario = Double.parseDouble(partes[2]);
                    empleados.add(new Empleado(id,nombre,salario));
                }

                else System.out.println("Error de formato");


            }
            //tratamiento, por ejemplo: System.out.println(cadena);
            }
            catch (IOException ex) {
            System.err.printf("Error:%s\n",ex.getMessage());
            }

            return empleados;
    }
}
