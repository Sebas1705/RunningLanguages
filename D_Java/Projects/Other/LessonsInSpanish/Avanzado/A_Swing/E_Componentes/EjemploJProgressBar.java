package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;
import java.awt.*;


public class EjemploJProgressBar extends JFrame {
    public static void main(String[] args) {
        new EjemploJProgressBar();
    }


    public EjemploJProgressBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("EjemploJProgressBar");
        this.setLayout(null);
        this.setSize(460,120);
        this.setVisible(true);
        
        JProgressBar pb1 = new JProgressBar(0, 500);
        pb1.setValue(50);
        pb1.setBounds(10, 10, 420, 50);
        pb1.setStringPainted(true);
        pb1.setFont(new Font("MV Boli", Font.BOLD, 25));
        pb1.setForeground(Color.RED);
        pb1.setBackground(Color.BLACK);

        this.add(pb1);
        
    } 

    
    
}