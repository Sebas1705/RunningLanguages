package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;
import es.urjc.etsii.code.concurrency.SimpleSemaphore;

public class Ejercicio15 {
    
    private static SimpleSemaphore emNProcesos,sb,desbloqueo;
    private static volatile int nProcesos;

    public static void procesoA() {
        while(true){
            print("A");
            sincronizacion();
        }
    }
    public static void procesoB() {
        while(true){
            print("B");
            sincronizacion();
        }
    }public static void procesoC() {
        while(true){
            print("C");
            sincronizacion();
        }
    }
    public static void procesoD() {
        while(true){
            print("D");
            sincronizacion();
        }
    }
       
    public static void sincronizacion() {
        emNProcesos.acquire();
        nProcesos++;
        if (nProcesos < 4) {
            emNProcesos.release();
            sleepRandom(500);
            sb.acquire();
            desbloqueo.release();
        } else {
            println("-");
            nProcesos = 0;
            sb.release(3);
            desbloqueo.acquire(3);
            emNProcesos.release();
        }
    }

    public static void main(String[] args) {
        nProcesos=0;
        emNProcesos=new SimpleSemaphore(1);
        sb=new SimpleSemaphore(3);
        desbloqueo=new SimpleSemaphore(3);
        createThread("procesoA");
        createThread("procesoB");
        createThread("procesoC");
        createThread("procesoD");
        startThreadsAndWait();
    }
}
