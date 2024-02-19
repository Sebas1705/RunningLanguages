package com.sebss.DataStructures.Lists.UsesList.InterestPointList;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.Linked_List.DoubleLinked_List;
import com.sebss.DataStructures.Lists.Linked_List.Nodes.DNode;
import com.sebss.DataStructures.Lists.UsesList.Interfaces.InterestPointS;
import com.sebss.DataStructures.Lists.UsesList.PriorityList.PriorityObject;

public class InterestPointList<T> implements InterestPointS<T> {
    
    //Atributtes:
    protected DoubleLinked_List<T> pList;
    protected DNode<T> interestPoint;
    //End of atributtes.

    //Privates:
    
    //End of privates.

    //Override:
    @Override
    public void insert(T element){
        interestPoint.setElement(element);
    }
    @Override
    public void remove(){
        pList.remove(interestPoint.getElement());
    }
    @Override
    public void init(){
        interestPoint = pList.getStart();
    }
    @Override
    public void end(){
        interestPoint = pList.getLast();
    }
    @Override
    public void next(){
        DNode<T> node = interestPoint.getNextNode();
        if(node!=null){
            interestPoint = node;
        }
    }
    @Override
    public void previous(){
        DNode<T> node = interestPoint.getLastNode();
        if(node!=null){
            interestPoint = node;
        }
    }
    @Override
    public boolean isEmpty(){
        return pList.isEmpty();
    }
    @Override
    public int size(){
        return pList.size();
    }
    @Override
    public Object[] toArray(){
        return pList.toArray();
    }
    @Override
    public boolean contains(T e){
        return pList.contains(e);
    }
    @Override
    public boolean containsAll(CollectionS<T> c){
        return pList.containsAll(c);
    }
    @Override
    public void clear(){
        pList.clear();
    }
    @Override
    public void print(){
        pList.print();
    }

}
