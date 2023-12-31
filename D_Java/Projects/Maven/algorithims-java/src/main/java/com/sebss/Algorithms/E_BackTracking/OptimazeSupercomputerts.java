package com.sebss.Algorithms.E_BackTracking;

public class OptimazeSupercomputerts {
    
    public static void main(String[] args) {
        int[] as={8,4,20,4};	
        int[] bs = {15,14,13,21};
        System.out.println("Backtracking-Poda: "+simularPoda(as,bs));
        System.out.println("Backtracking: "+simularBack(as,bs));
    }

    public static int simularPoda(int[] as, int[] bs){
        //Precondicion:
        if(as.length!=bs.length||as.length==0||!comprobarValoresPositivos(as,bs)) return -1;
        int[] solution=new int[as.length];//Indices: 0-Salto A, 1-Salto B, 2-A, 3-B
        return buscarCaminoPoda(as,bs,0,getCota(as,bs),new int[as.length],0,solution,0);
    }

    private static int buscarCaminoPoda(int[] as,int[] bs,int i,int cota,int[] solution,int value,int[] optimalSolution,int optimalValue){
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
                    int cotaTemp=0;
                    if(as[i]>bs[i]) cotaTemp=cota-((k==0||k==1)?as[i]:((k==2)?0:as[i]-bs[i]));
                    else cotaTemp=cota-((k==0||k==1)?bs[i]:((k==3)?0:bs[i]-as[i]));
                    if(cotaTemp>optimalValue){
                        optimalValue=buscarCaminoPoda(as,bs,i+1,cotaTemp,solution,value+((k==2)?as[i]:((k==3)?bs[i]:0)),optimalSolution,optimalValue);
                    }
                }
            }
        }
        return optimalValue;
    }

    private static int getCota(int[] as,int[] bs){
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
    
    private static boolean comprobarValoresPositivos(int[] as,int[] bs){
        //Comprobamos que todos los valores de as y bs sean mayores que 0:
        for(int i=0;i<as.length;i++){
            if(as[i]<=0||bs[i]<=0)return false;
        }
        return true;
    }
}