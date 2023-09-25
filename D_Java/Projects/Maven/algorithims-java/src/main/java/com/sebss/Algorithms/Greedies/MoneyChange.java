package com.sebss.Algorithms.Greedies;

import java.util.Arrays;

public class MoneyChange {
    
    public static int[] getChange(int mount,int[] coins){
        //Sort coins largest to smallest
        int[] m=coins;
        Arrays.sort(m);
        for (int i=0;i<m.length/2;i++) {
            int tmp=m[i];
            m[i]=m[m.length-1-i];
            m[m.length-1-i]=tmp;
        }
        
        //Greedy algorithm
        int[] sol=new int[m.length];
        for(int i=0;i<m.length&&!isSol(mount,sol,m);){
            if(mount-m[i]>=0) {
                sol[i]++;
                mount-=m[i];
            }else i++;
        }
        return sawSol(sol,m);
    }

    private static boolean isSol(int mount,int[] sol,int[] m){
        int t=0;
        for(int i=0;i<sol.length;i++)t+=sol[i]*m[i];
        return mount==t;
    }

    private static int[] sawSol(int[] sol,int[] m){
        int tam=0;
        for(int i=0;i<sol.length;i++)tam+=sol[i];
        int[] s=new int[tam];
        int k=0;
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[i];j++){
                s[k++]=m[i];
            }
        }
        return s;
    }
}
