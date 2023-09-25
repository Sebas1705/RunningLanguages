package com.sebss.DataStructures.Lists.UsesList.PriorityList;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.UsesList.Interfaces.PriorityS;

public abstract class PriorityList<T> implements PriorityS<T>{
    
    //Atributtes:
    protected ListS<PriorityObject<T>> pList;
    //End of atributtes.

    //Privates:
    protected boolean isIn(T e){
        for(int i=0;i<pList.size();i++) if(pList.get(i).getObject().equals(e)) return true;
        return false;
    }
    protected int searchPos(int priority){
        for(int i=0;i<pList.size();i++){
            int pTemp = pList.get(i).getPriorityGrade();
            if(pTemp>=priority)return i;
        }
        return size();
    }
    protected int searchIndex(T e){
        for(int i=0;i<pList.size();i++){
            T pTemp = pList.get(i).getObject();
            if(pTemp.equals(e))return i;
        }
        return -1;
    }
    //End of privates.

    //Override:
    @Override
    public boolean isEmpty() {return pList.isEmpty();}
    @Override
    public int size() {return pList.size();}
    @Override
    public Object[] toArray() {return pList.toArray();}
    @Override
    public boolean contains(T e) {return isIn(e);}
    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(CollectionS<T> c) {
        for(T e : (T[]) c.toArray()) if(!contains(e)) return false;
        return true;
    }
    @Override
    public void clear() {pList.clear();}
    @Override
    public void print() {System.out.println(this);}
    @Override
    public boolean add(T e, int priority) {
        int index = searchPos(priority);
        PriorityObject<T> p = new PriorityObject<>(e, priority);
        pList.add(index,p);
        return true;
    }
    @Override
    public boolean addAll(CollectionS<PriorityObject<T>> c) {return pList.addAll(c);}
    @Override
    public boolean remove(T e) {
        int index=searchIndex(e);
        if(index==-1) return false;
        pList.removeAt(index);
        return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean removeAll(CollectionS<T> c) {
        for(T e : (T[])c.toArray()) remove(e);
        return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(CollectionS<T> c) {
        for(T e : (T[])toArray())if(!c.contains(e)) remove(e);
        return true;
    }
    @Override
    public T get(int i) {return pList.get(i).getObject();}
    @Override
    public int indexOf(PriorityObject<T> e) {return pList.indexOf(e);}
    @Override
    public int lastIndexOf(PriorityObject<T> e) {return pList.indexOf(e);}
    @Override
    public T removeAt(int i) {return pList.removeAt(i).getObject();}
    @Override
    public abstract ListS<T> subList(int fi, int ti);
    @Override
    public abstract void printAsArray();
}
