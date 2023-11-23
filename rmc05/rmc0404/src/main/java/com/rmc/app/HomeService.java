package com.rmc.app;


import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;



@Service
public class HomeService {

    Random random = new Random();
    public Set<Integer> list = new LinkedHashSet<>();


   public Set<Integer> New(){

        int tamPrevioLista = list.size();
        do{
            list.add(random.nextInt(100)+1);
        }while(list.size() == tamPrevioLista);

        return list;
    }

    public Set<Integer> Delete(int id){

        list.remove(id);

        return list;
    }
}