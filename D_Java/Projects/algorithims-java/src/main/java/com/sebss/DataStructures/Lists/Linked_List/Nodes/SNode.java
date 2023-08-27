package com.sebss.DataStructures.Lists.Linked_List.Nodes;

import com.sebss.Interfaces.Printable;

public class SNode<T> implements Printable{
    
    //Atributtes:
    private static int GenCode=0;
    private final int code;
    private T element;
    private SNode<T> nextNode;
    //End of Atributtes.

    //Constructor:
    public SNode(T element, SNode<T> nextNode) {
        this.code=GenCode++;
        this.element=element;
        this.nextNode=nextNode;
    }
    //End of constructor.

    //Getters:
    public T getElement() {return element;}
    public int getCode() {return code;}
    public SNode<T> getNextNode() {return nextNode;}
    //End of Getters.

    //Setters:
    public void setElement(T element) {this.element=element;}
    public void setNextNode(SNode<T> nextNode) {this.nextNode=nextNode;}
    //End of Setters.

    //Overrides:
    @Override
    public void print(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        String s = "Node "+code+": next(";
        s+=(nextNode==null)?"null":nextNode.getCode();
        s+=") | Element: "+element;
        return s;
    }
    //End of Overrides.
}