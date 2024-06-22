package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.locks.*;

public class Ejercicio3 {

    private final int N_LECTORES=5;
    private final int N_ESCRITORES=3;
    private ReadWriteLock rw = new ReentrantReadWriteLock();
    
    private void println(String msg){
        String name=Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }

    private void sleepRandom(long millis){
        try{
            Thread.sleep((long)(Math.random()*millis));
        }catch(InterruptedException e){e.printStackTrace();}
    }

    private void lector() {
        while (true) {
            rw.readLock().lock();
            println("Leer datos");
            sleepRandom(2000);
            rw.readLock().unlock();
            println("Procesar datos");
            sleepRandom(2000);
        }    
    }

    private void escritor() {
        while (true) {
            println("Generar datos");
            sleepRandom(2000);
            rw.writeLock().lock();
            println("Escribir datos");
            sleepRandom(2000);
            rw.writeLock().unlock();
        }
    }

    public void exec(){
        for(int i=0;i<N_LECTORES;i++) new Thread(()->lector(),"Lector "+i).start();
        for(int i=0;i<N_ESCRITORES;i++) new Thread(()->escritor(),"Escritor "+i).start();
    }
    
    public static void main(String[] args) {
        new Ejercicio3().exec();
    }
}
