package com.sebss.Algorithms.Recursives;

public class Fibonacci {
    public static int fibonacciByNumber(int n){
        if(n==0||n==1) return n;
        else return fibonacciByNumber(n-1)+fibonacciByNumber(n-2);
    }
}
