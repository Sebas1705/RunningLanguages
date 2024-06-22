package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;
import es.urjc.etsii.code.concurrency.SimpleSemaphore;

public class Ejercicio13B {
    
	private static final int NUM_TRENES = 5;
    private static final int NUM_TRAMOS = 5;
	private static SimpleSemaphore semaphores[] = new SimpleSemaphore[NUM_TRAMOS];
	
	public static void tren(int numTren) {
		for(int i=0;i<NUM_TRAMOS;i++){
            sleepRandom(500);
            semaphores[i].acquire();
            if(i!=0)semaphores[i-1].release();
            recorrerTramoX(numTren,i);
        }
        semaphores[NUM_TRAMOS-1].release();
	}
	
	private static void recorrerTramoX(int numTren,int index) {
		printlnI("Entra Tramo"+index+" Tren" + numTren);
		sleepRandom(500);
		printlnI("Sale Tramo"+index+" Tren" + numTren);
	}

	public static void main(String args[]){
		for(int i=0;i<NUM_TRAMOS;i++) semaphores[i]=new SimpleSemaphore(1);
		for(int i=0; i<NUM_TRENES; i++)createThread("tren", i);
		startThreadsAndWait();
	}
}
