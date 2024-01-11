package com.example.myapp;

import java.util.List;

import org.springframework.stereotype.Service;


    @Service
        
    public interface FechasService {
    
        public long diasPasadosEnero(String fecha);

        public long periodoFechas(String fecha1, String fecha2);

        public long diasAnno();

        public boolean bisiesto(String fecha);

        public List<Integer> annosBisiesto(String fecha1, String fecha2);
                

                
    }


        



