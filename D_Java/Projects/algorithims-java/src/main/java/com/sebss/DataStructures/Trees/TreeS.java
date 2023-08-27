package com.sebss.DataStructures.Trees;

import com.sebss.DataStructures.Interfaces.CollectionS;

public interface TreeS<T> extends CollectionS<T> {
    public int getHight();
    public int getSize();
    public int getOrder();
    public int getGrade();
    public int isPerfect();
    public TreeS<T> getSubTree(T e);
    public TreeS<T> getSubTree(int hight, int grade);
    public boolean add(T e);
    public boolean add(T e, T inE);
    public int[] search(T e);
    public boolean removeSubArbol(T e);
    public boolean removeSubArbol(int hight, int grade);
}
