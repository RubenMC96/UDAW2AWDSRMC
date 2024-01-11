package com.example.myapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;


    @Service
        
    public class CalculosServiceImpl implements CalculosService {
    
        public boolean esPrimo(int numero){
            boolean primo = true;
            for (int i = 2; i <= numero / 2; i++) {
                    if (numero % i == 0) {
                        primo = false;
                        break;
                    }
                }
            return primo;
        } 
        public double hipotenusa(int num1, int num2){
            double hipo;

            hipo = Math.round(Math.sqrt((Math.pow(num1, 2) + Math.pow(num2, 2))));
    
            return hipo;
        } 
        public Set<Integer> sinRepetidos(int num){

            Set<Integer> lista = new TreeSet<Integer>();
            if(num > 1 && num < 100){
                for(int i = 1; i <= num; i++){

                    int aleatorio = (int) ((Math.random()*100)+1);

                    lista.add(aleatorio);
                }
            }
            return lista;
        }
        public List<Integer> divisores(int div){

            List <Integer> lista = new ArrayList<>();
        
                for(int i = div; i>= 1 ; i--){
                    
                    if(div % i == 0){
                        lista.add(i);
                    }
                }

            return lista;
        }
                

                
    }


        



