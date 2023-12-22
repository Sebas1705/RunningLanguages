package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJTextArea extends JFrame{
    
    public EjemploJTextArea(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJTextArea");

        JPanel fondo = new JPanel();
        fondo.setPreferredSize(new Dimension(400,220));
        
        JTextArea txf = new JTextArea();
        txf.setPreferredSize(new Dimension(300,200));
        fondo.add(txf);

        this.add(fondo);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJTextArea();
    }
}
