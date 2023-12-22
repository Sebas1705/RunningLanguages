package Básicos;

// import java.util.*; //Mala praxis
import java.util.Scanner;

// import javax.swing.JOptionPane;

public class I_Entrada {
    public static void main(String[] args) {
        
        String nombre;
        byte edad;
        char sexo;

        //Objeto de consola:
            // Inicializar el scanner(como objeto):
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce tu nombre:\n-> ");
            nombre = sc.nextLine();//Al introducir enter se envia.
            System.out.print("Introduce tu edad:\n-> ");
            edad = sc.nextByte();
            sc.nextLine();//Recomendable para reset del buffer.
            System.out.print("Introduce tu sexo(m o f):\n-> ");
            sexo = sc.nextLine().charAt(0);
            System.out.println("Buenas "+nombre+", tienes "+edad+" años y sexo "+sexo+".");
            sc.close();
        //End Objeto de consola.

        //Objeto de interfaz:
            // nombre = JOptionPane.showInputDialog(null, "Introsduzca el nombre:");
            // edad = (byte)Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la edad:"));
            // sexo = JOptionPane.showInputDialog(null, "Introduzca tu sexo(m o f):").charAt(0);
            // JOptionPane.showMessageDialog(null, "Buenas "+nombre+", tienes "+edad+" años y sexo "+sexo+".");
        //End Objeto de interfaz.
    }
    
}
