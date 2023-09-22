package com.sebss.DataStructures.Hashs.HashCloses;

import com.sebss.DataStructures.Hashs.HashS;
import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;

public abstract class HashCloseList<T> implements HashS<T> {
    
    //Atributes: 
    protected ListS<T> elements;
    protected ListS<Boolean> flagsB,flagsO;
    protected int maxSize;
    //End of attributes.

    //Privates: 
    protected boolean isFull(){
        boolean isFull=true;
        for(Object o : elements.toArray())if(o==null)isFull=false;
        return isFull;
    }
    //End of privates.

    //Overrides:
    @Override
    public boolean isEmpty() {
        boolean isEmpty=true;
        for(int i=0;i<maxSize;i++)
            if(elements.get(i)!=null)
                isEmpty=false;
        return isEmpty;
    }
    @Override
    public int size() {return maxSize;}
    @Override
    public Object[] toArray() {return elements.toArray();}
    @Override
    public boolean contains(T e) {return elements.contains(e);}
    @Override
    public boolean containsAll(CollectionS<T> c) {return elements.containsAll(c);}
    @Override
    public void print() {System.out.println(this);}
    @Override
    public boolean add(T e) {
        if(isFull())return false;
        if(contains(e))return false;
        int code=e.hashCode()%maxSize;
        while(flagsO.get(code))code=(code+1)%maxSize;
        elements.set(code,e);
        flagsO.set(code,true);
        flagsB.set(code,false);
        return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(CollectionS<T> c) {
        boolean t=true;
        for(T e : (T[]) c.toArray())if(!add(e))t=false;
        return t;
    }
    @Override
    public boolean remove(T e) {
        if(!contains(e))return false;
        int code=e.hashCode()%maxSize;
        while(!elements.get(code).equals(e)&&!flagsB.get(code))code++;
        elements.set(code,null);
        flagsB.set(code,true);
        flagsO.set(code,false);
        return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean removeAll(CollectionS<T> c) {
        boolean removeAll=true;
        for(T e : (T[]) c.toArray())if(!remove(e))removeAll=false;
        return removeAll;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(CollectionS<T> c) {
        for(T e : (T[]) c.toArray()){
            if(!c.contains(e)) remove(e);
        }
        return true;
    }
    @Override
    public T get(int i) {return elements.get(i);}
    @Override
    public int indexOf(T e) {return elements.indexOf(e);}
    @Override
    public T removeAt(int hashCode) {return elements.removeAt(hashCode%maxSize);}
    @Override
    public ListS<T> subList(int fi, int ti) {return elements.subList(fi,ti);}
    @Override
    public abstract void clear();
    @Override
    public abstract void printAsArray();
    //End of Overrides.
}
