package Avanzado.A_Swing.L_DisposicionLibre;

import java.awt.*;

import javax.swing.*;

public class Ventana extends JFrame{

    JPanel p;
    JButton b1, b2, b3;
    
    public Ventana(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana");
        this.setSize(600,600);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.RED);

        JButton b = new JButton("Boton");
        b.setBounds(250,250,100,100);
        p.add(b);

        add(p);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}

