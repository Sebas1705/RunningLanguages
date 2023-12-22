package Avanzado.A_Swing.F_Contenedores;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class EjemploJTextPane extends JFrame{
    
    public EjemploJTextPane() throws BadLocationException{
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJTextPane");
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        
        JTextPane pane = new JTextPane();  
        pane.setFont(new Font("Arial", Font.BOLD, 100));
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();  
        StyleConstants.setBold(attributeSet, false);  
  
        //Establecer el estilo antes de escribir.
        pane.setCharacterAttributes(attributeSet, true);  
        pane.setText("Welcome");  
  
        attributeSet = new SimpleAttributeSet();  
        StyleConstants.setItalic(attributeSet, true);  
        StyleConstants.setForeground(attributeSet, Color.red);  
        StyleConstants.setBackground(attributeSet, Color.blue);  
  
        Document doc = pane.getStyledDocument();  
        doc.insertString(doc.getLength(), "To Java ", attributeSet);  
  
        attributeSet = new SimpleAttributeSet();  
        doc.insertString(doc.getLength(), "World", attributeSet);  
  
        JScrollPane scrollPane = new JScrollPane(pane);  
        add(scrollPane, BorderLayout.CENTER);  
        

        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        try {
            new EjemploJTextPane();
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
