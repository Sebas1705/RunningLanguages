package Avanzado.A_Swing.C_JPanel;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Ventana extends JFrame{
    
    public Ventana(){

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();
        int x = dm.width, y = dm.height;
        setBounds(x/4, y/4, x/2, y/2);


        add(new Panel(0, 0, x/2, y/2));


        setTitle("Ventana");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
