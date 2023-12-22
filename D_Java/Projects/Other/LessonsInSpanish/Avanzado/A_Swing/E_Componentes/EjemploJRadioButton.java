package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJRadioButton extends JFrame{
    
    public EjemploJRadioButton(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJRadioButton");
        
        JRadioButton button = new JRadioButton("RadioButton");
        button.setHorizontalAlignment(JRadioButton.CENTER);
        button.setPreferredSize(new Dimension(300,100));
        this.add(button);
        
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJRadioButton();
    }
}
