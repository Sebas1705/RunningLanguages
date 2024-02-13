package com.sebss;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class TCPCliente {

    public static void main(String argv[]) throws Exception{
        
        //Configuramos el flujo de salida para enviar el texto al servidor
        Socket socket = new Socket("212.128.3.86", 6789);
        DataOutputStream streamToServer = new DataOutputStream(socket.getOutputStream());
        //Enviamos el servidor
        String sentence = "SebasEntrerrioGarcia47469286";
        streamToServer.writeBytes(sentence);
        //Esperamos respuesta
        int read = socket.getInputStream().read();
        FileOutputStream fout = new FileOutputStream("text.pdf");

        while(read!=-1){
            fout.write(read);
            read = socket.getInputStream().read();
        }
        //Cerramos y mostramos resultado
        fout.close();
        socket.close();
    }
} 
