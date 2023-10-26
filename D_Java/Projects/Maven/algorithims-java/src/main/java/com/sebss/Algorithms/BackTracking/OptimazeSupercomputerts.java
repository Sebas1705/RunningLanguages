package com.sebss.Algorithms.BackTracking;

public class OptimazeSupercomputerts {
    
    public static void main(String[] args) {
        int[] as = {10,2,6,9};
        int[] bs = {5,4,12,15};
        System.out.println(simular(as,bs));
    }

    public static int simular(int[] as, int[] bs){
        //Precondicion:
        if(as.length!=bs.length||as.length==0||!comprobarValoresPositivos(as,bs)) return -1;
        int[] solution=new int[as.length];//Indices: 0-Salto A, 1-Salto B, 2-A, 3-B
        buscarCamino(as,bs,0,new int[as.length],0,solution,0);
        return resumeSolution(as,bs,solution,true);
    }

    private static int buscarCamino(int[] as,int[] bs,int i,int[] solution,int value,int[] optimalSolution,int optimalValue){
        if(i==0){
            solution[i]=2;
            optimalValue=buscarCamino(as,bs,i+1,solution,as[i],optimalSolution,optimalValue);
            solution[i]=3;
            optimalValue=buscarCamino(as,bs,i+1,solution,bs[i],optimalSolution,optimalValue);
        }else if(i==as.length-1){
            solution[i]=(solution[i-1]==0||solution[i-1]==2)?2:3;
            value+=(solution[i]==2)?as[i]:bs[i];
            if(value>optimalValue){
                //Si es mayor copiamos los valores
                optimalValue=value;
                for(int j=0;j<as.length;j++)optimalSolution[j]=solution[j];
            }
        }else{
            switch(solution[i-1]){
                case 0:  
                    solution[i]=2;
                    optimalValue=buscarCamino(as,bs,i+1,solution,value+as[i],optimalSolution,optimalValue);
                    break;
                case 1: 
                    solution[i]=3;
                    optimalValue=buscarCamino(as,bs,i+1,solution,value+bs[i],optimalSolution,optimalValue);
                    break;
                case 2: 
                    solution[i]=2;
                    optimalValue=buscarCamino(as,bs,i+1,solution,value+as[i],optimalSolution,optimalValue);
                    solution[i]=1;
                    optimalValue=buscarCamino(as,bs,i+1,solution,value,optimalSolution,optimalValue);
                    break;
                case 3:
                    solution[i]=3;
                    optimalValue=buscarCamino(as,bs,i+1,solution,value+bs[i],optimalSolution,optimalValue);
                    solution[i]=0;
                    optimalValue=buscarCamino(as,bs,i+1,solution,value,optimalSolution,optimalValue);
                    break;
            }
        }
        return optimalValue;
    }

    private static int resumeSolution(int[] as,int[] bs,int[] solution,boolean print){
        int total=0;
        for(int i=0;i<solution.length;i++){
            System.out.print("Paso nº"+i+": ");
            switch(solution[i]){
                case 0: if(print)System.out.println(" Paso a A (0)");break;
                case 1: if(print)System.out.println(" Paso a B (0)");break;
                case 2: if(print)System.out.println(" A ("+as[i]+")");total+=as[i];break;
                case 3: if(print)System.out.println(" B ("+bs[i]+")");total+=bs[i];break;
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
}
