package Ayudas;

import Exceptions.EAyudaNoValidaException;
import Palabras.Palabra;
import java.io.Serializable;

public class Compra extends Ayuda implements Serializable{
    //Constantes:
    public static final int PRECIO_ESTANDAR = 20;
    //End Constantes.
    
    //Variables:
    
    //End Variables.
    
    //Constructor:
    public Compra(int precio, Palabra palabra) throws EAyudaNoValidaException{
        super(precio, palabra);
    }
    //End Constructor.
    
    //Metodos:
    @Override
    public String mostrar_info() {
        return getPalabraAyuda().getPalabra().toString();
    }
    //End Metodos.

    //Gets:
    
    //End Gets.

    //Sets:
    
    //End Sets.
    
}
