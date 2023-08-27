package com.sebss.DataStructures.Lists.UsesList.Interfaces;

import com.sebss.DataStructures.Interfaces.CollectionS;

public interface QueueS<T> extends CollectionS<T>{
    public boolean push(T e);
    public boolean pushAll(CollectionS<T> c);
    public T pop();
    public void printAsArray();
}
