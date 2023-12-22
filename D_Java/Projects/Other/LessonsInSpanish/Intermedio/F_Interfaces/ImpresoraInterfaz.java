package Intermedio.F_Interfaces;

import javax.swing.JOptionPane;

public class ImpresoraInterfaz implements Impresora{

    @Override
    public void imprimirHola() {
        JOptionPane.showMessageDialog(null, "Hola buenas");
    }

    @Override
    public void imprimirAdios() {
        JOptionPane.showMessageDialog(null, "Hasta luego");
    }

    @Override
    public void imprimirAlgo(String algo) {
        JOptionPane.showMessageDialog(null, algo);
    }
    
}
