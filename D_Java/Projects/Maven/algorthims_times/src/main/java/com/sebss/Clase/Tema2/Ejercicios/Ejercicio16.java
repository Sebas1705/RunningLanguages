package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;
import es.urjc.etsii.code.concurrency.SimpleSemaphore;

public class Ejercicio16 {
    
    private static final int N_FRAGMENTOS = 10;
    private static final int N_HILOS = 3;
    private static volatile int[] fichero = new int[N_FRAGMENTOS];
    private static volatile int n=0;
    private static volatile int nHilosTerminados=0;
    private static SimpleSemaphore sp = new SimpleSemaphore(1);
    private static SimpleSemaphore sw = new SimpleSemaphore(0);


    private static int descargarDatos(int numFragmento) {
        sleepRandom(100);
        return numFragmento*2;
    }

    private static void mostrarFichero() {
        println("--------------------------------------------------");
        print("File = [");
        for (int i = 0; i < N_FRAGMENTOS; i++) {
            print(fichero[i]+"");
            if(i!=N_FRAGMENTOS-1)print(",");
        }
        println("]");
    }

    public static void downloader() {
        while(true){
            while(true){
                if(n==N_FRAGMENTOS)break;   
                sp.acquire();
                int a = n++;
                sp.release();
                println(getThreadName()+": Descargando y escribiendo fragmento "+a);
                fichero[a]=descargarDatos(a); 
            }
            sp.acquire();
            nHilosTerminados++;
            if(nHilosTerminados!=N_HILOS-1){
                sp.release();
                sw.acquire();
            }else{
                sp.release();
                mostrarFichero();
                for(int i=0;i<N_FRAGMENTOS;i++) fichero[i] = 0;
                n=0;
                nHilosTerminados=0;
                sw.release();
            }
        }
    }

    public static void main(String[] args) {
        createThreads(N_HILOS, "downloader");
        startThreadsAndWait();
    }
}
