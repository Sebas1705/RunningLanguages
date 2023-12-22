package Palabras;

import java.io.Serializable;

public class Definicion implements Serializable{
    
    //Variables:
    private String definicion;
    //End Variables.
    
    //Constructor:
    public Definicion(String def) {
        this.definicion = def;
    }
    //End Constructor.
    
    //Métodos públicos:
    
    //End Métodos públicos.
    @Override
    public String toString(){
        return definicion;
    }
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:
    public String getDefinicion(){return this.definicion;}
    //End Gets.
    
    //Sets:
    public void setDefinicion(String definicion){this.definicion = definicion;}
    //End Sets.
    
}
