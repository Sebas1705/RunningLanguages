package Intermedio.D_ClasesAbstractas;

public class Apartamento extends Casa{

    private boolean tieneAscensor, esDuplex;
    private int planta;

    public Apartamento(int metrosCuadrados, int nHabitaciones, int planta, boolean tieneAscensor, boolean esDuplex){
        super(metrosCuadrados, nHabitaciones);
        this.planta = planta;
        this.tieneAscensor = tieneAscensor;
        this.esDuplex = esDuplex;
    }

    @Override
    public void mostrarDatos(int i) {
        StringBuilder sb = new StringBuilder("-->> Nº"+i+": Apartamento\n");
        sb.append("|-Metros cuadrados: "+metrosCuadrados+"\n");
        sb.append("|-Numero Habitaciones: "+nHabitaciones+"\n");
        sb.append("|-Planta: "+planta+"\n");
        sb.append("|-Extras: ");
        if(tieneAscensor && esDuplex) sb.append("Ascensor y Duplex\n");
        else if(tieneAscensor && !esDuplex) sb.append("Ascensor\n");
        else if(!tieneAscensor && esDuplex) sb.append("Duplex\n");
        else sb.append(" ---\n");
        sb.append("-->> Fin Apartamento\n");
        System.out.println(sb.toString());
    }
    
}
