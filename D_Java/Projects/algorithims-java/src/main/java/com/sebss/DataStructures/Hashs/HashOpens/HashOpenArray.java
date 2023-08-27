package com.sebss.DataStructures.Hashs.HashOpens;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Array_List.Array_List;

public class HashOpenArray<T> extends HashOpenList<T> {
    
    //Constructors:
    public HashOpenArray(){
        this(10);
    }
    public HashOpenArray(int maxS){
        maxSize=maxS;
        elements=new Array_List<Array_List<T>>(maxS,new Array_List<T>());
    }
    @SuppressWarnings("unchecked")
    public HashOpenArray(CollectionS<T> c){
        this(c.size());
        for(T e : (T[]) c.toArray()) add(e);
    }
    @SuppressWarnings("unchecked")
    public HashOpenArray(int maxS,T...e){
        this(maxS);
        for(T x : e) add(x);
    }
    //End of constructors.

    //Overrides:
    @Override
    public String toString() {
        String s = "-->HashOpenArray("+maxSize+"):\n";
        for(int i=0;i<maxSize;i++) {
            s+="->ArrayList-"+i+"-[";
            int max=elements.get(i).size();
            for(int j=0;j<max;j++){
                s+=elements.get(i).get(j);
                if(j!=max-1)s+=",";
            }
            s+="] size("+elements.get(i).size()+")\n";
        }         
        s+="-->End of HashOpenArray.\n";
        return s;
    }
    @Override
    public void clear(){elements=new Array_List<Array_List<T>>(maxSize,new Array_List<T>());}
    @Override
    public void printAsArray(){
        String s = "->HashOpenArray("+maxSize+"):\n";
        for(int i=0;i<maxSize;i++) {
            s+="[";
            int max=elements.get(i).size();
            for(int j=0;j<max;j++){
                s+=elements.get(i).get(j);
                if(j!=max-1)s+=",";
            }
            s+="]\n";
        }
        System.out.println(s);
    }
    //End of Overrides.
}
