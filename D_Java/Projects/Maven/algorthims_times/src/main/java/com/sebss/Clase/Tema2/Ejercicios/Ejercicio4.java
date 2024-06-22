package com.sebss.Clase.Tema2.Ejercicios;

import java.util.Random;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio4 {
    
	/**
	 * Se desea ampliar el programa anterior de forma que el proceso cliente esté constantemente haciendo
	 * peticiones y el proceso servidor atendiendo a las mismas.
	 */

    static final int REPS = 100000000;
	static volatile boolean request;
	static volatile int r;

	public static void server() {
		for(int i=0;i<REPS;i++){
			//Wait request's question:
			while(!request);
			//Server produce request
			r+=1;
			//Info request its ready
			request=false;
		}
		
	}
	
	public static void client() {
		Random random = new Random();
		for(int i=0;i<REPS;i++){
			//Send a server request:
			r=random.nextInt(100);
			request=true;
			//wait server responds:
			while(request);
			//Request process:
			println("Request: "+r);
		}
	}
	
	public static void main(String[] args) {
		request=false;
		createThread("client");
		createThread("server");
		startThreadsAndWait();
	}
}
