package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio12 {
    
    /**
     * Implementar un programa concurrente similar al anterior con la diferencia de que el proceso Cliente hace
     * 10 peticiones, el proceso Proxy atendiendo esas 10 peticiones y se las redirige al proceso Servidor. El
     * proceso servidor también responde a 10 peticiones. La solución deberá implementarse con espera activa. 
    */

    private static final int N_MESSAGES = 10;
    private static volatile boolean proxyRequest=false,proxyResponse=false;
    private static volatile boolean serverRequest=false,serverResponse=false;
    private static volatile int messages[]=new int[N_MESSAGES];


    public static void proxy(){
        while(!proxyRequest);
        for(int i=0;i<N_MESSAGES;i++)
            messages[i]+=1;
        serverRequest=true;
        while(!serverResponse);
        proxyResponse=true;
    }
    public static void client(){
        for(int i=0;i<N_MESSAGES;i++)
            messages[i]=(int) (Math.random()*100+1);
        showMessages("Client");
        proxyRequest=true;
        while(!proxyResponse);
        showMessages("ProxyResponse");
    }
    public static void server(){
        while(!serverRequest);
        for(int i=0;i<N_MESSAGES;i++)
            messages[i]+=1;
        serverResponse=true;
    }
    private static void showMessages(String identifier){
        String s=identifier+" messages:";
        for(int i=0;i<N_MESSAGES;i++)
            s+=(i!=N_MESSAGES-1)?messages[i]+",":messages[i];
        println(s+"\n");
    }


    public static void main(String[] args) {
        createThread("proxy");
        createThread("client");
        createThread("server");
        startThreadsAndWait();
    }
}
