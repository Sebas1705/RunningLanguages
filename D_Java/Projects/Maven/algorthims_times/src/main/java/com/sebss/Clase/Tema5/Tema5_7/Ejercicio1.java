package com.sebss.Clase.Tema5.Tema5_7;

import java.util.concurrent.*;

public class Ejercicio1 {
    
    private final int N_TASK = 10;
    
    private void sleepRandom(long millis){
        try{
            Thread.sleep((long)(Math.random()*millis));
        }catch(InterruptedException e){}
    }

    private ExecutorService executor = Executors.newFixedThreadPool(N_TASK);
    private CompletionService<String> cs = new ExecutorCompletionService<>(executor);

    private String tarea()throws RuntimeException{
        sleepRandom(500);
        String name=Thread.currentThread().getName();
        if(Math.random()<0.2)throw new RuntimeException("Tarea "+name+" con error");
        return "Tarea "+name+" correcta";
    }

    public void exec()throws ExecutionException,InterruptedException{
        
        try{
            for(int i=0;i<N_TASK;i++)cs.submit(()->tarea());
            for(int i=0;i<N_TASK;i++){
                Future<String>f=cs.take();
                String info=f.get();
                System.out.println(info);
            }
        }finally{executor.shutdownNow();}
    }

    public static void main(String[] args){
        try {
            new Ejercicio1().exec();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }


}
