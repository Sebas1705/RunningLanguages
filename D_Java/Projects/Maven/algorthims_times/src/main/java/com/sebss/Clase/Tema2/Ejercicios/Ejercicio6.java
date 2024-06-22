package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio6 {

    /**
     * Considerar que caben infinitas personas dentro del museo. Cada persona al entrar tiene que saludar
     * diciendo cuántas personas hay en el museo: “hola, somos 3”. Al despedirse tiene que decir el número de
     * personas que quedan tras irse: “adiós a los 2”.
     */

    static volatile int numTurists; 

    public static void turist(){
        while(true){
            enterMutex();
            numTurists++;
            printlnI("Hola, somos "+numTurists);
            exitMutex();

            printlnI("Que bonito!");
            printlnI("Alucinante!");

            enterMutex();
            numTurists--;
            printlnI("Adios a los "+numTurists);
            exitMutex();

            
            printlnI("Paseo");
            sleep((long) (Math.random()*10000+500));
        }
    }

    public static void main(String[] args) {
        numTurists=0;
        createThreads(3,"turist");
        startThreadsAndWait();
    }
}
