package Ayudas;

import Exceptions.EAyudaNoValidaException;
import Palabras.Palabra;
import java.io.Serializable;

public abstract class Pista extends Ayuda implements Serializable{
    
    //Constantes:
    public static final int PRECIO_ESTANDAR = 5;
    //End Constantes.
    
    //Variables:
    
    //End Variables.
    
    //Constructor:
    public Pista(int precio, Palabra palabra) throws EAyudaNoValidaException{
        super(precio, palabra);
    }
    //End Constructor.
    
    //Metodos:
    
    //End Metodos.

    //Gets:
    
    //End Gets.

    //Sets:
    
    //End Sets.
    
}
