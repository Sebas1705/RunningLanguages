package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;
import java.awt.*;

public class EjemploJScrollBar extends JFrame{
    
    public static void main(String[] args) {
        new EjemploJScrollBar();
    }

    public EjemploJScrollBar() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJScrollBar");
        this.setResizable(false);


        
        JScrollBar scroll = new JScrollBar(JScrollBar.HORIZONTAL, 100,0,0,255);
        scroll.setPreferredSize(new Dimension(300,20));




        this.add(scroll);
        this.pack();
        this.setVisible(true);
    }
}
