package Avanzado.A_Swing.F_Contenedores;

import java.awt.Color;
import javax.swing.*;

public class EjemploJPanel extends JFrame{
    
    public EjemploJPanel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJPanel");
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setBounds(100,100,300,300);
        this.add(panel);
    }

    public static void main(String[] args) {
        new EjemploJPanel();
    }
}
