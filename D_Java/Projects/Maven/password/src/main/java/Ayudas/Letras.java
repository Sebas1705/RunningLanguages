package Ayudas;

import Exceptions.EAyudaNoValidaException;
import Palabras.Palabra;
import java.io.Serializable;

public class Letras extends Pista implements Serializable{
    
    //Constantes:
    private static final double PORCENTAJE_MOSTRADO = 0.33;
    public static final char SIMBOLO_OCULTO = '*';
    //End Constantes.
    
    //Variables:
    
    //End Variables.
    
    //Constructor:
    public Letras(int precio, Palabra palabra) throws EAyudaNoValidaException{
        super(precio, palabra);
    }
    //End Constructor.
    
    //Metodos:
    @Override
    public String mostrar_info() {
        StringBuilder resultado = new StringBuilder(getPalabraAyuda().getPalabra());
        //No contamos la primera letra, ya que esa siempre se conoce
        int numMostradas = (int)(PORCENTAJE_MOSTRADO * resultado.length());
        while(numMostradas > 0){
            //No incluimos la primera letra
            int posicionMostrada = (int)(Math.random() * (resultado.length()-1)) + 1;
            //Si ya esta marcada, simplemente repetimos el proceso hasta que la posicion no este marcada
            if(resultado.charAt(posicionMostrada) != SIMBOLO_OCULTO){
                resultado.setCharAt(posicionMostrada, SIMBOLO_OCULTO);
                numMostradas--;
            }
        }
        //Cambiamos las marcas por la letra que debemos mostrar y las que no por la marca
        //La primera siempre se muestra
        for(int i = 1; i < resultado.length(); i++){
            if( resultado.charAt(i) == SIMBOLO_OCULTO) resultado.setCharAt(i, getPalabraAyuda().getPalabra().charAt(i));
            else resultado.setCharAt(i, SIMBOLO_OCULTO);
        }
        return resultado.toString();
    }
    //End Metodos.
    
    //Gets:
    
    //End Gets.

    //Sets:
    
    //End Sets.

}
