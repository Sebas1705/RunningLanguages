package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;
import es.urjc.etsii.code.concurrency.SimpleSemaphore;

public class Ejercicio17{

    private static final int N_FILOSOFOS=5;
    private static SimpleSemaphore tenedores=new SimpleSemaphore(N_FILOSOFOS);

    public static void filosofo(int n){
        while(true){
            printlnI("Filosofo "+n+": pensando");
            tenedores.acquire(2);
            printlnI("Filosofo "+n+": comiendo");
            tenedores.release();
            tenedores.release();
        }
        
    }

    public static void main(String[] args) {
        for(int i=0;i<N_FILOSOFOS;i++) createThread("filosofo",i);
        startThreadsAndWait();
    }
}