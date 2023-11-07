package com.sebss.Algorithms.C_Greedies;

import java.util.Arrays;

public class MagneticTapSaveOptimize {
    
    public static int getRelativeTime(int[] tamFiles){
        //Sort smallest to largest
        int[] m=tamFiles;
        Arrays.sort(m);
        
        //Greedy algorithm:
        int t=0;
        for(int i=0;i<m.length;i++){
            t+=m[i];
            for(int j=i-1;j>=0;j--)t+=m[j];
        }
        return t;
    }
}
