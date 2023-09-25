package com.sebss.DataStructures.Hashs.HashCloses;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.SimpleLinked_List;

public class HashCloseLinked<T> extends HashCloseList<T> {
    
    //Constructors: 
    public HashCloseLinked(){
        this(10);
    }
    public HashCloseLinked(int maxS){
        maxSize=maxS;
        elements=new SimpleLinked_List<T>(maxS,null);
        flagsB=new SimpleLinked_List<Boolean>(maxS,false);
        flagsO=new SimpleLinked_List<Boolean>(maxS,false);
    }
    @SuppressWarnings("unchecked")
    public HashCloseLinked(CollectionS<T> c){
        this(c.size());
        for(T e : (T[]) c.toArray()) add(e);
    }
    @SuppressWarnings("unchecked")
    public HashCloseLinked(int maxS,T...e){
        this(maxS);
        for(T x : e) add(x);
    }
    //End of constructors.

    //Overrides:
    @Override
    public void clear() {elements=new SimpleLinked_List<T>(maxSize,null);}
    @Override
    public void printAsArray() {
        String s = "SimpleLinked_List: [";
        if(maxSize!=0) for(int i=0;i<maxSize;i++)s+=(i!=maxSize-1)?elements.get(i)+",":elements.get(i);
        else s+="Empty";
        s+="] size("+maxSize+")\n";
        System.out.println(s);
    }
    @Override
    public String toString(){
        String s = "->SimpleLinked_List("+maxSize+"):\n[";
        if(maxSize!=0) for(int i=0;i<maxSize;i++)s+=(i!=maxSize-1)?elements.get(i)+",":elements.get(i);
        else s+="Empty";
        s+="]\n->End of SimpleLinked_List.\n";
        return s;
    }
    //End of Overrides.   
}
