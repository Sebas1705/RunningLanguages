package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

import java.util.Random;

public class Ejercicio5 {
    
    /**
     * Existen 3 personas en el mundo, 1 museo, y sólo cabe una persona dentro del museo. Las personas realizan
     * cuatro acciones dentro del museo:
     *  Cuando entran al museo saludan: “hola!”
     *  Cuando ven el museo se sorprenden: “qué bonito!” y “alucinante!”
     *  Cuando se van del museo se despiden: “adios”
     *  Cuando salen del museo se van a dar un “paseo
     */

    public static void turist(){
        while(true){
            enterMutex();
            printlnI("Hola!");
            sleep(500);
            printlnI("que bonito!");
            printlnI("alucinante!");
            sleep(500);
            printlnI("adiós\n\n");
            exitMutex();
            sleep(new Random().nextInt(9000)+1000);
        }
    }

    public static void main(String[] args) {
        createThreads(3,"turist");
        startThreadsAndWait();
    }
}
