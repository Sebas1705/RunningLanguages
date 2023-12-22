package Avanzado.F_Comparator;

public class Casa{
    
    private double metrosCuadrados;
    private int nHabitaciones;

    public Casa(double metrosCuadrados, int nHabitaciones) {
        this.metrosCuadrados = metrosCuadrados;
        this.nHabitaciones = nHabitaciones;
    }

    public double getMetrosCuadrados(){return this.metrosCuadrados;}
    @Override
    public String toString(){return "Casa: " + metrosCuadrados + " m^2 y "+nHabitaciones+" habitaciones";}

}
