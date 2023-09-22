package com.sebss.DataStructures.Lists.UsesList.Interfaces;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.UsesList.PriorityList.PriorityObject;

public interface PriorityS<T> extends CollectionS<T> {
    public boolean add(T e,int priority);
    public boolean addAll(CollectionS<PriorityObject<T>> c);
    public boolean remove(T e);
    public boolean removeAll(CollectionS<T> c);
    public boolean retainAll(CollectionS<T> c);
    public T get(int i);
    public int indexOf(PriorityObject<T> e);
    public int lastIndexOf(PriorityObject<T> e);
    public T removeAt(int i);
    public ListS<T> subList(int fi, int ti);
    public void printAsArray();
}
