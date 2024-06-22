package com.sebss.Clase.Tema2.Ejercicios;

import java.util.Random;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio4N {
    
    static final int N_CLIENTS=5;
	static volatile boolean[] requests = new boolean[N_CLIENTS];
	static volatile int[] r = new int[N_CLIENTS];

	public static void server() {
		for(int i=0;i<N_CLIENTS;i++){
			//Wait request's question:
			while(!requests[i]);
			//Server produce request
			r[i]+=1;
			//Info request its ready
			requests[i]=false;
		}
		
	}
	
	public static void clients() {
		Random random = new Random();
		for(int i=0;i<N_CLIENTS;i++){
			//Send a server request:
			r[i]=random.nextInt(100);
			requests[i]=true;
			//wait server responds:
			while(requests[i]);
			//Request process:
			println("Request nº"+i+": "+r[i]);
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<N_CLIENTS; i++) requests[i]=false;
		createThread("clients");
		createThread("server");
		startThreadsAndWait();
	}
}
