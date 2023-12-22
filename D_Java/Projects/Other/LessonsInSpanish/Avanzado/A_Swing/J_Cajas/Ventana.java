package Avanzado.A_Swing.J_Cajas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ventana extends JFrame{
    
    public Ventana(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana");
        this.setSize(350,150);
        this.setLayout(new BorderLayout(10,10));

        Box a1 = Box.createHorizontalBox();
        a1.add(new JLabel("Nombre:"));
        a1.add(Box.createHorizontalStrut(20));
        JTextField t1 = new JTextField(10);
        t1.setMaximumSize(t1.getPreferredSize());
        a1.add(t1);

        Box a2 = Box.createHorizontalBox();
        a2.add(new JLabel("Contraseña:"));
        a2.add(Box.createHorizontalStrut(20));
        JPasswordField t2 = new JPasswordField(10);
        t2.setMaximumSize(t2.getPreferredSize());
        a2.add(t2);;

        Box a3 = Box.createHorizontalBox();
        JButton b1 = new JButton("Enviar");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Datos: Nombre->"+t1.getText()+" y Contraseña->"+String.valueOf(t2.getPassword()));
            }
        });
        a3.add(b1);
        a3.add(Box.createGlue());
        JButton b2 = new JButton("Borrar");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    Thread.sleep(2000); 
                    t1.setText("");
                    t2.setText("");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
               
            }
        });
        a3.add(b2);

        Box a4 = Box.createVerticalBox();
        a4.add(a1); a4.add(a2); a4.add(a3);
        

        add(a4, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
