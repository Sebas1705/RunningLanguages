package com.sebss.Algorithms.Heuristics;

public class OptimazeSupercomputers {
    
    public static void main(String[] args) {
        int[] as={9,21,9,9};
        int[] bs={5,4,12,15};
        System.out.println("----------SimularH1----------");
        System.out.println(simularH1(as, bs));
        System.out.println("----------SimularH2----------");
        System.out.println(simularH2(as, bs));
        System.out.println("-----------------------------");
    }

    /**
     * Algoritmo heuristico para el problema de los supercomputadores
     * @param as array de n enteros que representa el numero de ciclos libres del supercomputador A en el minuto i
     * @param bs array de n enteros que representa el numero de ciclos libres del supercomputador B en el minuto i
     * @return numero de pasos que avanzo la tarea durante n minutos
     */
    public static int simularH1(int[] as, int[] bs){
        //Precondición (n es igual tanto en as como bs):
        if(as.length!=bs.length)return -1;
        
        //Estado actual y número de pasos que lleva
        int nPasos=0,estado=0;//Estado: 0-salto a, 1-salto b, 2-a, 3-b
        int[] elecciones=new int[as.length];
        
        //Bucle que recorre minuto a minuto los ordenadores
        //Condicion de salida (i==n)
        for(int i=0;i<as.length;i++){
            //Función de seleccion:
            if(i!=as.length-1)estado=siguiente(as,bs,i,estado);
            elecciones[i]=estado;
            if(estado==2)nPasos+=as[i];
            else if(estado==3)nPasos+=bs[i];
        }

        printElecciones(as,bs,elecciones);

        //Postcondición (i termina igual a n):
        return nPasos;
    }
    private static int siguiente(int[] as,int[] bs,int i,int estado){
        if(i==0)return (as[i]>bs[i])?2:3;
        switch(estado){
            case 0: return 2;
            case 1: return 3;
            case 2: return (bs[i+1]>(as[i]+as[i+1]))?1:0;
            case 3: return (as[i+1]>(bs[i]+bs[i+1]))?0:1;
        }
        return -1;
    }
    
    /**
     * Algoritmo voraz para el problema de los supercomputadores
     * @param as array de n enteros que representa el numero de ciclos libres del supercomputador A en el minuto i
     * @param bs array de n enteros que representa el numero de ciclos libres del supercomputador B en el minuto i
     * @return numero de pasos que avanzo la tarea durante n minutos
     */
    public static int simularH2(int[] as,int[] bs){
        //Precondición (n es igual tanto en as como bs):
        if(as.length!=bs.length)return -1;
        
        //Obtenemos los indices de mayores pasos en cada minuto
        int[] indices=getIndices(as,bs);//Indice: 0-salto a, 1-salto b, 2-a, 3-b

        int nPasos=0;

        //bucle voraz para ir determinando si hay salto o no
        for(int i=0;i<indices.length;i++){
            if(faltaSalto(indices,i))indices[i]=(indices[i]==2)?1:0;
            if(indices[i]!=0&&indices[i]!=1)nPasos+=(indices[i]==2)?as[i]:bs[i];
        }

        printElecciones(as,bs,indices);

        return nPasos;
    }
    private static int[] getIndices(int[] as,int[] bs){
        int[] indices=new int[bs.length];
        for(int i=0;i<bs.length;i++)indices[i]=(as[i]>bs[i])?2:3;
        return indices;
    } 
    private static boolean faltaSalto(int[] arr,int i){
        if(i==0||i==arr.length-1)return false;
        //Falta salto si y solo si los laterales son distintos y el de la izq
        //no es ni 0 ni 1
        return arr[i-1]!=arr[i+1]&&arr[i-1]!=0&&arr[i-1]!=1;
    }


    private static void printElecciones(int[] as,int[] bs,int[] elecciones){
        for(int i=0;i<elecciones.length;i++){
            System.out.print("Paso nº"+i+": ");
            switch(elecciones[i]){
                case 0: System.out.println(" Paso a A (0)");break;
                case 1: System.out.println(" Paso a B (0)");break;
                case 2: System.out.println(" A ("+as[i]+")");break;
                case 3: System.out.println(" B ("+bs[i]+")");break;
            }
        }
    }
}

