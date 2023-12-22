package Ayudas;

import Exceptions.EAyudaNoValidaException;
import Palabras.Palabra;
import java.io.Serializable;

public abstract class Ayuda implements Serializable{
    
    //Variables:
    private int precio;  
    private Palabra palabra;
    //End Variables.
    
    //Constructor:
    public Ayuda(int precio, Palabra palabra) throws EAyudaNoValidaException{
        this.precio = precio;
        this.palabra = palabra;
        //Solo podemos usar una ayuda por palabra
        if(!this.palabra.setAyuda(this)) throw new EAyudaNoValidaException("Ya ha utilizado una ayuda para esta palabra, no puede usar mas");
    }
    //End Constructor.
    
    //Métodos públicos:
    public abstract String mostrar_info();
    //End Métodos públicos.
    
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:
    public int getPrecio(){return precio;}
    public Palabra getPalabraAyuda(){return palabra;}
    //End Gets.

    //Sets:
    public boolean setPrecio(int nuevoValor){
        if(nuevoValor >= 0) {
            precio = nuevoValor;
            return true;
        }
        else return false;
    }
    //End Sets.
    
}
