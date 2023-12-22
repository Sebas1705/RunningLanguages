package Avanzado.A_Swing.E_Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EjemploJPopupMenu extends JFrame implements MouseListener{

    JPopupMenu popup;

    public EjemploJPopupMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("EjemploJPopupMenu");
        this.setSize(300,300);
        
        popup = new JPopupMenu();
        
        JMenuItem loadItem = new JMenuItem("Button");
        JCheckBoxMenuItem saveItem = new JCheckBoxMenuItem("CheckBox");
        JRadioButtonMenuItem exitItem = new JRadioButtonMenuItem("RadioButton");
        
        popup.add(loadItem);
        popup.add(saveItem);
        popup.add(exitItem);

        addMouseListener(this);
    
        add(popup);
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJPopupMenu();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.isPopupTrigger()){
            popup.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.isPopupTrigger()){
            popup.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {} 
}