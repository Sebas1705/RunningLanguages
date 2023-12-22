package Avanzado.A_Swing.K_Spring;

import java.awt.*;

import javax.swing.*;

public class Ventana extends JFrame{

    JPanel p;
    JButton b1, b2, b3;
    
    public Ventana(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana");
        this.setSize(600,600);
        
        
        p = new JPanel();
        p.setBackground(Color.GRAY);
        SpringLayout layout = new SpringLayout();
        p.setLayout(layout);

        b1 = new JButton("b1");
        b2 = new JButton("b2");
        b3 = new JButton("b3");


        p.add(b1);
        p.add(b2);
        p.add(b3);

        //Muelles Laterales(flexibles):
        layout.putConstraint(SpringLayout.WEST, b1, Spring.constant(10, 100, 300), SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.WEST, b2, Spring.constant(10, 100, 300), SpringLayout.EAST, b1);
        layout.putConstraint(SpringLayout.WEST, b3, Spring.constant(10, 100, 300), SpringLayout.EAST, b2);
        layout.putConstraint(SpringLayout.EAST, p, Spring.constant(10, 100, 300), SpringLayout.EAST, b3);
        //Muelles superiores(rigidos):
        layout.putConstraint(SpringLayout.NORTH, b1, Spring.constant(10), SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, b2, Spring.constant(10), SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, b3, Spring.constant(10), SpringLayout.NORTH, p);


        add(p);
        this.setVisible(true);
        this.setResizable(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
