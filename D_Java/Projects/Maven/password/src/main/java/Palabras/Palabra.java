package Palabras;

import Ayudas.Ayuda;
import Exceptions.EPalabraNoValidaException;
import java.io.Serializable;

public class Palabra implements Serializable{
    
    //Variables:
    private char inicial;
    private StringBuilder palabra;
    private boolean acertada;
    private boolean fallada;
    private boolean aplazada;
    private Ayuda ayuda;
    private Definicion def1;
    private Definicion def2;
    //End Variables.
    
    //Constructor:
    public Palabra(char inicial, String palabra, Definicion def1, Definicion def2) throws EPalabraNoValidaException{
        if(inicial != palabra.toUpperCase().charAt(0) && inicial != palabra.toLowerCase().charAt(0)) throw new EPalabraNoValidaException("La inicial no concuerda con la palabra");
        if(palabra == "" ||palabra == null) throw new EPalabraNoValidaException("La palabra no puede ser nula ni vacía");
        if(def1 == null) throw new EPalabraNoValidaException("La primera definicion no puede ser nula");
        this.inicial = inicial;
        this.palabra = new StringBuilder(palabra);
        this.def1 = def1;
        this.def2 = def2;
    }
    public Palabra(char inicial, String palabra, Definicion def1) throws EPalabraNoValidaException{
        this(inicial, palabra, def1, null);
    }
    public Palabra(Palabra otra) throws EPalabraNoValidaException{
        this(otra.getInicial(), otra.getPalabra().toString(), otra.getDef1(), otra.getDef2());
    }
    //End Constructor.

    //Métodos públicos:
    public Palabra copiar() throws EPalabraNoValidaException{
        return new Palabra(this);
    }
    @Override
    public String toString(){
        return "+---------------------+\n"+
               "|Palabra: "+getPalabra()+"|\n"+
               "|Inicial: "+getInicial()+"|\n"+
               "|Definición 1: "+getDef1()+"|\n"+
               "|Definición 2: "+getDef2()+"|\n"+
               "+---------------------+\n";
    }
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Palabra otra = (Palabra) o;
        return (palabra.toString().equalsIgnoreCase(otra.getPalabra().toString()));
    }
    public boolean borrarDefinicion(Definicion d){
        //Si hay una sola definicion siempre sera la primera, ademas siempre debe haber una definicion
        if(d.equals(def1) && def2 != null){
            def1 = def2;
            def2 = null;
            return true;
        }
        else if(d.equals(def2)){
            def2 = null;
            return true;
        }
        else return false;
    }
    public boolean cambiarDefinicion(Definicion d) {
        //Devolvemos false si la defincion era igual a la que ya teniamos como principal
        boolean retorno = true;
        if(d.equals(def1)) retorno = false;
        //Si nos pasan la definicion secundaria, ponemos esta como principal y la actual principal como secundaria
        if(d.equals(def2)) def2 = def1;
        //Si es distinta de la definicion secundaria, simplemente cambiamos la definicion principal
        def1 = d;
        return retorno;
    }
    //End Métodos públicos.
    
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:
    public char getInicial(){return this.inicial;}
    public StringBuilder getPalabra(){return this.palabra;}
    public boolean getAcertada(){return this.acertada;}
    public boolean getFallada(){return this.fallada;}
    public boolean getAplazada(){return this.aplazada;}
    public Ayuda getAyuda(){return this.ayuda;}
    public Definicion getDef1(){return this.def1;}
    public Definicion getDef2(){return this.def2;}
    //End Gets.
    
    //Sets:
    public void setInicial(char inicial){this.inicial=inicial;}
    public void setPalabra(StringBuilder palabra){this.palabra=palabra;}
    public void setAcertada(boolean acertada){this.acertada=acertada;}
    public void setFallada(boolean fallada){this.fallada=fallada;}
    public void setAplazada(boolean aplazada){this.aplazada=aplazada;}
    public boolean setAyuda(Ayuda nuevoValor){
        //Cada palabra solo puede tener una ayuda, asi que solo cambiaremos esta una vez
        //Devolvemos true si se puede cambiar y false si no
        if(ayuda == null){
            ayuda = nuevoValor;
            return true;
        }
        return false;
    }
    public void setDef1(Definicion def1){this.def1=def1;}
    public void setDef2(Definicion def2){this.def2=def2;}
    //End Sets.
    
}
