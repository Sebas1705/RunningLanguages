package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;
import java.awt.*;

public class EjemploJMenuBar extends JFrame{

    public EjemploJMenuBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJMenuBar");
        this.setSize(300,100);
        JMenuBar menubar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        //File menu:
        JMenuItem loadItem = new JMenuItem("Button");
        JCheckBoxMenuItem saveItem = new JCheckBoxMenuItem("CheckBox");
        JRadioButtonMenuItem exitItem = new JRadioButtonMenuItem("RadioButton");
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        //--------------------
        menubar.add(fileMenu);
        this.setJMenuBar(menubar);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJMenuBar();
    }
}
