package Square_into_Squares;

import java.util.ArrayList;

public class Decompose {
    
    public String decompose(long n) {
        
        if(n <= 0) return null;
        
        ArrayList<Long> solutions_reverse = new ArrayList<Long>();
        long searchSolution = n*n;
        long i = n-1;

        while(i >= 1 && !(searchSolution == 0)){
            long sroot = i*i;
            if(sroot <= searchSolution){
                solutions_reverse.add(i);
                searchSolution -= sroot;
            }
            i--;
        }

        if(solutions_reverse.size() == 0) return null;

        //Create string reverse:
        StringBuilder sb = new StringBuilder();
        for(int j = solutions_reverse.size()-1; j >= 0; j--) {
            sb.append(solutions_reverse.get(j));
            if(j != 0) sb.append(" "); 
        } 


        return sb.toString();
    }

}
