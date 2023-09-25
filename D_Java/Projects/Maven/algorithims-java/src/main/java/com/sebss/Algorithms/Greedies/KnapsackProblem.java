package com.sebss.Algorithms.Greedies;

public class KnapsackProblem {
    
    public static double oneOrZero(double cap,double[] weights,double[] values){
        if(weights.length != values.length) throw new IllegalArgumentException("Weights and values must be same length");
        
        //Order candidates:
        double[][] candidates = getCandidates(values, weights);
        for(int i=0;i<candidates.length;i++)System.out.println(candidates[i][0]+": "+candidates[i][1]+" || "+(candidates[i][0]/candidates[i][1]));
        
        //Greedy:
        double t=0.0;
        // double[][] results = new double[weights.length][2];
        // for(int i=0;i<candidates.length;i++){
        //     if(cap->=0) {
        //         sol[i]++;
        //         mount-=m[i];
        //     }else i++;
        // }
        
        return t;
    }

    private static double[][] getCandidates (double[] v1,double[] v2) {
        double[][] v = new double[v1.length][2];
        for(int i=0;i<v1.length;i++) {
            v[i][0]=v1[i];
            v[i][1]=v2[i];
        }
        for (int i=1; i<v.length; i++){
            for (int j=0; j<v.length-i; j++){
                if (v[j][0]/v[j][1]<v[j+1][0]/v[j+1][1]) {
                    double aux=v[j][0];
                    v[j][0]=v[j+1][0];
                    v[j+1][0]=aux;   
                    aux=v[j][1];
                    v[j][1]=v[j+1][1];
                    v[j+1][1]=aux; 
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        oneOrZero(180.0,new double[]{26,68,64,53,53,66},new double[]{71,40,9,5,54,24});
    }
}
