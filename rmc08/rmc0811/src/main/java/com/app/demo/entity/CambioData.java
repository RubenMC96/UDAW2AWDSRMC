package com.app.demo.entity;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CambioData {
    private float amount;
    private String base;
    private String date;
    private HashMap<String,Float> rates;
}
