package com.sebss.Algorithms.F_Dynamic;

public class RedudantRecursives {
    

    public static int f (int x) {
        int[][] table = new int[x+1][2];
        for(int i=0;i<x+1;i++) table[i][0]=-1;
        for(int i=0;i<x+1;i++) table[i][1]=-1;
        g(x,0,table);
        return table[x][0];
    }
    
    private static void g (int x, int y, int[][] table) {
        if(table[x][y]==-1){
            if (x==0) table[x][y] = 0;
            else if (x==1) table[x][y] = y;
            else if (y==0){
                g(x-1,0,table);
                g(x,1,table);
                table[x][y] = table[x-1][0] + table[x][1];
            } else {
                g(x-2,0,table);
                g(x-1,1,table);
                table[x][y] = table[x-2][0] + table[x-1][1];
            }
        }
    }

}
