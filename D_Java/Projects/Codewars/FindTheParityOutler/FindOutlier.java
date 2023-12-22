package FindTheParityOutler;

import java.util.LinkedList;

public class FindOutlier {
    public static int find(int[] ints){
        LinkedList<Integer> odds = new LinkedList<Integer>(), evens = new LinkedList<Integer>();
        for(int i : ints){
            if(i%2 == 0) odds.add(i);
            else evens.add(i);
        }
        if(odds.size() == 1) return odds.get(0);
        else return evens.get(0);
    }
}
