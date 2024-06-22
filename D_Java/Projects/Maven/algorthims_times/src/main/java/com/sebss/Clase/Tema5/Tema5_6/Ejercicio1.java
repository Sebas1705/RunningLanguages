package com.sebss.Clase.Tema5.Tema5_6;

import java.util.*;

public class Ejercicio1 {

    public static List<String> list;

    public static void addElemToList(List<String> l, String e){
        l.add(e);
    }

    public static void main(String[] args) {
        list=new ArrayList<String>();
        list.add("Hola");
        list.add("Mundo");
        list.add("!!!!");
        list.remove(list.size()-1);
        addElemToList(list,"Buenas");
        list.stream().map(x->("Element "+list.indexOf(x)+": "+x)).forEach(System.out::println);
    }
}
