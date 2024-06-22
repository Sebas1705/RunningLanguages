package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.CountDownLatch;

public class Ejercicio9 {
    
    private CountDownLatch latchD,latchB,latchG,latchE,latchH,latchC;

    private void println(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }

    private void p1(){
        try{
            println("A");
            latchD.countDown();
            latchB.await();
            println("B");
            latchE.countDown();
            latchH.countDown();
            latchC.await();
            println("C");
        }catch(InterruptedException e){e.printStackTrace();}
    }
    private void p2(){
        try{
            latchD.await();
            println("D");
            latchB.countDown();
            latchG.countDown();
            latchE.await();
            println("E");
            latchC.countDown();
        }catch(InterruptedException e){e.printStackTrace();}
    }
    private void p3(){
        try{
            println("F");
            latchD.countDown();
            latchG.await();
            println("G");
            latchH.await();
            println("H");
        }catch(InterruptedException e){e.printStackTrace();}
    }

    public void exec(){
        latchD = new CountDownLatch(2);
        latchB = new CountDownLatch(1);
        latchG = new CountDownLatch(1);
        latchE = new CountDownLatch(1);
        latchH = new CountDownLatch(1);
        latchC = new CountDownLatch(1);
        new Thread(()->p1(),"P1").start();
        new Thread(()->p2(),"P2").start();
        new Thread(()->p3(),"P3").start();
    }

    public static void main(String[] args) {
        new Ejercicio9().exec();
    }
}
