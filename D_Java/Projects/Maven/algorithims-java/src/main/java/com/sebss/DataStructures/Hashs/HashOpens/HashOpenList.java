package com.sebss.DataStructures.Hashs.HashOpens;

import com.sebss.DataStructures.Hashs.HashS;
import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;

public abstract class HashOpenList<T> implements HashS<T> {
    
    //Atributes: 
    protected ListS<ListS<T>> elements;
    protected int maxSize;
    //End of attributes.

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
    public boolean contains(T e) {return elements.get(e.hashCode()%maxSize).contains(e);}
    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(CollectionS<T> c) {
        boolean containsAll=true;
        for(T e : (T[]) c.toArray())
            if(!elements.get(e.hashCode()%maxSize).contains(e))
                containsAll=false;
        return containsAll;
    }
    @Override
    public void print() {System.out.println(this);}
    @Override
    public boolean add(T e) {
        if(contains(e))return false;
        return elements.get(e.hashCode()%maxSize).add(e);
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
        return elements.get(e.hashCode()%maxSize).remove(e);
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
    public T get(int i) {return elements.get(i).get(0);}
    @Override
    public int indexOf(T e) {return elements.get(e.hashCode()%maxSize).indexOf(e);}
    @Override
    public T removeAt(int hashCode) {return elements.get(hashCode%maxSize).removeAt(0);}
    @Override
    public ListS<T> subList(int fi, int ti) {return null;}
    @Override
    public abstract void clear();
    @Override
    public abstract void printAsArray();
    //End of Overrides.
}
