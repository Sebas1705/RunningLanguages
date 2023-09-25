package com.sebss.Algorithms.Recursives;

public class Range {
    public static int[] range(int start,int end,int step){
        if(start==end){
            int[] r={start};
            return r;
        }else if(start>end){
            int[] r={};
            return r;
        }else{
            int[] arr1={start},arr2=range(start+step,end),r=new int[arr1.length+arr2.length];
            System.arraycopy(arr1,0,r,0,arr1.length);
            System.arraycopy(arr2,0,r,arr1.length,arr2.length);
            return r;
        }
    }
    public static int[] range(int start,int end){
        return range(start,end,1);
    }
}
