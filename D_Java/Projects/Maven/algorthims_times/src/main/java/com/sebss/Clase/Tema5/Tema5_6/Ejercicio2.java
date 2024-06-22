package com.sebss.Clase.Tema5.Tema5_6;

import java.util.*;

public class Ejercicio2 {
    
    private static Map<String,Aeropuerto> map = new HashMap<String,Aeropuerto>();

    public static void main(String[] args) {
        map.put("El Prat",new Aeropuerto(10,20));
        map.put("Barajas",new Aeropuerto(15,30));
        map.put("Castellón",new Aeropuerto(5,10));
        
        Aeropuerto barajas = map.get("Barajas");
        System.out.println(barajas);
        map.entrySet().forEach(System.out::println);
    }

    public record Aeropuerto(int nAviones,int nAparcamientos){}
}
