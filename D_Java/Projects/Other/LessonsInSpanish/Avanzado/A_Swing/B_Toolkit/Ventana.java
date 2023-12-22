package Avanzado.A_Swing.B_Toolkit;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    public Ventana(){
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        int x = screenSize.width/2, y = screenSize.height/2;

        setBounds(x-x/2, y-y/2, x, y);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana");

        setIconImage(tk.getImage("Avanzado/A_Swing/B_Toolkit/img/foto1.jpeg"));

    }
    
    public static void main(String[] args) {
        new Ventana();
    }
}
