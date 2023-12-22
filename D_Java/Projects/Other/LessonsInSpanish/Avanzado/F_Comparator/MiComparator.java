package Avanzado.F_Comparator;

import java.util.Comparator;

public class MiComparator implements Comparator<Casa>{

    @Override
    public int compare(Casa o1, Casa o2) {
        return (int) (o1.getMetrosCuadrados() - o2.getMetrosCuadrados());
    }
    
}
