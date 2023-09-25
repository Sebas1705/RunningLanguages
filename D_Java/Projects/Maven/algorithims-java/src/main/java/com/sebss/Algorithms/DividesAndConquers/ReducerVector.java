package com.sebss.Algorithms.DividesAndConquers;

public class ReducerVector {

    public interface Reducer{
        public int reduceOperation(int a,int b);
    }
    
    public static int reduce(int[] vector,Reducer operation){
        return reduceAlgorithm(vector,0,vector.length-1,operation);
    }

    private static int reduceAlgorithm(int[] vector,int start,int end,Reducer operation){
        if((end-start)<=0) return vector[start];
        else{
            int mid = start+(end-start)/2;
            int a = reduceAlgorithm(vector,start,mid,operation);
            int b = reduceAlgorithm(vector,mid+1,end,operation);
            return operation.reduceOperation(a,b);
        }
    }
}
