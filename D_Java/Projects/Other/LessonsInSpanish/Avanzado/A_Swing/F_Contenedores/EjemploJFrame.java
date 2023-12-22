package Avanzado.A_Swing.F_Contenedores;

import javax.swing.JFrame;

public class EjemploJFrame extends JFrame {
    
    public EjemploJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("EjemploJFrame");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJFrame();
    }
}