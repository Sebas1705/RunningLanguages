package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.Semaphore;

public class Ejercicio1 {

    private static final int NUMBER_OF_PRODUCTS=5;
    private static Semaphore sem=new Semaphore(1);
	private static volatile int buffer[]=new int[NUMBER_OF_PRODUCTS];

    private static void println(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }

	private static void producer() throws InterruptedException {
		for(int i=0;i<NUMBER_OF_PRODUCTS;i++){
			sem.acquire();
            buffer[i]=(int)(Math.random()*99+1);
            sem.release();
		}
	}
	
	private static void consumer() throws InterruptedException {
		for(int i=0;i<NUMBER_OF_PRODUCTS;i++){
			sem.acquire();
			println("buffer["+i+"]="+buffer[i]);
			sem.release();
		}
	}

    public void exec(){
        new Thread(()->{
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Producer").start();
        new Thread(()->{
            try {
                consumer();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();
    }
	
	public static void main(String[] args) {
		new Ejercicio1().exec();
	}
}
