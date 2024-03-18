package com.sebss.Algorithms.EstructureResume.F_Dynamic;

public class OptimazeSupercomputers {

    public static int simular(int[] as, int[] bs){
        if(as.length != bs.length || as.length==0) return -1;
        if(check_negatives_or_zero(as)||check_negatives_or_zero(bs)) return -1;
        return tabulate_algorithm(as,bs);
    }
    
    private static boolean check_negatives_or_zero(int[] data){
        for(int i : data) if(i<=0) return true;
        return false;
    }

    private static int recursive_forwards(int[] as,int[] bs,int index,boolean to_a){/// 0 - true, 1 - false, 2 - true, 3 - false
        if(index==0)
            return Math.max(as[index]+recursive_forwards(as,bs,index+1,true),bs[index]+recursive_forwards(as,bs,index+1,false));
        else if(index==as.length-1)
            return to_a?as[index]:bs[index];
        else if(to_a){
            return Math.max(
                as[index]+recursive_forwards(as,bs,index+1,true),
                recursive_forwards(as,bs,index+1,false)
            );
        }else{
            return Math.max(
                bs[index]+recursive_forwards(as,bs,index+1,false),
                recursive_forwards(as,bs,index+1,true)
            );
        }
    }

    private static int recursive_backwards(int[] as,int[] bs,int index,boolean to_a){
        if(index==as.length-1)
            return Math.max(as[index]+recursive_backwards(as,bs,index-1,true),bs[index]+recursive_backwards(as,bs,index-1,false));
        else if(index==0)
            return to_a?as[index]:bs[index];
        else if(to_a){
            return Math.max(
                as[index]+recursive_backwards(as,bs,index-1,true),
                recursive_backwards(as,bs,index-1,false)
            );
        }else{
            return Math.max(
                bs[index]+recursive_backwards(as,bs,index-1,false),
                recursive_backwards(as,bs,index-1,true)
            );
        }
    }

    private static int tabulate_algorithm(int[] as, int[] bs){
        int[][] table = new int[2][as.length];
        int last=as.length-1;
        table[1][last]=as[last];
        table[0][last]=bs[last];
        for(int j=last-1;j>=1;j--){
            table[1][j]=Math.max(table[1][j+1]+as[j],table[0][j+1]);
            table[0][j]=Math.max(table[0][j+1]+bs[j],table[1][j+1]);
        }
        table[0][0]=Math.max(as[0]+table[1][1],bs[0]+table[0][1]);
        printSelections(table, as, bs);
        return table[0][0];
    }

    private static void printSelections(int[][] table,int[] as,int[] bs){
        int[] selections = new int[as.length];
        int last=as.length-1;
        selections[0]=(as[0]+table[1][1]>bs[0]+table[0][1])?as[0]:bs[0];
        for(int i=1;i<=last-1;i++){
            if(selections[i-1]==as[i-1])
                selections[i]=(as[i]+table[1][i+1]>table[0][i+1])?as[i]:0;
            else 
                selections[i]=(bs[i]+table[0][i+1]>table[1][i+1])?bs[i]:0;
        }
        selections[last]=(selections[last-1]==as[last-1])?as[last]:bs[last];
        System.out.print("Selections: {");
        for(int i=0;i<as.length;i++){
            System.out.print(selections[i]);
            if(i!=as.length-1)System.out.print(",");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        System.out.println(simular(new int[]{10,2,6,9} , new int[]{5,4,12,15}));
    }
    
}
