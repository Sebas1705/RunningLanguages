package com.sebss.Algorithms.EstructureResume.C_Greedies;

import com.sebss.Algorithms.EstructureResume.PreconditionsCheckers;

public class KnapsackProblem {
    
    public static double oneOrZero(double cap,double[] weights,double[] values){
        //Preconditions:
        if(!PreconditionsCheckers.checkSameLength(weights, values)) throw new IllegalArgumentException("Weights and values must be same length");
        if(!PreconditionsCheckers.checkPositiveValues(weights)) throw new IllegalArgumentException("Weights must be positive");
        if(!PreconditionsCheckers.checkPositiveValues(values)) throw new IllegalArgumentException("Values must be positive");

        //Order candidates:
        int[] indexes=getIndexes(values,weights);
        for (int i : indexes) System.out.println(i+"("+(values[i]/weights[i])+"): weight "+weights[i]+" and value "+values[i]);

        //Greedy:
        double t=0.0,w=0.0;
        for(int i=0;i<indexes.length;i++){
            if(w+weights[indexes[i]]<=cap){
                System.out.println("Selected "+indexes[i]+": weight "+weights[indexes[i]]+" and value "+values[indexes[i]]);
                w+=weights[indexes[i]];
                t+=values[indexes[i]];
            }
        }
        return t;
    }

    private static int[] getIndexes (double[] v1,double[] v2) {
        int[] v = new int[v1.length];
        for(int i=0;i<v1.length;i++) v[i]=i;
        for (int i=1;i<v.length;i++){
            for (int j=0;j<v.length-i;j++){
                if (v1[v[j]]/v2[v[j]]<v1[v[j+1]]/v2[v[j+1]]) {
                    int aux=v[j];
                    v[j]=v[j+1];
                    v[j+1]=aux;
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(oneOrZero(180.0,new double[]{26,68,64,53,53,66},new double[]{71,40,9,5,54,24}));
    }
}
