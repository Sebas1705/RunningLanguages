package Avanzado.A_Swing.A_JFrame;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MiVentana extends JFrame{
    
    public MiVentana() {
        setSize(500,500);//Establece las dimensiones de la Frame
        setLocation(400,400);//Establece la localizacion de la Frame
        //setBounds(400,400,500,500); //Cumple la funcion de las dos anteriores. setBounds(x,y,anchoX,anchoY);
        setVisible(true);//Le doy la propiedad de poderse ver
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Determina el modo de cerrar dandole a la x
        /**
         * Lista de opciones de salida:
         * EXIT_ON_CLOSE
         * DO_NOTING_ON_CLOSE
         * HIDE_ON_CLOSE
         * DISPOSE_ON_CLOSE
         */
        setIconImage(new ImageIcon("Avanzado/A_Swing/A_JFrame/img/foto1.jpeg").getImage());//Establece la imagen del icono.
        setTitle("MiVentana");//Establece el titulo;           
        setResizable(false);//Establece si se puede cambiar el tamaño con el raton
        setExtendedState(Frame.NORMAL);//Determina el estado del aumentar a pantalla completa y su forma inicial.
        /**
         * Lista de opciones de ExtendedState:
         * NORMAL
         * MAXIMIZED_BOTH
         * MAXIMIZED_VERT
         * MAXIMIZED_HORIZ
         * ICONIFIED
         */    
        
    }


    public static void main(String[] args) {
        new MiVentana();
    }
}
