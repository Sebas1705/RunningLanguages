package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;
import java.awt.*;

public class EjemploJList extends JFrame{
    
    public EjemploJList(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJList");
        this.setLocationRelativeTo(null);

        String[] things = {
            "Box", "PC", "Motherboard", "GPU", "CPU", "RAM", "Memory"
        };
        JList<String> list = new JList<String>(things);
        list.setPreferredSize(new Dimension(300,150));
        this.add(list);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJList();
    }
}
