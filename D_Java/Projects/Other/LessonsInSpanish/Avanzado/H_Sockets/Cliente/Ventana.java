package Avanzado.H_Sockets.Cliente;

import javax.swing.*;

public class Ventana extends JFrame{
    
    Panel p;

    public Ventana(){
        
        setBounds(600,300,280,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new Panel();
        add(p);

        setTitle("Cliente");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
