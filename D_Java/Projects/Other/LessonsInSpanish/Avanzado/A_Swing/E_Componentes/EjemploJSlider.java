package Avanzado.A_Swing.E_Componentes;

import java.awt.*;

import javax.swing.*; 

public class EjemploJSlider extends JFrame{
    public static void main(String[] args) {
        new EjemploJSlider();
    }

    public EjemploJSlider(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJSlider");

        JSlider mySlider = new JSlider(0, 100, 50);

        mySlider.setPreferredSize(new Dimension(350,200));
        mySlider.setPaintTicks(true);
        mySlider.setMinorTickSpacing(10);
        mySlider.setPaintTrack(true);
        mySlider.setMajorTickSpacing(25);
        mySlider.setPaintLabels(true);

        this.add(mySlider);
        this.pack();
        this.setVisible(true);
    }
}
