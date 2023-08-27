package com.sebss.DataStructures.Lists.UsesList.Queue;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.UsesList.Interfaces.QueueS;

public abstract class QueueList<T> implements QueueS<T> {
    
    //Atributtes:
    protected ListS<T> queue;
    //End of Atributtes.
    
    //Overrides:
    @Override
    public boolean isEmpty() {return queue.size()==0;}
    @Override
    public int size() {return queue.size();}
    @Override
    public Object[] toArray() {return queue.toArray();}
    @Override
    public boolean contains(T e) {return queue.contains(e);}
    @Override
    public boolean containsAll(CollectionS<T> c) {return queue.containsAll(c);}
    @Override
    public void clear() {queue.clear();}
    @Override
    public boolean push(T e) {return queue.add(e);}
    @Override
    public boolean pushAll(CollectionS<T> c) {return queue.addAll(c);}
    @Override
    public T pop() {return queue.removeAt(0);}
    @Override
    public void print(){System.out.println(this);}
    @Override
    public abstract void printAsArray();
    //End of Overrides.

}
