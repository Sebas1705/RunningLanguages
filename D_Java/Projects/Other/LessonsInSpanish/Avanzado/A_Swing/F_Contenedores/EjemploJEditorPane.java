package Avanzado.A_Swing.F_Contenedores;

import java.awt.*;
import java.io.*;

import javax.swing.*;

public class EjemploJEditorPane extends JFrame{
    
    public EjemploJEditorPane() throws IOException{
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJEditorPane");
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        
        JEditorPane editor = new JEditorPane();
        editor.setContentType("text/html");
        editor.setEditable(false);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/sebss/Escritorio/Programacion/Web/PrimeraWEB/index.html")));
        String buf = null;
        while((buf  = br.readLine()) != null) sb.append(buf);
        editor.setText(sb.toString());
        
        JScrollPane js = new JScrollPane(editor);
        js.setPreferredSize(new Dimension(700,400));
        this.add(js, BorderLayout.CENTER);

        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        try {
            new EjemploJEditorPane();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
