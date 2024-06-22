package com.sebss.Clase.Tema5.Tema5_4;

public class Ejercicio1 {

    private static class SincCond {
        private volatile boolean sincCond;
        SincCond(){sincCond=true;}
        public void await(){
            while(sincCond);
            sincCond=true;
        }
        public void signal(){
            sincCond=false;
        }
    }

    private volatile static SincCond sinc=new SincCond();
    
    private static void println(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }

    private static void thread1(){
        println("Hola, me pongo en espera");
        sinc.await();
        println("Sali de la espera");
    } 

    private static void thread2(){
        println("Espero cinco y saco a 1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {e.printStackTrace();}
        println("Saco a 1");
        sinc.signal();
    }

    private void exec(){
        Thread t1 = new Thread(()->thread1(),"Hilo 1");
        Thread t2 = new Thread(()->thread2(),"Hilo 2");

        t1.start();
        t2.start();
    }

    public static void main(String[] args){
        new Ejercicio1().exec();
    }

}
