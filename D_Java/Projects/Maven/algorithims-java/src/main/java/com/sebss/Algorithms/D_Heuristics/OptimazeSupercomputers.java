package com.sebss.Algorithms.D_Heuristics;

public class OptimazeSupercomputers {
    
    public static void main(String[] args) {
        int[] as={9,21,9,9};
        int[] bs={5,4,12,15};

        // int[] as={10,2,6,9};
        // int[] bs={5,4,12,15};
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
     * @return numero de pasos que avanzó la tarea durante n minutos
     */
    public static int simularH1(int[] as, int[] bs){

        //Precondiciones:
        //Tamaño de los arrays diferente de 0, arrays de mismo tamaño y que los valores de as y bs sean todos mayor que 0
        if(as.length!=bs.length||as.length==0||!comprobarValoresPositivos(as,bs)) return -1;

        
        //Numero de pasos que avanzo la tarea durante todo el problema:
        int nPasos=0;
        //Estado para saber la acción anterior: 0-salto a, 1-salto b, 2-a, 3-b
        int estado=0;
        //Elecciones guardados para su impresión posterior:
        int[] elecciones=new int[as.length];
        
        //Bucle que recorre minuto a minuto los ordenadores
        //Condicion de salida (i==n-1)
        for(int i=0;i<as.length;i++){
            //Función de seleccion:
            estado=siguiente(as,bs,i,estado);
            //Guardamos el estado:
            elecciones[i]=estado;
            //Si esta en uno de los dos ordenadores sumamos sus tareas realizadas:
            if(estado==2)nPasos+=as[i];
            else if(estado==3)nPasos+=bs[i];
        }

        //Imprimimos las elecciones:
        printElecciones(as,bs,elecciones);

        //Devolvemos el número de pasos 
        return nPasos;
    }
    private static int siguiente(int[] as,int[] bs,int i,int estado){
        //Si es el primer minuto se decide por elemento mayor:
        if(i==0)return (as[i]>bs[i])?2:3;
        //Si es el ultimo se mantiene:
        if(i==as.length-1)return estado;
        switch(estado){
            //Si esta en salto A se cambia a A (2)
            case 0: return 2;
            //si esta en salto B se cambia a B (3)
            case 1: return 3;
            //Si esta en A se comprueba si se debe saltar y se hace o se queda:
            case 2: return (bs[i+1]>(as[i]+as[i+1]))?1:2;
            //Si esta en B se comprueba si se debe saltar y se hace o se queda:
            case 3: return (as[i+1]>(bs[i]+bs[i+1]))?0:3;
        }
        //Se devuelve -1 en caso de error de estado:
        return -1;
    }
    
    /**
     * Algoritmo voraz para el problema de los supercomputadores
     * @param as array de n enteros que representa el numero de ciclos libres del supercomputador A en el minuto i
     * @param bs array de n enteros que representa el numero de ciclos libres del supercomputador B en el minuto i
     * @return numero de pasos que avanzo la tarea durante n minutos
     */
    public static int simularH2(int[] as,int[] bs){
        
        //Precondiciones:
        //Tamaño de los arrays diferente de 0, arrays de mismo tamaño y que los valores de as y bs sean todos mayor que 0
        if(as.length!=bs.length||as.length==0||!comprobarValoresPositivos(as,bs)) return -1;

        
        //Generamos los indices de cada minuto:
        int[] indices=getIndices(as,bs);//Indice: 0-salto a, 1-salto b, 2-a, 3-b

        //Numero de pasos que avanzo la tarea durante todo el problema:
        int nPasos=0;

        //bucle voraz para ir determinando si hay salto o no
        for(int i=0;i<indices.length;i++){
            //Si hace falta un salto se realiza:
            if(faltaSalto(indices,i))indices[i]=(indices[i]==2)?1:0;
            //Si el indice es salto no se suma y si no lo es se suma lo que corresponda:
            if(indices[i]!=0&&indices[i]!=1)nPasos+=(indices[i]==2)?as[i]:bs[i];
        }

        //Imprimimos las elecciones:
        printElecciones(as,bs,indices);

        return nPasos;
    }
    private static int[] getIndices(int[] as,int[] bs){
        //Se crea un array del mismo tamaño que as y bs:
        int[] indices=new int[bs.length];
        //Se recorre asignando el indice del mayor valor:
        for(int i=0;i<bs.length;i++)indices[i]=(as[i]>bs[i])?2:3;
        return indices;
    } 
    private static boolean faltaSalto(int[] arr,int i){
        //En caso de ser el primero o último no puede haber salto:
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
    private static boolean comprobarValoresPositivos(int[] as,int[] bs){
        //Comprobamos que todos los valores de as y bs sean mayores que 0:
        for(int i=0;i<as.length;i++){
            if(as[i]<=0||bs[i]<=0)return false;
        }
        return true;
    }
}

