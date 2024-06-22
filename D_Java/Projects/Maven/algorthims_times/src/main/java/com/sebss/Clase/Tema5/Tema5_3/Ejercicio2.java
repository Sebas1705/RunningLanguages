package com.sebss.Clase.Tema5.Tema5_3;

public class Ejercicio2 {

    private static void println(String msg){
        String name=Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }
    
    private static void mensajes(){
        String[] mensajesS={
            "La vida es bella",
            "Oh no...",
            "Los pajaritos cantan",
            "Y molestan..."
        };
        for(int i=0;i<mensajesS.length;i++){
            println(mensajesS[i]);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                println("Se acabo!");
                return;
            }
        }
    }

    private void exec() throws InterruptedException{
        Thread t = new Thread(()->mensajes(),"Mensajes");
        t.start();

        for(int i=0;i<5;i++){
            t.join(1000);
            if(t.getState()==Thread.State.TERMINATED) break;
            else println("Todavía esperando...");
        }
        if(t.getState()!=Thread.State.TERMINATED){
            println("Cansado de esperar!");
            t.interrupt();
            t.join();
        }
        println("Por fin!");
    }

    public static void main(String[] args) throws InterruptedException{
        new Ejercicio2().exec();
    }
}
