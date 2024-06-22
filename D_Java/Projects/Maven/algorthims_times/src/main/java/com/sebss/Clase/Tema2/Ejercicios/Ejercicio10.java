package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio10 {
    
    /**
     * El programa consta de 3 procesos.
     * Cada proceso escribe por pantalla varias letras y termina. El proceso 1 debe escribir la letra ‘A’ y la
     * letra ‘B’. El proceso 2 debe escribir la letra ‘C’, la letra ‘D’ y la letra ‘E’. El proceso 3 debe escribir la
     * letra ‘F’ y la letra ‘G’.
     * Los procesos deben sincronizarse para que se cumplan las siguientes relaciones de precedencia:
     * procces1: |->-->A-->B->_->|
     * procces2: |->C--^->D-->E->|
     * procces3: |->F-->->^>D-^->|
     * La sincronización condicional se deberá implementar con espera activa.
    */

    private static volatile boolean pA=false;
    private static volatile boolean pD=false;
    private static volatile boolean pE1=false,pE3=false;

    public static void process1(){
        while(!pA);
        println("A");
        println("B");
        pE1=true;
    }
    public static void process2(){
        println("C");
        pA=true;
        while(!pD);
        println("D");
        while(!(pE1&&pE3));
        println("E");
    }
    public static void process3(){
        println("F");
        pD=true;
        println("G");
        pE3=true;
    }

    public static void main(String[] args) {
        createThread("process1");
        createThread("process2");
        createThread("process3");
        startThreadsAndWait();
    }
}
