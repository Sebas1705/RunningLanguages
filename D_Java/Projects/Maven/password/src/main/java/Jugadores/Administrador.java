package Jugadores;

import Exceptions.EJugadorNoValidoException;
import java.io.Serializable;

public class Administrador extends Jugador implements Serializable{
    
    //Variables:
    public static final String ADMIN_PASSWORD = "123";
    public static final int ADMIN_PUNTOS = 1000000;
    //End Variables.
    
    //Constructor:
    public Administrador(String nombre) throws EJugadorNoValidoException{
        super(nombre, ADMIN_PASSWORD);
        setPuntos(ADMIN_PUNTOS);
    }
    //End Constructor.
    
    //Métodos públicos:
    
    //End Métodos públicos.

    //Métodos privados:
    
    //End Métodos privados.

    //Gets:

    //End Gets.

    //Sets:
    
    //End Sets.
}
