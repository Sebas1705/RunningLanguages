package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EjemploJColorChooser extends JFrame{
    
    public static void main(String[] args) {
        new EjemploJColorChooser();
    }

    public EjemploJColorChooser(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJColorChooser");
        JButton b = new JButton("JColorChooser");
        b.setPreferredSize(new Dimension(300,100));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JColorChooser.showDialog(b, "JColorChooser", Color.BLACK);
            }
        });
        this.add(b);
        this.pack();
        this.setVisible(true);
    }
}
