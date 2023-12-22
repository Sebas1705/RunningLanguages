package Avanzado.A_Swing.F_Contenedores;
import java.awt.*;
import javax.swing.*;

public class EjemploJScrollPane extends JFrame{
    
    public static void main(String[] args) {
        new EjemploJScrollPane();
    }

    public EjemploJScrollPane() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("EjemploJScrollPane");
        this.setLayout(new FlowLayout());
        
        JScrollPane pane = new JScrollPane();
        pane.setPreferredSize(new Dimension(300, 100));
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
        this.add(pane);
        this.pack();
        this.setVisible(true);
    }
}
