package com.sebss.Algorithms.F_Dynamic;

public class RedudantRecursives {
    

    public static int f_mem (int x) {
        int[][] table = new int[x+1][2];
        for(int i=0;i<x+1;i++) table[i][0]=-1;
        for(int i=0;i<x+1;i++) table[i][1]=-1;
        g_mem(x,0,table);
        return table[x][0];
    }
    
    private static void g_mem (int x, int y, int[][] table) {
        if(table[x][y]==-1){
            if (x==0) table[x][y] = 0;
            else if (x==1) table[x][y] = y;
            else if (y==0){
                g_mem(x-1,0,table);
                g_mem(x,1,table);
                table[x][y] = table[x-1][0] + table[x][1];
            } else {
                g_mem(x-2,0,table);
                g_mem(x-1,1,table);
                table[x][y] = table[x-2][0] + table[x-1][1];
            }
        }
    }


    public static int f_tab (int x){
        return g_tab(x,0);
    }

    private static int g_tab (int x, int y){
        int[][] table = new int[x+1][2];
        table[0][0]=0;
        if(x>0){
            table[1][0]=0;
            table[1][1]=1; 
            for(int i=2;i<x+1;i++){
                table[i][1] = table[i-2][0] + table[i-1][1];
                table[i][0] = table[i-1][0] + table[i][1];
            }
        }
        return table[x][y];
    }

    public static void main(String[] args) {
        System.out.println(f_tab(4));
    }

}
