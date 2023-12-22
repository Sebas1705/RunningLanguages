package Avanzado.A_Swing.D_EventosYBotones;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class Ventana extends JFrame{
    
    public Ventana(){

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();
        int x = dm.width, y = dm.height;
        setBounds(x/4, y/4, x/2, y/2);


        add(new Panel(0, 0, x/2, y/2));


        setTitle("Ventana");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addWindowListener(new WindowListener(){
            public void windowOpened(WindowEvent e) {System.out.println("Ventana abierta");}
            public void windowClosing(WindowEvent e) {System.out.println("Ventana cerrando");}
            public void windowClosed(WindowEvent e) {System.out.println("Ventana cerrada");}
            public void windowIconified(WindowEvent e) {System.out.println("Ventana minimizada");}
            public void windowDeiconified(WindowEvent e) {System.out.println("Ventana desminimizada");}
            public void windowActivated(WindowEvent e) {System.out.println("Ventana activada");}
            public void windowDeactivated(WindowEvent e) {System.out.println("Ventana desactivada");}
        });

        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                System.out.println("La ventana cambio de estado: "+e.getNewState());
            }
        });

        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {System.out.println("Presionado: "+e.getKeyCode()+" "+e.getKeyChar());}
            public void keyReleased(KeyEvent e) {System.out.println("Soltado: "+e.getKeyCode()+" "+e.getKeyChar());}
            public void keyTyped(KeyEvent e) {System.out.println("Tapeado: "+e.getKeyCode()+" "+e.getKeyChar());}
        });

        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {System.out.println("Raton Clikado");}
            public void mousePressed(MouseEvent e) {System.out.println("Raton Presionado");}
            public void mouseReleased(MouseEvent e) {System.out.println("Raton Soltado");}
            public void mouseEntered(MouseEvent e) {System.out.println("Raton Entrado");}
            public void mouseExited(MouseEvent e) {System.out.println("Raton Salido");}
        });
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
