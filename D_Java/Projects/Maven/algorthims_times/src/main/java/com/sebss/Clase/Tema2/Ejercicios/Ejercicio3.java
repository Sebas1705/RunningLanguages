package com.sebss.Clase.Tema2.Ejercicios;

import java.util.Random;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio3 {

	/**
	 * Programa formado por un proceso servidor y otro proceso cliente. El proceso cliente hace una petición al
	 * proceso servidor (en forma de número aleatorio) y espera su respuesta, cuando la recibe, la procesa. El
	 * proceso servidor no hace nada hasta que recibe una petición, momento en el que suma 1 al número
	 * enviado en la petición y contesta con ese valor. El proceso cliente procesa la respuesta mostrándola por
     * pantalla.
	 */

	static final int REPS = 5;
	static volatile boolean request;
	static volatile int r;

	public static void server() {
		//Wait request's question:
		while(!request);
		//Server produce request
		r+=1;
		//Info request its ready
		request=false;
	}
	
	public static void client() {
		Random random = new Random();
		//Send a server request:
		r=random.nextInt(100);
		request=true;
		//wait server responds:
		while(request);
		//Request process:
		println("Request: "+r);
	}
	
	public static void main(String[] args) {
		request=false;
		createThread("client");
		createThread("server");
		startThreadsAndWait();
	}
	
}
