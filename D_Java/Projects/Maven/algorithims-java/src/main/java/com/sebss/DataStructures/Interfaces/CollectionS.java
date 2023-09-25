package com.sebss.DataStructures.Interfaces;

import com.sebss.Interfaces.Printable;

public interface CollectionS<T> extends Printable{
    public boolean isEmpty();
    public int size();
    public Object[] toArray();
    public boolean contains(T e);
    public boolean containsAll(CollectionS<T> c);
    public void clear();
}
