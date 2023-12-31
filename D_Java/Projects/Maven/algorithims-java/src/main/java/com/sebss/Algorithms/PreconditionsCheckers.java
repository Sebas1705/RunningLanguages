package com.sebss.Algorithms;

public class PreconditionsCheckers {
    
    public static boolean checkPositiveValues(int[] values) {
        for (int value : values) if (value < 0) return false;
        return true;
    }
    public static boolean checkPositiveValues(double[] values) {
        for (double value : values) if (value < 0) return false;
        return true;
    }
    public static int maxValue(int[] values) {
        int max=Integer.MIN_VALUE;
        for(int value : values) if (value>max) max=value;
        return max;
    }

    public static boolean checkSameLength(int[] values1, int[] values2) {return values1.length == values2.length;}
    public static boolean checkSameLength(double[] values1, double[] values2) {return values1.length == values2.length;}
    
}
