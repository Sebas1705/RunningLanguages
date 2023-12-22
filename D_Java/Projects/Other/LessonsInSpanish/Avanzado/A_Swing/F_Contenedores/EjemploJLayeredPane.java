package Avanzado.A_Swing.F_Contenedores;

import java.awt.*;
import javax.swing.*;

public class EjemploJLayeredPane extends JFrame{
    
    public static void main(String[] args) {
        new EjemploJLayeredPane();
    }
    public EjemploJLayeredPane(){
        this.setTitle("EjemploJLayeredPane");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400,400));
        this.setLayout(null);
        this.setVisible(true);
        JLabel l1 = new JLabel();
        l1.setOpaque(true);
        l1.setBackground(Color.RED);
        l1.setBounds(50, 50, 200, 200);
        JLabel l2 = new JLabel();
        l2.setOpaque(true);
        l2.setBackground(Color.GREEN);
        l2.setBounds(100, 100, 200, 200);
        JLabel l3 = new JLabel();
        l3.setOpaque(true);
        l3.setBackground(Color.BLUE);
        l3.setBounds(150, 150, 200, 200);
        JLayeredPane pane = new JLayeredPane();
        //DEFAULT_LAYER<<PALETTE_LAYER<<MODAL_LAYER<<POPUP_LAYER<<DRAG_LAYER//
        pane.setBounds(0, 0, 500, 500);
        pane.add(l1, JLayeredPane.DEFAULT_LAYER);
        pane.add(l2, JLayeredPane.MODAL_LAYER);
        pane.add(l3, JLayeredPane.DRAG_LAYER);
        this.add(pane);
    }
}
