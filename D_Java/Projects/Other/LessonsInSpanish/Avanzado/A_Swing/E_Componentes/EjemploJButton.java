package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJButton extends JFrame{
    
    public EjemploJButton(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJButton");
        
        JButton btn = new JButton("Boton1");
        btn.setPreferredSize(new Dimension(300,100));
        this.add(btn);
        
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJButton();
    }
}
