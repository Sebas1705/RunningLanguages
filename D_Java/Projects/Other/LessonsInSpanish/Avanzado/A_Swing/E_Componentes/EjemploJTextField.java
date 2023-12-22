package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJTextField extends JFrame{
    
    public EjemploJTextField(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJTextField");

        JPanel fondo = new JPanel();
        fondo.setPreferredSize(new Dimension(400,120));
        
        JTextField txf = new JTextField();
        txf.setPreferredSize(new Dimension(300,100));
        fondo.add(txf);

        this.add(fondo);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJTextField();
    }
}
