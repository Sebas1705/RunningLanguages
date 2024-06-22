package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.Exchanger;

public class Ejercicio8 {
    
    private Exchanger<Integer> proxyclient=new Exchanger<Integer>();
    private Exchanger<Integer> proxyserver=new Exchanger<Integer>();

    private void println(String msg){
        String name=Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }

    private void proxy() throws InterruptedException{
        int message=proxyclient.exchange(null);
        message+=1;
        proxyserver.exchange(message);
        message=proxyserver.exchange(null);
        proxyclient.exchange(message);
    }
    private void client() throws InterruptedException{
        int message=(int) (Math.random()*100+1);
        println("Client generate: " + message);
        proxyclient.exchange(message);
        message=proxyclient.exchange(null);
        println("ProxyResponse: "+message);
    }
    private void server() throws InterruptedException{
        int message=proxyserver.exchange(null);
        message+=1;
        proxyserver.exchange(message);
    }

    public void exec(){
        new Thread(()->{
            try {
                proxy();
            } catch (InterruptedException e) {e.printStackTrace();}
        },"Proxy").start();
        new Thread(()->{
            try {
                client();
            } catch (InterruptedException e) {e.printStackTrace();}
        },"Client").start();
        new Thread(()->{
            try {
                server();
            } catch (InterruptedException e) {e.printStackTrace();}
        },"Server").start();
    }

    public static void main(String[] args) {
        new Ejercicio8().exec();
    }
}
