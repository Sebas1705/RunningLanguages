package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;


public class Ejercicio7 {

    /**
     * Para incentivar las visitas, cuando una persona entre en el museo estando vacío, será obsequiado con un
     * regalo. Las personas, después de saludar, dicen si les han dado un regalo (“Tengo regalo”) o si no (“No
     * tengo regalo”). Las personas deben permitir que otras personas saluden entre su saludo y el comentario
     * sobre el regalo
     */

    static volatile int personas;
	
	public static void persona() {

		while (true) {
			
			enterMutex();
			personas++;
			printlnI("hola, somos "+personas);			
			if(personas == 1){
				exitMutex();
				printlnI("Tengo regalo");				
			} else {
				exitMutex();
				printlnI("No tengo regalo");
			}			
			
	        printlnI("qué bonito!");
			printlnI("alucinante!");
			
			enterMutex();
			personas--;
			printlnI("adiós a los "+personas);
			exitMutex();					
			
			printlnI("paseo");
		}
	}

	public static void main(String[] args) {
		personas = 0;
		createThreads(3, "persona");
		startThreadsAndWait();
	}
}
