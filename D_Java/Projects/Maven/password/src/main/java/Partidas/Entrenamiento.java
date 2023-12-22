package Partidas;

import Almacenes.Almacen_Palabras;
import Exceptions.EJugadorNoValidoException;
import Exceptions.EPalabraNoValidaException;
import Exceptions.EPartidaNoValidaException;
import Exceptions.ERoscoNoValidoException;
import Interfaz.PanelEntrenar;
import Jugadores.Jugador;
import Palabras.Palabra;
import static Partidas.Rosco.ABECEDARIO;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Entrenamiento implements Serializable{
    
    //Constantes:
    public static final int BENEFICIO_ESTANDAR = 5;
    public static final String INSTRUCIONES = "Bienvenido al modo entrenamiento!\n\nEste modo es sencillo asi que no te preocupes.\nSimplemente te iran apareciendo definiciones nuevas y tu tienes que ingresar las respuestas.\nTambién tienes opción a pedir ayudas.\nBuena suerte y a entrenar!";
    //End Constantes.
    
    //Variables:
    private int beneficio;
    private Rosco rosco;
    //End Variables.
    
    //Constructor:
    public Entrenamiento(int numLetras, int beneficio, Almacen_Palabras almacen) throws ERoscoNoValidoException, EPartidaNoValidaException, EPalabraNoValidaException{
        if(beneficio < 0) throw new EPartidaNoValidaException("El entrenamiento no puede proporcionar un beneficio negativo");
        this.beneficio = beneficio;
        Palabra[] palabras = new Palabra[numLetras];
        for(int i = 0; i < numLetras; i++){
            Palabra palabraActual = almacen.getPalabra(ABECEDARIO[i]);
            //No podemos crear un rosco con alguna palabra a null
            if(palabraActual == null) throw new ERoscoNoValidoException("El almacen proporcionado no contiene las suficientes palabras. Fallo producido en las palabras que comienzan con: " + ABECEDARIO[i]);
            palabras[i] = palabraActual.copiar();
        }
        this.rosco = new Rosco(numLetras, palabras);
    }
    //End Constructor.
    
    //Métodos públicos:
    public void entrenar(JDialog padre, Jugador jugador) throws EJugadorNoValidoException, EPartidaNoValidaException{
        PanelEntrenar panel = new PanelEntrenar(padre, true, this, jugador);
        panel.setTitle("Entrenamineto de " + jugador.getNombre());
        panel.setVisible(true);
    }
    //End Métodos públicos.
    
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:
    public int getBeneficio(){return this.beneficio;}
    public Rosco getRosco(){return this.rosco;}
    //End Gets.
    
    //Sets:
    public void setBeneficio(int beneficio){this.beneficio=beneficio;}
    public void setRosco(Rosco rosco){this.rosco=rosco;}
    //End Sets.
    
}
