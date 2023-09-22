package com.sebss.DataStructures.Hashs.HashOpens;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.SimpleLinked_List;

public class HashOpenLinked<T> extends HashOpenList<T> {
    
    //Constructors:
    public HashOpenLinked(){
        this(10);
    }
    public HashOpenLinked(int maxS){
        maxSize=maxS;
        elements=new SimpleLinked_List<SimpleLinked_List<T>>(maxS,new SimpleLinked_List<T>());
    }
    @SuppressWarnings("unchecked")
    public HashOpenLinked(CollectionS<T> c){
        this(c.size());
        for(T e : (T[]) c.toArray()) add(e);
    }
    @SuppressWarnings("unchecked")
    public HashOpenLinked(int maxS,T...e){
        this(maxS);
        for(T x : e) add(x);
    }
    //End of constructors.

    //Overrides:
    @Override
    public String toString() {
        String s = "-->HashOpenLinked("+maxSize+"):\n";
        for(int i=0;i<maxSize;i++) {
            s+="->SimpleLinked_List-"+i+"-[";
            int max=elements.get(i).size();
            for(int j=0;j<max;j++){
                s+=elements.get(i).get(j);
                if(j!=max-1)s+=",";
            }
            s+="] size("+elements.get(i).size()+")\n";
        }         
        s+="-->End of HashOpenLinked.\n";
        return s;
    }
    @Override
    public void clear(){elements=new SimpleLinked_List<SimpleLinked_List<T>>(maxSize,new SimpleLinked_List<T>());}
    @Override
    public void printAsArray(){
        String s = "->HashOpenLinked("+maxSize+"):\n";
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
