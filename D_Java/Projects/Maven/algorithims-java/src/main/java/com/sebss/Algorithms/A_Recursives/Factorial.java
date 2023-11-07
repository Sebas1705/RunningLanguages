package com.sebss.Algorithms.A_Recursives;

public class Factorial {
    public static int factorialByNumber(int n){
        if(n<0) throw new IllegalArgumentException("N can't be a negative number");
        if(n<=0||n==1) return n;
        else return n * factorialByNumber(n-1);
    }
}
