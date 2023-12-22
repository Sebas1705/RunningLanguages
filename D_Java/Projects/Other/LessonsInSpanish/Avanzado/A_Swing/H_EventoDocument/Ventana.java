package Avanzado.A_Swing.H_EventoDocument;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

public class Ventana extends JFrame{
    
    public static void main(String[] args) {
        new Ventana();
    }

    public Ventana() {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();
        int x = dm.width, y = dm.height;
        setBounds(x/4, y/4, x/2, y/2);
        setMinimumSize(new Dimension(200,200));//Tamaño Minimo
        setBackground(SystemColor.window);
        setLayout(new FlowLayout());

        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(300, 50));
        tf.getDocument().addDocumentListener(new DocumentListener(){
            public void insertUpdate(DocumentEvent e) {System.out.println("Insertastes texto");}
            public void removeUpdate(DocumentEvent e) {System.out.println("Eliminaste texto");}
            public void changedUpdate(DocumentEvent e) {System.out.println("Cambiastes texto");}
        });
        add(tf);

        setTitle("Ventana");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
