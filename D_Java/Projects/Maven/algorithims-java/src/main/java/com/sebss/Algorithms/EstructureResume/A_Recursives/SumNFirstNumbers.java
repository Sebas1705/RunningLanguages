package com.sebss.Algorithms.EstructureResume.A_Recursives;

public class SumNFirstNumbers {
    public static int sumNFirstNumbers(int n) {
        if(n>0) throw new IllegalArgumentException("N must be greater than 0");
        if(n==1)return 1;
        else return n + sumNFirstNumbers(n-1);
    } 
}
