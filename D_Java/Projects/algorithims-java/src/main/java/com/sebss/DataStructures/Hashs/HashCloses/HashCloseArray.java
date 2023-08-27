package com.sebss.DataStructures.Hashs.HashCloses;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Array_List.Array_List;

public class HashCloseArray<T> extends HashCloseList<T> {

    //Constructors: 
    public HashCloseArray(){
        this(10);
    }
    public HashCloseArray(int maxS){
        maxSize=maxS;
        elements=new Array_List<T>(maxS,null);
        flagsB=new Array_List<Boolean>(maxS,false);
        flagsO=new Array_List<Boolean>(maxS,false);
    }
    @SuppressWarnings("unchecked")
    public HashCloseArray(CollectionS<T> c){
        this(c.size());
        for(T e : (T[]) c.toArray()) add(e);
    }
    @SuppressWarnings("unchecked")
    public HashCloseArray(int maxS,T...e){
        this(maxS);
        for(T x : e) add(x);
    }
    //End of constructors.

    //Overrides:
    @Override
    public void clear() {elements=new Array_List<T>(maxSize,null);}
    @Override
    public void printAsArray() {
        String s = "HashCloseArray: [";
        if(maxSize!=0) for(int i=0;i<maxSize;i++)s+=(i!=maxSize-1)?elements.get(i)+",":elements.get(i);
        else s+="Empty";
        s+="] size("+maxSize+")\n";
        System.out.println(s);
    }
    @Override
    public String toString(){
        String s = "->HashCloseArray("+maxSize+"):\n[";
        if(maxSize!=0) for(int i=0;i<maxSize;i++)s+=(i!=maxSize-1)?elements.get(i)+",":elements.get(i);
        else s+="Empty";
        s+="]\n->End of HashCloseArray.\n";
        return s;
    }
    //End of Overrides.    
}
