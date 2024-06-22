package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.locks.*;

public class Ejercicio2 {
    
    private static final int N_PERSONAS=3;
    private static final int N_VUELTAS=4;

    private void println(String msg){
        String name=Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }

    private Lock lock=new ReentrantLock();
    private volatile int personas; 

    private void persona() throws InterruptedException{
        for(int i=0;i<N_VUELTAS;i++){
			lock.lock();
            Thread.sleep(500);
			personas++;
			println("hola, somos "+personas);			
			if(personas == 1){
				lock.unlock();
				println("Tengo regalo");				
			} else {
				lock.unlock();
				println("No tengo regalo");
			}			
            Thread.sleep(500);
	        println("qué bonito!");
            Thread.sleep(500);
			println("alucinante!");
			lock.lock();
            Thread.sleep(500);
			personas--;
			println("adiós a los "+personas);
			lock.unlock();					
			println("paseo");
            Thread.sleep(3000);
		}
    }

    public void exec(){
        for(int i=0;i<N_PERSONAS;i++) new Thread(()->{
            try {
                persona();
            } catch (InterruptedException e) {e.printStackTrace();}
        },"persona"+i).start();
    }

    public static void main(String[] args) {
        new Ejercicio2().exec();
    }
}
