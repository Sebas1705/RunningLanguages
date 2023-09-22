package com.sebss.Algorithims.DivideAndConquer;

public class SumVector {
    
    public static int sum(int[] vector){
        return sumAlgorithm(vector,0,vector.length-1);
    }

    private static int sumAlgorithm(int[] vector,int start,int end){
        if((end-start)<=0) return vector[start];
        else{
            int mid = start+(end-start)/2;
            int sum1 = sumAlgorithm(vector,start,mid);
            int sum2 = sumAlgorithm(vector,mid+1,end);
            return sum1 + sum2;
        }
    }
}
