package Avanzado.A_Swing.G_Layouts;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    
    public static void main(String[] args) {
        new Ventana(3);
    }

    public Ventana(int option) {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();
        int x = dm.width, y = dm.height;
        setBounds(x/4, y/4, x/2, y/2);
        setMinimumSize(new Dimension(200,200));//Tamaño Minimo
        setBackground(SystemColor.window);

        JButton b1 = new JButton("b1");
        b1.setPreferredSize(new Dimension(200,50));//Tamaño preferido
        JButton b2 = new JButton("b2");
        b2.setPreferredSize(new Dimension(200,50));
        JButton b3 = new JButton("b3");
        b3.setPreferredSize(new Dimension(200,50));
        JButton b4 = new JButton("b4");
        b4.setPreferredSize(new Dimension(200,50));
        JButton b5 = new JButton("b5");
        b5.setPreferredSize(new Dimension(200,50));
        JButton b6 = new JButton("b6");
        b6.setPreferredSize(new Dimension(200,50));
        
        switch (option) {
            case 1:
                setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
                add(b1);
                add(b2);
                add(b3);
                add(b4);
                add(b5);
                add(b6);
                break;
            case 2:
                setLayout(new BorderLayout(50, 50));
                add(b1, BorderLayout.NORTH);
                add(b2, BorderLayout.EAST);
                add(b3, BorderLayout.WEST);
                add(b4, BorderLayout.SOUTH);
                add(b5, BorderLayout.CENTER);
                add(b6, BorderLayout.NORTH);
                break;
            case 3:
                setLayout(new GridLayout(2,3,50,50));
                add(b1);
                add(b2);
                add(b3);
                add(b4);
                add(b5);
                add(b6);
                break;
            default:
                break;
        }

        setTitle("Ventana");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();//Empaqueta al tamaño preferido de los componentes
    }
}
