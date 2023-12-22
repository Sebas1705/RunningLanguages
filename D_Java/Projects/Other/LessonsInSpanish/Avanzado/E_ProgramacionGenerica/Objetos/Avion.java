package Avanzado.E_ProgramacionGenerica.Objetos;

public class Avion {

    private String modelo;
    private double velocidad;

    public Avion(String modelo, double velocidad) {
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    public double getVelocidad() {return velocidad;}
    @Override
    public String toString(){return "Avion: "+modelo+", velocidad: "+velocidad+" km/h";}

}
