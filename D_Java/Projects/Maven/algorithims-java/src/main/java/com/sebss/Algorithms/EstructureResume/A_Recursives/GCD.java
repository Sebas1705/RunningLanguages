package com.sebss.Algorithms.EstructureResume.A_Recursives;

public class GCD {
    public static int gcd(int n1,int n2){
        if(n1<0||n2<0) throw new IllegalArgumentException("Ns can't be a negative number");
        if (n2==0) return n1;
        else return gcd(n2,n1%n2);  
    }
}
