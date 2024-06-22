package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio11 {
    
    /**
     * Implementar un programa concurrente formado por un proceso Servidor, un proceso Proxy y un proceso
     * Cliente.
     * El proceso Cliente genera un número aleatorio, se lo envía al Proxy y espera su respuesta. Cuando
     * la recibe, la imprime por pantalla y termina.
     * El proceso Proxy no hace nada hasta que recibe una petición. Cuando la recibe, el Proxy suma 1 al
     * número enviado por el cliente y hace una petición al servidor con ese número, esperando su
     * respuesta. Cuando el proceso Servidor reciba la petición, le suma 1 y se la envía de vuelta al proxy.
     * Cuando el proxy recibe la petición del servidor, se la reenvía al cliente.
     * La solución deberá implementarse con espera activa.
    */

    private static volatile boolean proxyRequest=false,proxyResponse=false;
    private static volatile boolean serverRequest=false,serverResponse=false;
    private static volatile int message=0;

    public static void proxy(){
        while(!proxyRequest);
        message+=1;
        serverRequest=true;
        while(!serverResponse);
        proxyResponse=true;
    }
    public static void client(){
        message=(int) (Math.random()*100+1);
        println("Client generate: " + message);
        proxyRequest=true;
        while(!proxyResponse);
        println("ProxyResponse: "+message);
    }
    public static void server(){
        while(!serverRequest);
        message+=1;
        serverResponse=true;
    }


    public static void main(String[] args) {
        createThread("proxy");
        createThread("client");
        createThread("server");
        startThreadsAndWait();
    }
}
