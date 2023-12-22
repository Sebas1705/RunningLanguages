package Avanzado.B_Serializacion;

import java.io.*;

public class Casa implements Serializable{
    
    private double metrosCuadrados;
    private int nHabitaciones;

    public Casa(double metrosCuadrados, int nHabitaciones) {
        this.metrosCuadrados = metrosCuadrados;
        this.nHabitaciones = nHabitaciones;
    }

    public double getMetrosCuadrados(){return metrosCuadrados;}
    public int getNHabitaciones(){return nHabitaciones;}

    @Override
    public String toString(){return "Casa: " + metrosCuadrados + " m^2 y "+nHabitaciones+" habitaciones";}

    
}
