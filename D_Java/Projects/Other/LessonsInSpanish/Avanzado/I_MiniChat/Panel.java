package Avanzado.I_MiniChat;

import javax.swing.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.*;

public class Panel extends JPanel{

    private JButton miboton;
    private JTextField campo1;
    private JTextArea area1;
    private String nombre;
    private JLabel texto;
    
    public Panel() throws Exception{
        Thread[] hilos = crearHilos();
        ejecutarHilos(hilos);
    }

    private void ejecutarHilos(Thread[] hilos) throws Exception{
        hilos[1].start();
        hilos[1].join();
        hilos[0].start();
    }

    private Thread[] crearHilos(){
        Thread[] hilos = new Thread[2];
        hilos[0] = new Thread(new Runnable() {
            public void run(){
                try {
                    
                    while(true){
                        ServerSocket server = new ServerSocket(100);
                        Socket miSocket = server.accept();
        
                        DataInputStream flujoIn = new DataInputStream(miSocket.getInputStream());
        
                        String mensaje = flujoIn.readUTF();
        
                        area1.append("-->"+mensaje+"\n");
        
                        miSocket.close();
                        server.close();
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        });
        hilos[1] = new Thread(new Runnable(){
            public void run(){

                nombre = JOptionPane.showInputDialog("Ingrese su nombre:");

                setLayout(new BorderLayout(0,10));
        
                JPanel global1 = new JPanel();
                global1.setLayout(new FlowLayout(FlowLayout.CENTER));
                global1.setPreferredSize(new Dimension(250, 300));
                JPanel cuadroTexto = new JPanel();
                texto = new JLabel(nombre+":");
                texto.setHorizontalAlignment(JLabel.CENTER);
                cuadroTexto.add(texto);
                global1.add(cuadroTexto);

                JPanel cuadroCampo = new JPanel();
                campo1 = new JTextField(10);
                campo1.addKeyListener(new KeyListener(){
                    public void keyTyped(KeyEvent e) {}
                    public void keyPressed(KeyEvent e) {if(e.getKeyCode() == 10) accionMiboton();}
                    public void keyReleased(KeyEvent e) {}
                });
                campo1.setText("");
                cuadroCampo.add(campo1);
                global1.add(cuadroCampo);

                JPanel cuadroBoton = new JPanel();
                miboton = new JButton("Enviar");
                
                miboton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        accionMiboton();
                    }
                });
                cuadroBoton.add(miboton);
                global1.add(cuadroBoton);
                global1.setPreferredSize(new Dimension(250,100));

                JPanel global2 = new JPanel();
                global2.setLayout(new BorderLayout(10,10));

                JPanel cuadroArea = new JPanel();
                area1 = new JTextArea(100,10);
                area1.setPreferredSize(new Dimension(360,400));
                area1.setEditable(false);
                
                JScrollPane marco = new JScrollPane(area1);
                marco.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                marco.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                marco.setPreferredSize(new Dimension(360,400));
                cuadroArea.add(marco, BorderLayout.CENTER);
                cuadroArea.setBackground(new Color(0, 0, 100));
                global2.add(cuadroArea);
                global2.setBackground(Color.CYAN);


                add(global2, BorderLayout.CENTER);
                add(global1, BorderLayout.SOUTH);

            }
        });
        return hilos;
    }

    private void accionMiboton(){
        try {
            Socket misocket = new Socket("192.168.56.1", 100);

            DataOutputStream flujoOut = new DataOutputStream(misocket.getOutputStream());

            if(!texto.getText().equals("")){
                flujoOut.writeUTF(nombre+": "+campo1.getText());
                System.out.println("Enviado mensaje: "+campo1.getText());
                campo1.setText("");
            }

            flujoOut.close();

            misocket.close();
        } catch (Exception e1) {
            System.out.println("Error: " + e1.getMessage());
        }
    }

}
