package com.sebss.Clase.Tema2.Ejercicios;

import java.util.Random;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio2 {
	
	/**
	 * Se desea ampliar el programa del Ejercicio 1 de forma que el proceso productor esté constantemente
     * produciendo números consecutivos. El proceso consumidor estará constantemente consumiendo los
     * productos. No se puede quedar ningún producto sin consumir. No se puede consumir dos veces el mismo
     * producto
	 */

	private static final int NUMBER_OF_PRODUCTS=20;
	private static volatile boolean producerFinish;
	private static volatile int r;

	public static void producer() {
		Random random = new Random();
		for(int i=0;i<NUMBER_OF_PRODUCTS;i++){
			while(producerFinish);
			r = random.nextInt(100);
			producerFinish=true;
		}
	}
	
	public static void consumer() {
		for(int i=0;i<NUMBER_OF_PRODUCTS;i++){
			while(!producerFinish);
			println("Product: "+r);
			producerFinish=false;
		}
		
	}
	
	public static void main(String[] args) {
		producerFinish=false;
		createThread("producer");
		createThread("consumer");
		startThreadsAndWait();
	}
	
}
