package Intermedio.D_ClasesAbstractas;

public class Chalet extends Casa{

    private int nPlantas, nPatios;

    public Chalet(int metrosCuadrados, int nHabitaciones, int nPlantas, int nPatios){
        super(metrosCuadrados, nHabitaciones);
        this.nPlantas = nPlantas;
        this.nPatios = nPatios;
    }

    @Override
    public void mostrarDatos(int i) {
        StringBuilder sb = new StringBuilder("-->> Nº"+i+": Chalet\n");
        sb.append("|-Metros cuadrados: "+metrosCuadrados+"\n");
        sb.append("|-Numero Habitaciones: "+nHabitaciones+"\n");
        sb.append("|-Numero Plantas: "+nPlantas+"\n");
        sb.append("|-Numero Patios:"+nPatios+"\n");
        sb.append("-->> Fin Chalet\n");
        System.out.println(sb.toString());
    }
}
