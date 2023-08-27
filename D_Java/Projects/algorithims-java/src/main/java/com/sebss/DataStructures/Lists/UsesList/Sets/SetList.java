package com.sebss.DataStructures.Lists.UsesList.Sets;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.UsesList.Interfaces.SetS;

public abstract class SetList<T> implements SetS<T>{
    
    //Atributtes:
    protected ListS<T> set;
    //End of atributtes.

    //Overrides:
    @Override
    public boolean isEmpty() {return set.isEmpty();}
    @Override
    public int size() {return set.size();}
    @Override
    public Object[] toArray() {return set.toArray();}
    @Override
    public boolean contains(T e) {return set.contains(e);}
    @Override
    public boolean containsAll(CollectionS<T> c) {return set.containsAll(c);}
    @Override
    public void clear() {set.clear();}
    @Override
    public void print() {System.out.println(this);}
    @Override
    public boolean add(T e) {
        if(contains(e))return false;
        return set.add(e);
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(CollectionS<T> c) {
        for(T e : (T[]) c.toArray())add(e);
        return true;  
    }
    @Override
    public boolean remove(T e) {return set.remove(e);}
    @Override
    public boolean removeAll(CollectionS<T> c) {return set.removeAll(c);}
    @Override
    public boolean retainAll(CollectionS<T> c) {return set.retainAll(c);}
    @Override
    public void add(int i, T e) {if(!contains(e))add(i,e);}
    @Override
    public boolean addAll(int i, CollectionS<T> c) {return set.addAll(i,c);}
    @Override
    public T get(int i) {return set.get(i);}
    @Override
    public int indexOf(T e) {return set.indexOf(e);}
    @Override
    public T removeAt(int i) {return set.removeAt(i);}
    @Override
    public T set(int i, T e) {return set.set(i,e);}
    @Override
    public ListS<T> subList(int fi, int ti) {return set.subList(fi,ti);}
    @Override
    public abstract void printAsArray();
    //End of Overrides.

}
