package Avanzado.I_MiniChat;

import javax.swing.*;

public class Ventana extends JFrame{
    
    Panel p;

    public Ventana(){
        setBounds(600,300,400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            p = new Panel();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        add(p);


        setTitle("Cliente");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }

}
