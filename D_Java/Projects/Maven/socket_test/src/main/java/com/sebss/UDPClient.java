package com.sebss;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    
    public static void main(String args[]) throws Exception {
        //Creamos datagrama de salida con el mensaje
        InetAddress dirIP = InetAddress.getByName("212.128.3.86");
        String sentence = "47469286T Sebastián Ramiro Entrerrios García";
        byte[] outBuff = sentence.getBytes();
        DatagramPacket outPac = new DatagramPacket(outBuff,outBuff.length,dirIP,9506);
        //Creamos el socket y enviamos el datagrama
        DatagramSocket socket= new DatagramSocket();
        socket.send(outPac);

        //Recibimos un datagrama
        byte[] inputBuff = new byte[1024];
        DatagramPacket inPac = new DatagramPacket(inputBuff, inputBuff.length);
        socket.receive(inPac);
        socket.close();

        String newSentence = new String(inPac.getData());
        System.out.println("DEL SERVIDOR:" + newSentence);
    } 
}
