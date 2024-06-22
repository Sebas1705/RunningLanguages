package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ejercicio7 {
    
    private final int N_FRAGMENTOS = 10;
    private final int N_HILOS = 3;
    private final int N_FILES = 4;

    private volatile int[] fichero = new int[N_FRAGMENTOS];
    private volatile int n=0;
    private CyclicBarrier cb;
    private Lock lock; 

    private void println(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }
    private void print(String msg){System.out.print(msg);}

    private void sleepRandom(long millis){
        try {
            Thread.sleep((long)(Math.random()*millis));
        } catch (InterruptedException e) {e.printStackTrace();}
    }

    private int descargarDatos(int numFragmento) {
        sleepRandom(100);
        return numFragmento*2;
    }

    private void mostrarFichero() {
        println("--------------------------------");
        print("\t"+"File = [");
        for (int i = 0; i < N_FRAGMENTOS; i++) {
            print(fichero[i]+"");
            if(i!=N_FRAGMENTOS-1)print(",");
            else print("]\n");
        }
    }

    private void downloader() throws InterruptedException, BrokenBarrierException {
        for(int i=0;i<N_FILES;i++){
            while(true){
                lock.lock();
                if(n==N_FRAGMENTOS){
                    lock.unlock();
                    cb.await();
                    break;
                }else{
                    int a=n++;
                    lock.unlock();
                    println("Descargando y escribiendo dato "+a);
                    fichero[a]=descargarDatos(a);
                }
            }
        }
    }

    public void exec(){
        lock=new ReentrantLock();
        cb=new CyclicBarrier(N_HILOS,()->{
            mostrarFichero();
            n=0;
        });
        for(int i=0;i<N_HILOS;i++) new Thread(()->{
            try {
                downloader();
            } catch (InterruptedException | BrokenBarrierException e) {e.printStackTrace();}
        },"Downloader"+i).start();
    }

    public static void main(String[] args) {
        new Ejercicio7().exec();
    }
}
