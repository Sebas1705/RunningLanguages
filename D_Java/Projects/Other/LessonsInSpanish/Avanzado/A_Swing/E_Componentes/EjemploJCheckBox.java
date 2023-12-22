package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJCheckBox extends JFrame{
    
    public EjemploJCheckBox(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJCheckBox");
        
        JCheckBox btn = new JCheckBox("CheckBox");
        btn.setHorizontalAlignment(JCheckBox.CENTER);
        btn.setPreferredSize(new Dimension(300,100));
        this.add(btn);
        
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJCheckBox();
    }
}
