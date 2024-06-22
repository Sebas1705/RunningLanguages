package com.sebss.Clase.Tema2.Ejercicios;

import java.util.Random;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio1 {
	
	/**
	 * Se desea implementar un programa concurrente con un proceso que produce información (productor) y
	 * otro proceso que hace uso de esa información (consumidor). El proceso productor genera un número
     * aleatorio y termina. El proceso consumidor muestra por pantalla el número generado y termina.
	 */
	
	
	static volatile boolean producerFinish;
	static volatile int r;

	public static void producer() {
		Random random = new Random();
		r = random.nextInt(100);
		producerFinish=true;
	}
	
	public static void consumer() {
		while(!producerFinish);
		println("Product: "+r);
	}
	
	public static void main(String[] args) {
		producerFinish=false;
		createThread("producer");
		createThread("consumer");
		startThreadsAndWait();
	}
	
}
