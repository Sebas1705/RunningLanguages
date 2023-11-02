package com.sebss.Algorithms.BackTracking;

public class OptimazeSupercomputerts {
    
    public static void main(String[] args) {
        int[] as={8,4,20,4};	
        int[] bs = {15,14,13,21};
        System.out.println("Backtracking-Poda: "+simularPoda(as,bs));
        System.out.println("Backtracking: "+simularBack(as,bs));
        System.out.println("Heuristic: "+simularH1(as,bs));
        System.out.println("Greedy: "+simularH2(as,bs));
    }

    public static int simularPoda(int[] as, int[] bs){
        //Precondicion:
        if(as.length!=bs.length||as.length==0||!comprobarValoresPositivos(as,bs)) return -1;
        int[] solution=new int[as.length];//Indices: 0-Salto A, 1-Salto B, 2-A, 3-B
        return buscarCaminoPoda(as,bs,0,getCota(as,bs),new int[as.length],0,solution,0);
    }

    private static int buscarCaminoPoda(int[] as,int[] bs,int i,int cota,int[] solution,int value,int[] optimalSolution,int optimalValue){
        System.out.println("Cota en "+i+": "+cota);
        if(i==as.length-1){
            solution[i]=(solution[i-1]==0||solution[i-1]==2)?2:3;
            value+=(solution[i]==2)?as[i]:bs[i];
            if(value>optimalValue){
                optimalValue=value;
                for(int j=0;j<as.length;j++)optimalSolution[j]=solution[j];
            }
        }else{
            for(int k=0;k<4;k++){
                if(esValido(k,i,solution)){
                    solution[i]=k;
                    int cotaTemp=cota-((k==0||k==1)?as[i]+bs[i]:(k==2)?bs[i]:as[i]);
                    if(cota>optimalValue){
                        optimalValue=buscarCaminoPoda(as,bs,i+1,cotaTemp,solution,value+((k==2)?as[i]:((k==3)?bs[i]:0)),optimalSolution,optimalValue);
                    }else{
                        System.out.println("Poda en "+i+": "+k);
                    }
                }
            }
        }
        return optimalValue;
    }

    public static int getCota(int[] as,int[] bs){
        int cota=0;
        for(int i=0;i<as.length;i++){
            cota+=(as[i]>bs[i])?as[i]:bs[i];
        }
        return cota;
    }
    
    public static int simularBack(int[] as, int[] bs){
        //Precondicion:
        if(as.length!=bs.length||as.length==0||!comprobarValoresPositivos(as,bs)) return -1;
        int[] solution=new int[as.length];//Indices: 0-Salto A, 1-Salto B, 2-A, 3-B
        return buscarCaminoBack(as,bs,0,new int[as.length],0,solution,0);
    }

    private static int buscarCaminoBack(int[] as,int[] bs,int i,int[] solution,int value,int[] optimalSolution,int optimalValue){
        if(i==as.length-1){
            solution[i]=(solution[i-1]==0||solution[i-1]==2)?2:3;
            value+=(solution[i]==2)?as[i]:bs[i];
            if(value>optimalValue){
                optimalValue=value;
                for(int j=0;j<as.length;j++)optimalSolution[j]=solution[j];
            }
        }else{
            for(int k=0;k<4;k++){
                if(esValido(k,i,solution)){
                    solution[i]=k;
                    optimalValue=buscarCaminoBack(as,bs,i+1,solution,value+((k==2)?as[i]:((k==3)?bs[i]:0)),optimalSolution,optimalValue);
                }
            }
        }
        return optimalValue;
    }

    private static boolean esValido(int option,int index,int[] solution){
        if(index==0)
            return option==2||option==3;                           //Si es el primero y es a o b
        else return            
                (solution[index-1]==0&&option==2)||                //Si su anterior fue salto a y ahora a
                (solution[index-1]==1&&option==3)||                //Si su anterior fue salto b y ahora b
                (solution[index-1]==2&&(option==2||option==1))||   //Si era a y ahora a o salto b 
                (solution[index-1]==3&&(option==3||option==0));    //Si era b y ahora b o salto a
    }
    
    
    private static int resumeSolution(int[] as,int[] bs,int[] solution){
        int total=0;
        for(int i=0;i<solution.length;i++){
            System.out.print("Paso nº"+i+": ");
            switch(solution[i]){
                case 0: System.out.println(" Paso a A (0)");break;
                case 1: System.out.println(" Paso a B (0)");break;
                case 2: System.out.println(" A ("+as[i]+")");total+=as[i];break;
                case 3: System.out.println(" B ("+bs[i]+")");total+=bs[i];break;
            }
        }
        return total;
    }
    private static boolean comprobarValoresPositivos(int[] as,int[] bs){
        //Comprobamos que todos los valores de as y bs sean mayores que 0:
        for(int i=0;i<as.length;i++){
            if(as[i]<=0||bs[i]<=0)return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////+


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
        
        //Bucle que recorre minuto a minuto los ordenadores
        //Condicion de salida (i==n-1)
        for(int i=0;i<as.length;i++){
            //Función de seleccion:
            estado=siguiente(as,bs,i,estado);
            //Si esta en uno de los dos ordenadores sumamos sus tareas realizadas:
            if(estado==2)nPasos+=as[i];
            else if(estado==3)nPasos+=bs[i];
        }

        //Devolvemos el número de pasos 
        return nPasos;
    }
    private static int siguiente(int[] as,int[] bs,int i,int estado){
        //Si es el primer minuto se decide por elemento mayor:
        if(i==0)return (as[i]>bs[i])?2:3;
        //Si es el ultimo y es A o B se mantiene:
        if(i==as.length-1&&(estado==2||estado==3))return estado;
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
            //Se pide el nuevo indice:
            indices[i]=cambioIndice(indices,i);
            //Si el indice es salto no se suma y si no lo es se suma lo que corresponda:
            if(indices[i]!=0&&indices[i]!=1)nPasos+=(indices[i]==2)?as[i]:bs[i];
        }

        return nPasos;
    }
    private static int[] getIndices(int[] as,int[] bs){
        //Se crea un array del mismo tamaño que as y bs:
        int[] indices=new int[bs.length];
        //Se recorre asignando el indice del mayor valor:
        for(int i=0;i<bs.length;i++){
            if(i==bs.length-1)indices[i]=indices[i-1];
            else indices[i]=(as[i]>bs[i])?2:3;
        }
        return indices;
    } 
    private static int cambioIndice(int[] indices,int i){
        //En caso de ser el primero o último se deja el mismo índice:
        if(i==0||i==indices.length-1)return indices[i];
        //Si los vecinos son diferentes entre si y el de la izquierda no es salto
        // el indice actual debe ser un salto:
        else if(indices[i-1]!=indices[i+1]&&indices[i-1]!=0&&indices[i-1]!=1){
            return (indices[i-1]==2)?1:0;
        }
        //Si los vecinos son iguales y el actual se iguala sin salto:
        else if(indices[i-1]==indices[i+1]&&indices[i]!=indices[i+1]){
            return indices[i-1];
        }
        //Si no se deja igual:
        return indices[i];
    }
}