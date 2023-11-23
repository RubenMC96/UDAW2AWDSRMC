package com.example.myapp;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


    @Service
        
    public class FechasService {
    
        public long diasPasadosEnero(String fecha){
            LocalDate dia = LocalDate.parse(fecha);
            int annoNum = dia.getYear();
            String anno = String.valueOf(annoNum);
            String fechaInicio = anno + "-01" + "-01";
            LocalDate inicio = LocalDate.parse(fechaInicio);

            long tiempo = ChronoUnit.DAYS.between(inicio, dia);

            return tiempo;
        } 
        public long periodoFechas(String fecha1, String fecha2){

            LocalDate fech1 = LocalDate.parse(fecha1);
            LocalDate fech2 = LocalDate.parse(fecha2);

            long tiempo = ChronoUnit.DAYS.between(fech2, fech1);

            return tiempo;
        } 
        public long diasAnno(){

            LocalDate fech1 = LocalDate.now();
            int annoNum = fech1.getYear();
            String anno = String.valueOf(annoNum);
            String fechaInicio = anno + "-01" + "-01";
            LocalDate fech2 = LocalDate.parse(fechaInicio);

            long tiempo = ChronoUnit.DAYS.between(fech2, fech1);
            return tiempo;
        }
        public boolean bisiesto(String fecha){
        
            boolean isBisiesto = false;
            LocalDate fech = LocalDate.parse(fecha);
            int anno = fech.getYear();

            if(anno % 4 == 0 || anno % 100 == 0 && anno % 400 == 0 ){
                isBisiesto = true;
            }

            return isBisiesto;
        }
        public List<Integer> annosBisiesto(String fecha1, String fecha2){

            LocalDate fech1 = LocalDate.parse(fecha1);
            LocalDate fech2 = LocalDate.parse(fecha2);
            int anno1 = fech1.getYear();
            int anno2 = fech2.getYear();

            List<Integer> annos = new ArrayList<>();



            if(anno1 < anno2){
        
                for(int i = anno1 ; i <= anno2 ; i++){
                    if(i % 4 == 0 || i % 100 == 0 && i % 400 == 0 ){
                
                        annos.add(i);
                    }
                }
            }
            else{
                for(int i = anno2 ; i <= anno1 ; i++){
                    if(i % 4 == 0 || i % 100 == 0 && i % 400 == 0 ){
                
                        annos.add(i);
                    }
                }
            }

            return annos;
        }
                

                
    }


        



