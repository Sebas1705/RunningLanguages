package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;
import java.awt.*;

public class EjemploJComboBox extends JFrame{
    
    public static void main(String[] args) {
        new EjemploJComboBox();
    }
    
    public EjemploJComboBox() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("EjemploJComboBox");
        
        String[] list = {"objeto1", "objeto2", "objeto3", "objeto4", "objeto5"};
        JComboBox<String> comboBox = new JComboBox<String>(list);
        comboBox.setPreferredSize(new Dimension(300,100));

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }    
}
