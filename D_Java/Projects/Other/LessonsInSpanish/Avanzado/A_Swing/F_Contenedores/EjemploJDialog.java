package Avanzado.A_Swing.F_Contenedores;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class EjemploJDialog extends JFrame{
    public static void main(String[] args) {
        new EjemploJDialog();
    }
	public EjemploJDialog(){
		this.setTitle("Ventana principal");
        this.setLocationRelativeTo(null);
		JButton boton = new JButton("Abre secundaria");
        boton.setPreferredSize(new Dimension(300,100));
		this.add(boton);
		this.pack();
		JDialog vS = new JDialog(this,"Ventana secundaria");
        vS.setPreferredSize(new Dimension(300,100));
        vS.setLocationRelativeTo(null);
		JLabel etiqueta = new JLabel("Hola");
		vS.getContentPane().add(etiqueta);
		vS.pack();
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){vS.setVisible(true);}});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	
}
