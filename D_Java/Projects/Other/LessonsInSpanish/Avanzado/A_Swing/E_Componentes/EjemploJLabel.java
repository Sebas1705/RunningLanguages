package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJLabel extends JFrame{
    
    public EjemploJLabel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJLabel");
        
        JLabel label = new JLabel("Hola Mundo");
        label.setPreferredSize(new Dimension(300,100));
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label);
        
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJLabel();
    }
}
