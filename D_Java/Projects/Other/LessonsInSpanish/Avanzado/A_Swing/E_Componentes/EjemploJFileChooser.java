package Avanzado.A_Swing.E_Componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EjemploJFileChooser extends JFrame{
    
    public static void main(String[] args) {
        new EjemploJFileChooser();
    }
    
    public EjemploJFileChooser(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJFileChooser");
        JButton b = new JButton("JFileChooser");
        b.setPreferredSize(new Dimension(300,100));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFileChooser f = new JFileChooser();
                f.showOpenDialog(null);
            }
        });
        this.add(b);
        this.pack();
        this.setVisible(true);
    }

}
