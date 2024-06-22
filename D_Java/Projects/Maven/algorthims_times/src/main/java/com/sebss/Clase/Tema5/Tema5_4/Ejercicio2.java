package com.sebss.Clase.Tema5.Tema5_4;

public class Ejercicio2 {
    
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

    static volatile double producto;

    public static void productor() {
        producto = Math.random();
        sinc.signal();
    }
    public static void consumidor() {
        sinc.await();
        println("Producto: "+producto);
    }
    public void exec() {
        new Thread(()-> productor()).start();
        new Thread(()-> consumidor()).start();
    }

    public static void main(String[] args){
        new Ejercicio2().exec();
    }
}
