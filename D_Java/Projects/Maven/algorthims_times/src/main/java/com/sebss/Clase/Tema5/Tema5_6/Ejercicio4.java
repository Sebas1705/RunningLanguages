package com.sebss.Clase.Tema5.Tema5_6;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Ejercicio4 {

    
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private Map<String,String> duplicates = new ConcurrentHashMap<>();
    
    private void println(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }    
    
    public void findDuplicates(File root) {
        if (root.isDirectory()) {
            for (File file : root.listFiles()) {
                if (file.isDirectory()) {
                    new Thread(()->findDuplicates(file),"Rama("+ANSI_RED+file.getName()+ANSI_RESET+")").start();
                } else {
                    String name = duplicates.putIfAbsent(file.getName(),file.getAbsolutePath());
                    if(name!=null){
                        println("Found duplicate file --> "+file.getName());
                    }
                }
            }
        }
    }
    public void exec() {
        new Thread(()->findDuplicates(new File("C:/Users/sebss/OneDrive/Escritorio/Prueba")),"Principal").start();
    }

    public static void main(String[] args) {
        new Ejercicio4().exec();
    }

}
