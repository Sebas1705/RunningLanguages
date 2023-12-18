package com.sebss.Algorithms.F_Dynamic;

public class OptimazeSupercomputers {
    


    public static int simular(int[] as, int[] bs){
        if(as.length != bs.length || as.length==0) return -1;
        if(check_negatives_or_zero(as)||check_negatives_or_zero(bs)) return -1;
        //States: 0-Jump to a, 1-Jump to b, 2-A, 3-B
        return tabulate_algorithm(as, bs);
    }
    
    private static boolean check_negatives_or_zero(int[] data){
        for(int i : data) if(i<=0) return true;
        return false;
    }

    private static int recursive_forwards(int[] as, int[] bs, int index, int lastState){
        if(index==0)
            return Math.max(as[index]+recursive_forwards(as, bs, index+1, 2),bs[index]+recursive_forwards(as, bs, index+1, 3));
        else if(index==as.length-1)
            return (lastState==0||lastState==2)?as[index]:bs[index];
        else{
            switch (lastState) {
                case 0:
                    return as[index]+recursive_forwards(as,bs,index+1,2);
                case 1:
                    return bs[index]+recursive_forwards(as,bs,index+1,3);
                case 2:
                    return Math.max(as[index]+recursive_forwards(as,bs,index+1,2),recursive_forwards(as, bs, index+1,1));
                default:
                    return Math.max(bs[index]+recursive_forwards(as,bs,index+1,3),recursive_forwards(as, bs, index+1,0));
            }
        }
    }

    private static int recursive_backwards(int[] as, int[] bs, int index, int lastState){
        if(index==as.length-1)
            return Math.max(as[index]+recursive_backwards(as, bs, index-1, 2),bs[index]+recursive_backwards(as, bs, index-1, 3));
        else if(index==0)
            return (lastState==1||lastState==2)?as[index]:bs[index];
        else{
            switch (lastState) {
                case 0:
                    return bs[index]+recursive_backwards(as,bs,index-1,3);
                case 1:
                    return as[index]+recursive_backwards(as,bs,index-1,2);
                case 2:
                    return Math.max(as[index]+recursive_backwards(as,bs,index-1,2),recursive_backwards(as, bs, index-1,0));
                default:
                    return Math.max(bs[index]+recursive_backwards(as,bs,index-1,3),recursive_backwards(as, bs, index-1,1));
            }
        }
    }

    private static int tabulate_algorithm(int[] as, int[] bs){
        int[][] table = new int[4][as.length];
        boolean exit=false;
        for(int j=as.length-1;j>=0;j--){
            for(int i=3;i>=0;i--){
                if(i==1&&j==1)exit=true;
                else if(j==as.length-1)table[i][j]=(i==3||i==1)?bs[j]:as[j];
                else {
                    switch (i) {
                        case 0:
                            table[i][j]=table[2][j+1]+as[j];
                            break;
                        case 1:
                            table[i][j]=table[3][j+1]+bs[j];
                            break;
                        case 2:
                            table[i][j]=Math.max(table[1][j+1],table[2][j+1]+as[j]);
                            break;
                        default:
                            table[i][j]=Math.max(table[0][j+1],table[3][j+1]+bs[j]);
                            break;
                    }
                }
                if(exit)break;
            }
            if(exit)break;
        }
        printSelections(table, as, bs);
        return Math.max(table[2][1]+as[0],table[3][1]+bs[0]); //table[0][0]
    }

    private static void printSelections(int[][] table,int[] as,int[] bs){
        int[] selections = new int[as.length];
        selections[0]=(table[2][1]+as[0]>table[3][1]+bs[0])?2:3;
        for(int i=1;i<as.length-1;i++){
            switch (selections[i-1]) {
                case 0:
                    selections[i]=2;
                    break;
                case 1:
                    selections[i]=3;
                    break;
                case 2:
                    selections[i]=(table[1][i+1]>table[2][i+1]+as[i])?1:2;
                    break;
                default:
                    selections[i]=(table[0][i+1]>table[3][i+1]+bs[i])?0:3;
                    break;
            }
        }
        selections[as.length-1]=selections[as.length-2];
        System.out.print("Selections: {");
        for(int i=0;i<as.length;i++){
            System.out.print((selections[i]==2)?as[i]:(selections[i]==3)?bs[i]:0);
            if(i!=as.length-1)System.out.print(",");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        System.out.println(simular(new int[]{10,2,6,9} , new int[]{5,4,12,15}));
    }
    
}
