public class Enum {
    

    static enum DiasSemana{DOMINGO,LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO}
    static enum TamanioLetra{TINY,SMALL,MEDIUM,LARGE,HUGE}

    public static void main(String[] args) {
        
        DiasSemana dia = DiasSemana.LUNES;
        String dia2 = dia.name();

        System.out.println(dia);
        System.out.println(dia.ordinal());
        System.out.println(dia.equals(DiasSemana.LUNES));
        System.out.println(dia.ordinal()==1);
        System.out.println(dia.name());
        System.out.println(dia2);

        TamanioLetra tamanio = TamanioLetra.HUGE;
        if(tamanio.equals(TamanioLetra.SMALL)){
            System.out.println(tamanio.name());
        }

    }
}
