package Avanzado.G_Threads.A_EjemploSleep;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

    public static void main(String[] args) {
        new Ventana();    
    }
    
    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);

        setBounds(600,300,400,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego();
			}
			
		});
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego (){
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			for (int i=1; i<=3000; i++){
				
				pelota.mueve_pelota(lamina.getBounds());
				
				lamina.paint(lamina.getGraphics());
				
                try {
                    Thread.sleep(4);
                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
			}
			
		
		
	}
	
	private LaminaPelota lamina;

    private class LaminaPelota extends JPanel{
        
        private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

        public void add(Pelota b){
		
            pelotas.add(b);
        }
        
        public void paintComponent(Graphics g){
            
            super.paintComponent(g);
            
            Graphics2D g2=(Graphics2D)g;
            
            for(Pelota b: pelotas){
                
                g2.fill(b.getShape());
            }
            
        }
    }
}
