package com.sebss.Algorithms.EstructureResume.A_Recursives;

public class Fibonacci {
    public static int fibonacciByNumber(int n){
        if(n<0) throw new IllegalArgumentException("N can't be a negative number");
        if(n==0||n==1) return n;
        else return fibonacciByNumber(n-1)+fibonacciByNumber(n-2);
    }
}
