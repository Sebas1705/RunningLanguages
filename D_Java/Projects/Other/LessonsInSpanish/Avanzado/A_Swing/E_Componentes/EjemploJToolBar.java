package Avanzado.A_Swing.E_Componentes;

import java.awt.*;
import javax.swing.*;

public class EjemploJToolBar extends JFrame{
    
    public EjemploJToolBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setTitle("EjemploJToolBar");
        this.setSize(800,800);

        JTextArea ta = new JTextArea(); 
        JToolBar toolBar = new JToolBar("ToolBar");
        toolBar.setBackground(Color.BLACK);
        
        JButton b1 = new JButton("Rojo");
        b1.addActionListener(e -> ta.setBackground(Color.RED));
        JButton b2 = new JButton("Verde");
        b2.addActionListener(e -> ta.setBackground(Color.GREEN));
        JButton b3 = new JButton("Azul");
        b3.addActionListener(e -> ta.setBackground(Color.BLUE));

        toolBar.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        toolBar.add(b1);
        toolBar.add(b2);
        toolBar.add(b3);
        
        add(toolBar, BorderLayout.NORTH);
        add(ta, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJToolBar();
    }
}