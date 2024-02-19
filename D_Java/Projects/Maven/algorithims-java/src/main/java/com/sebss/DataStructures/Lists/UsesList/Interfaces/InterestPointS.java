package com.sebss.DataStructures.Lists.UsesList.Interfaces;

import com.sebss.DataStructures.Interfaces.CollectionS;

public interface InterestPointS<T> extends CollectionS<T>{
    public void insert(T element);
    public void remove();
    public void init();
    public void end();
    public void next();
    public void previous();
}
