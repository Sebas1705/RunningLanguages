package com.sebss.Algorithms.EstructureResume.E_BackTracking;

import static com.sebss.Algorithms.EstructureResume.PreconditionsCheckers.*;

import java.util.*;

public class LessBoxes {
    
    public static void main(String[] args){
        System.out.println("Back: "+lessBoxesBack(new int[]{5,2,4,1,8},10));
    }
    
    public static int lessBoxesBack(int[] ps,int c){
        if(!checkPositiveValues(ps)||ps.length<=0||c<maxValue(ps))return -1;    
        Map<Integer,Integer> boxes=new HashMap<Integer,Integer>();
        boxes.put(0,c);
        return searchBoxes(ps,c,0,boxes,new HashMap<Integer,Integer>());
    }

    private static int searchBoxes(int[] ps,int c,int i,Map<Integer,Integer> boxes,Map<Integer,Integer> optimalBoxes){
        if(i==ps.length){
            if(optimalBoxes.isEmpty()||boxes.size()<optimalBoxes.size()){
                System.out.println("->Change<-");
                optimalBoxes.clear();
                boxes.entrySet().stream().forEach(entry->optimalBoxes.put(entry.getKey(),entry.getValue()));
            }
        }else{
            for(int k=0;k<boxes.size();k++){
                if(k!=boxes.size()){
                    int lastValue=boxes.get(k);
                    int newValue=lastValue-ps[i];
                    if(newValue>=0){
                        System.out.println("Replace k("+k+"): "+lastValue+"->"+newValue);
                        boxes.replace(k,newValue);
                        searchBoxes(ps,c,i+1,boxes,optimalBoxes);
                        boxes.replace(k,lastValue);
                    }
                }
            }
            boxes.put(boxes.size(),c-ps[i]);
            System.out.println("Created k("+(boxes.size()-1)+"): "+boxes.get(boxes.size()-1));
            searchBoxes(ps,c,i+1,boxes,optimalBoxes);
            boxes.remove(boxes.size()-1);
        }

        return optimalBoxes.size();
    }
}
