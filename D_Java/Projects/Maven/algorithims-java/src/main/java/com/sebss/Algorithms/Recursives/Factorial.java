package com.sebss.Algorithms.Recursives;

public class Factorial {
    public static int factorialByNumber(int n){
        if(n<=0||n==1) return n;
        else return n * factorialByNumber(n-1);
    }
}
