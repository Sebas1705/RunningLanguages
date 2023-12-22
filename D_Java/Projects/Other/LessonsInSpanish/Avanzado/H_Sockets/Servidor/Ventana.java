package Avanzado.H_Sockets.Servidor;

import java.io.*;
import java.net.*;

import javax.swing.*;

public class Ventana extends JFrame implements Runnable{
    
    JTextArea area1;

    public Ventana(){
        
        setBounds(600,300,280,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area1 = new JTextArea();
        add(area1);

        setTitle("Servidor");
        setResizable(false);
        setVisible(true);

        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    @Override
    public void run() {
        // System.out.println("Estoy a la escucha");

        try {
            try (ServerSocket server = new ServerSocket(9999)) {
                while(true){
                    Socket miSocket = server.accept();

                    DataInputStream flujoIn = new DataInputStream(miSocket.getInputStream());

                    String mensaje = flujoIn.readUTF();

                    try{
                        int a = Integer.parseInt(mensaje);
                        area1.append(String.valueOf(a*5));
                    }catch(Exception e){
                        area1.append(mensaje+"\n");
                    }
                    
                    miSocket.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
