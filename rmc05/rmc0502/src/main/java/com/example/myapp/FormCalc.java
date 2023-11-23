package com.example.myapp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FormCalc {
    @NotNull
    @Min(1)
    private Integer num;



    public void setNum(int numb){

        this.num = numb;
    }
    public Integer getNum(){
        
        return num;
    }
}
