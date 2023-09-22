package com.sebss.Algorithims.Recursives;

public class Fibonacci {
    public static int fibonnaciByNumber(int n){
        if(n==0||n==1) return n;
        else return fibonnaciByNumber(n-1)+fibonnaciByNumber(n-2);
    }
}
