package com.sebss;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double n=990; //(Math.random()*870+223);
        System.out.println(n+": "+convert255(n-223));
    }

    public static double convert255(double n){
        return n/(870/255);
    }
}
