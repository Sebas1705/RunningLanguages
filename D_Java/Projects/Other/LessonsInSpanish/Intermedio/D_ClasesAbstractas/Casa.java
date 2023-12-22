package Intermedio.D_ClasesAbstractas;

public abstract class Casa {
    
    protected int metrosCuadrados, nHabitaciones;

    public Casa(int metrosCuadrados, int nHabitaciones) 
    {
        this.metrosCuadrados = metrosCuadrados;
        this.nHabitaciones = nHabitaciones;
    }

    public abstract void mostrarDatos(int i);
}