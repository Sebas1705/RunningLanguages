package com.sebss.Algorithms.Recursives;

public class Exponent {
    public static double exponent(int base,int exponent){
        if(exponent==0)return 1;
        else if(exponent<=0)return 1/exponent(base,exponent*-1);
        else return base * exponent(base,exponent-1);
    }
}
