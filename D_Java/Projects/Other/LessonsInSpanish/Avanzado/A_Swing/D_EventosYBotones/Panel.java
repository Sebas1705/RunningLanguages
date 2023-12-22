package Avanzado.A_Swing.D_EventosYBotones;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener, FocusListener{
    
    int width, height;
    static String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    Toolkit tk = Toolkit.getDefaultToolkit();

    //Componentes:
        JButton button1, button2, button3, button4, button5, button6;
    //End Componentes.
    
    public Panel(int x, int y, int width, int height){
        setBounds(x, y, width, height);
        setVisible(true);
        setBackground(SystemColor.window);

        button1 = new JButton("Azul");
        button1.addFocusListener(this);
        button1.addActionListener(this);//Añadir el receptor de evento del componente.
        button1.setFocusable(true);//Quitar la seleccion pasada, o sea que no se quede marcado.
        add(button1);

        button2 = new JButton("Rojo");
        button2.addActionListener(this);
        button2.setFocusable(true);
        add(button2);

        button3 = new JButton("Amarillo");
        button3.addActionListener(this);
        button3.setFocusable(false); 
        add(button3);
        
        button4 = new JButton("Cyan");
        button4.addActionListener(this); //Forma implementada
        button4.setFocusable(false);
        add(button4);

        button5 = new JButton("Magenta");
        button5.addActionListener(new ActionListener() {//Forma extendida
            public void actionPerformed(ActionEvent e){
                setBackground(Color.MAGENTA);
            }
        });
        button5.setFocusable(false);
        add(button5);

        button6 = new JButton("Pink");
        button6.addActionListener(e->setBackground(Color.PINK));//Forma lamda
        button6.setFocusable(false);
        add(button6);

        this.width = width;
        this.height = height;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == button1) setBackground(Color.BLUE);
        else if(o == button2) setBackground(Color.RED);
        else if(o == button3) setBackground(Color.YELLOW);
        else setBackground(Color.CYAN); 
    }

    public void focusGained(FocusEvent e) {   
        System.out.println("Foco ganado button1");
    }

    public void focusLost(FocusEvent e) {
        System.out.println("Foco perdido button1"); 
    }
}
