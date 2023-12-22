package Avanzado.A_Swing.F_Contenedores;

import javax.swing.*;
import java.awt.*;

public class EjemploJInternalFrame extends JFrame {
	public static void main(String[] args) {
		new EjemploJInternalFrame();
	}
	

	public EjemploJInternalFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("EjemploJInternalFrame");
        this.setSize(350,200);
		JDesktopPane dp = new JDesktopPane();
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add (new JLabel("Una etiqueta"));
		p.add (new JTextField(10));
		
		JInternalFrame internal = new JInternalFrame("Un Internal Frame");
		internal.add(p);
		internal.pack();
        internal.setVisible(true);

        dp.add(internal);
		this.add(dp);
		this.setVisible(true);
	}
}
