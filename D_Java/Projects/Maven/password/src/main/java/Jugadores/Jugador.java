package Jugadores;

import Exceptions.EJugadorNoValidoException;
import Partidas.Partida;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Jugador implements Serializable{
    
    //Constantes:
    public static final int PUNTOS_INICIALES = 100;
    //End Constantes.

    //Variables:
    private String nombre;
    private String clave;
    private int puntos;
    private ArrayList<Partida> partidasJugadas;
    private Estadisticas estadisticas;
    //End Variables.
    
    //Constructor:
    public Jugador(String nombre, String clave) throws EJugadorNoValidoException{
        if(nombre == null || "".equals(nombre) || clave == null || "".equals(clave)) throw new EJugadorNoValidoException("El nombre y la clave de los los jugadores debe ser no nulo y no vacio");
        this.setNombre(nombre);
        this.setClave(clave);
        this.setPuntos(PUNTOS_INICIALES);
        this.partidasJugadas = new ArrayList<>();
        this.estadisticas = new Estadisticas();
    }
    //End Constructor.

    //Métodos públicos:
    public String mostrarHistorial(){
        return StringEstadisticas() + StringPartidas();
    }
    public void añadirPartida(Partida p){
        partidasJugadas.add(p);
    }
    public boolean borrarPartida(Partida p){
        return partidasJugadas.remove(p);
    }
    public boolean has(String nombre, String contraseña){
        if(this.getNombre().equals(nombre) && this.getClave().equals(contraseña)){
            return true;
        }else return false;
    }
    public String[] devolverPartidasFechas(){
        String[] array = new String[partidasJugadas.size()];
        int counter = 0;
        for(Partida p : partidasJugadas){
            array[counter] = p.getFecha().toString();
            counter++;
        }
        return array;
    }
    public Partida devolverPartidaPorFecha(LocalDateTime fecha){
        for(Partida p : partidasJugadas){
            if(p.getFecha().equals(fecha)){
                return p;
            }
        }
        return null;
    }
    public Partida devolverPartidaPorStringFecha(String fecha){
        for(Partida p : partidasJugadas){
            if(p.getFecha().toString().equals(fecha)){
                return p;
            }
        }
        return null;
    }
    //End Métodos públicos.
    
    //Métodos privados:
    private String StringEstadisticas(){
        return getEstadisticas().toString(this.getNombre(),this.getPuntos());
    }
    private String StringPartidas(){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(Partida p : partidasJugadas){
            sb.append(
                      "+--------------------------------------+\n"+
                      "|Resumen partida nº "+counter+":\n"+
                      "|Fecha: "+p.getFecha()+"|\n"+
                      "|Jugador1: "+p.getJugador1().getNombre()+"|\n"+
                      "|Jugador2: "+p.getJugador2().getNombre()+"|\n"+
                      "|Rosco1: "+p.getRosco1().toString()+"|\n"+
                      "|Rosco2: "+p.getRosco2().toString()+"|\n"+
                      "+--------------------------------------+\n"+
                      "\n"
            );
            counter++;
        }
        return sb.toString();
    }
    //End Métodos privados.
    
    //Gets:
    public String getNombre(){return this.nombre;}
    public String getClave(){return this.clave;}
    public int getPuntos(){return this.puntos;}
    public Estadisticas getEstadisticas(){return this.estadisticas;}
    public ArrayList<Partida> getPartidasJugadas(){return this.partidasJugadas;}
    //End Gets.
    
    //Sets:
    public void setNombre(String nuevoValor) throws EJugadorNoValidoException{
        if(nuevoValor == null || nuevoValor == "") throw new EJugadorNoValidoException("El nombre de los jugadores debe ser no nulo y no vacio");
        this.nombre = nuevoValor;
    }
   public void setClave(String nuevoValor) throws EJugadorNoValidoException{
        if(nuevoValor == null || nuevoValor == "") throw new EJugadorNoValidoException("La clave de los jugadores debe ser no nula y no vacia");
        this.clave = nuevoValor;
    }
    public void setPuntos(int nuevoValor) throws EJugadorNoValidoException{
        //Devuelve false si se intenta introducir un numero negativo, sino true
        if(nuevoValor < 0) throw new EJugadorNoValidoException("Los puntos de los jugadores no puede ser negativos");
        this.puntos = nuevoValor;
        
    }
    public void setEstadisticas(Estadisticas estadisticas){this.estadisticas = estadisticas;}
    //End Sets.
    
}