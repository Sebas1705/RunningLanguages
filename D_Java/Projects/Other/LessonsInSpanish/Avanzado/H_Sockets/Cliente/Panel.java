package Avanzado.H_Sockets.Cliente;

import javax.swing.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.net.Socket;
import java.awt.*;

public class Panel extends JPanel{

    private JButton miboton;
    private JTextField campo1;
    
    public Panel(){
        setLayout(new GridLayout(3,1,10,10));
        
        JPanel cuadroTexto = new JPanel();
        JLabel texto = new JLabel("Cliente");
        texto.setHorizontalAlignment(JLabel.CENTER);
        cuadroTexto.add(texto);
        add(cuadroTexto);

        JPanel cuadroCampo = new JPanel();
        campo1 = new JTextField(10);
        cuadroCampo.add(campo1);
        add(cuadroCampo);

        JPanel cuadroBoton = new JPanel();
        miboton = new JButton("Enviar");
        miboton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Socket misocket = new Socket("192.168.56.1", 9999);

                    DataOutputStream flujoOut = new DataOutputStream(misocket.getOutputStream());

                    flujoOut.writeUTF(campo1.getText());

                    flujoOut.close();

                    misocket.close();
                } catch (Exception e1) {
                    System.out.println("Error: " + e1.getMessage());
                }
            }
        });
        cuadroBoton.add(miboton);
        add(cuadroBoton);
    }
}
