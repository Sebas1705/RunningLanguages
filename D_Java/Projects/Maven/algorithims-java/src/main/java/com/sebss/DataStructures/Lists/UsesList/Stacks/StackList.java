package com.sebss.DataStructures.Lists.UsesList.Stacks;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.UsesList.Interfaces.StackS;

public abstract class StackList<T> implements StackS<T> {
    
    //Atributtes:
    protected ListS<T> stack;
    //End of Atributtes.
    
    //Overrides:
    @Override
    public boolean isEmpty() {return stack.size()==0;}
    @Override
    public int size() {return stack.size();}
    @Override
    public Object[] toArray() {return stack.toArray();}
    @Override
    public boolean contains(T e) {return stack.contains(e);}
    @Override
    public boolean containsAll(CollectionS<T> c) {return stack.containsAll(c);}
    @Override
    public void clear() {stack.clear();}
    @Override
    public boolean push(T e) {return stack.add(e);}
    @Override
    public boolean pushAll(CollectionS<T> c) {return stack.addAll(c);}
    @Override
    public T pop() {return stack.removeAt(stack.size()-1);}
    @Override
    public void print(){System.out.println(this);}
    @Override
    public abstract void printAsArray();
    //End of Overrides.

}
