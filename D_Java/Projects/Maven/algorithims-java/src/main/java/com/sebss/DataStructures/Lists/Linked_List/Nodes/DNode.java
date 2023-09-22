package com.sebss.DataStructures.Lists.Linked_List.Nodes;

import com.sebss.Interfaces.Printable;

public class DNode<T> implements Printable{
    
    //Atributtes:
    private static int GenCode=0;
    private final int code;
    private T element;
    private DNode<T> nextNode;
    private DNode<T> lastNode;
    //End of Atributtes.

    //Constructor:
    public DNode(T element, DNode<T> nextNode, DNode<T> lastNode) {
        this.code=GenCode++;
        this.element=element;
        this.nextNode=nextNode;
        this.lastNode=lastNode;
    }
    //End of constructor.

    //Getters:
    public T getElement() {return element;}
    public int getCode() {return code;}
    public DNode<T> getNextNode() {return nextNode;}
    public DNode<T> getLastNode() {return lastNode;}
    //End of Getters.

    //Setters:
    public void setElement(T element) {this.element=element;}
    public void setNextNode(DNode<T> nextNode) {this.nextNode=nextNode;}
    public void setLastNode(DNode<T> lastNode) {this.lastNode=lastNode;}
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
        s+=") | last(";
        s+=(lastNode==null)?"null":lastNode.getCode();
        s+=") | Element: "+element+"\n";
        return s;
    }
    //End of Overrides.
}
