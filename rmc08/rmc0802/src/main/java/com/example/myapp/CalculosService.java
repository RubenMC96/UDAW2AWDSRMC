package com.example.myapp;

import java.util.List;
import java.util.Set;


import org.springframework.stereotype.Service;


    @Service
        
    public interface CalculosService {
    
        public boolean esPrimo(int numero);

        public double hipotenusa(int num1, int num2);

        public Set<Integer> sinRepetidos(int num);

        public List<Integer> divisores(int div);

                 
    }


        



