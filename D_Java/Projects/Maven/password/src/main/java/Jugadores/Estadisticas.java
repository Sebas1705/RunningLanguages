package Jugadores;

import java.io.Serializable;

public class Estadisticas implements Serializable{
    
    //Variables:
    private int partidas_jugadas;
    private int partidas_ganadas;
    private int partidas_empatadas;
    private int partidas_perdidas;
    private int puntosConseguidos;
    //End Variables.
    
    //Constructor:
    //Dejamos el sin argumentos.
    //End Constructor.
    
    //Métodos públicos:
    public String toString(String nombre, int puntos){
        return "+--------------------------------------+\n" + 
               "|Estadisticas de "+nombre+":\n"+
               "|Partidas ganadas: "+this.getPartidasGanadas()+"|\n"+
               "|Partidas perdidas: "+this.getPartidasPerdidas()+"|\n"+
               "|Partidas empatadas: "+this.getPartidasEmpatadas()+"|\n"+
               "|Partidas totales jugadas: "+this.getPartidasJugadas()+"|\n"+
               "|Puntos conseguidos: "+getPuntosConseguidos()+"|\n"+
               "|Puntos actuales: "+puntos+"|\n"+
               "+--------------------------------------+\n"+
               "\n";
    }
    //End Métodos públicos.
    
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:
    public int getPartidasJugadas(){return this.partidas_jugadas;}
    public int getPartidasGanadas(){return this.partidas_ganadas;}
    public int getPartidasEmpatadas(){return this.partidas_empatadas;}
    public int getPartidasPerdidas(){return this.partidas_perdidas;}
    public int getPuntosConseguidos(){return this.puntosConseguidos;}
    //End Gets.
    
    //Sets:
    public boolean setPartidasJugadas(int nuevoValor){
        //Devuelve true si se ha podido hacer correctamente y false si no
        if(nuevoValor >= 0){
            this.partidas_jugadas = nuevoValor;
            return true;
        }
        else return false;
    }
    public boolean setPartidasGanadas(int nuevoValor){
        //Devuelve true si se ha podido hacer correctamente y false si no
        if(nuevoValor >= 0){
            this.partidas_ganadas = nuevoValor;
            return true;
        }
        else return false;
    }
    public boolean setPartidasEmpatadas(int nuevoValor){
        //Devuelve true si se ha podido hacer correctamente y false si no
        if(nuevoValor >= 0){
            this.partidas_empatadas = nuevoValor;
            return true;
        }
        else return false;
    }
    public boolean setPartidasPerdidas(int nuevoValor){
        //Devuelve true si se ha podido hacer correctamente y false si no
        if(nuevoValor >= 0){
            this.partidas_perdidas = nuevoValor;
            return true;
        }
        else return false;
    }
    public boolean setPuntosConseguidos(int nuevoValor){
        //Devuelve true si se ha podido hacer correctamente y false si no
        if(nuevoValor >= 0){
            this.puntosConseguidos = nuevoValor;
            return true;
        }
        else return false;
    }
    //End Sets.
    
}
