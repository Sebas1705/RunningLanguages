package com.sebss.DataStructures.Lists.Linked_List;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.Nodes.SNode;


public class SimpleCircularLinked_List<T> extends SimpleLinked_List<T>{    

    //Constructor:
    public SimpleCircularLinked_List(){
        super();
    }
    public SimpleCircularLinked_List(CollectionS<T> c){
        super(c);
    }
    public SimpleCircularLinked_List(int defaultSize, T defaultValue){
        super(defaultSize, defaultValue);
    }
    @SuppressWarnings("unchecked")
    public SimpleCircularLinked_List(T...e){
        super(e);
    }

    //End of constructor.

    //Privates:
    @Override
    protected int search(T e,SNode<T> n,int nI){
        if(n==null)return -1;
        SNode<T> n1 = n;
        for(int i=0;i<size;i++) {
            if(n1.getElement().equals(e)) return nI;
            n1=n1.getNextNode();
            nI++;
        }
        return -1;
    }
    //End of Privates.

    //Overrides:
    @Override
    public boolean add(T e) {
        if(size==0){
            start=new SNode<T>(e,start);
            size++;
            last=start;
            return true;
        }else{
            last.setNextNode(new SNode<T>(e,start));
            last=last.getNextNode();
            size++;
            return true;
        }
    }
    @Override
    public void add(int i, T e) {
        if(i<0||i>size||e==null) throw new IllegalArgumentException("IllegalArguments: add(int i, T e) from SimpleCircularLinked_List");
        if(i==0){
            SNode<T> t = start;
            start = new SNode<T>(e,t);
            size++;
        }else if(i==size) add(e);
        else{
            SNode<T> l=getNode(i-1),a=getNode(i);
            SNode<T> n = new SNode<T>(e,a);
            l.setNextNode(n);
            size++;
        }
    }
    @Override
    public boolean addAll(int i, CollectionS<T> c) {
        if(i<0||i>size) throw new IllegalArgumentException("IllegalArguments: addAll(int i, CollectionS<? extends T> c) from SimpleCircularLinked_List");
        SimpleLinked_List<T> l = new SimpleLinked_List<T>(c);
        for(int j=0;j<size;j++){
            if(j<i)l.add(j,getNode(j).getElement());
            else l.add(getNode(j).getElement());
        }
        start = l.getNode(0);
        last = l.getNode(l.size()-1);
        size = l.size();
        return true;
    }
    @Override
    public T get(int i) {
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: get(int i) from SimpleCircularLinked_List");
        SNode<T> l=getNode(i);
        return l.getElement();
    }
    @Override
    public boolean remove(T e) {
        int index = search(e,start,0);
        if(index==-1)return false;
        else if(index==0){
            start=start.getNextNode();
            last.setNextNode(start);
            size--;
        }else if(index==size-1){
            last=getNode(index-1);
            last.setNextNode(start);
            size--;
        }else{
            SNode<T> l=getNode(index-1),a=getNode(index+1);
            l.setNextNode(a);
            size--;
        }
        if(contains(e))return remove(e);
        return true;
    }
    @Override
    public T removeAt(int i) {
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: remove(int i) from SimpleCircularLinked_List");
        if(i==0){
            T e = getNode(i).getElement();
            start = getNode(i+1);
            size--;
            return e;
        }else if(i==size-1){
            T e = getNode(i).getElement();
            last = getNode(i-1);
            last.setNextNode(start);
            size--;
            return e;
        }else{
            T e = getNode(i).getElement();
            SNode<T> l=getNode(i-1),a=getNode(i+1);
            l.setNextNode(a);
            size--;
            return e;
        }
    }
    @Override
    public String toString() {
        String s = "->SimpleCircularLinked_List("+size+"):\n";
        if(start!=null) for(int i=0;i<size;i++)s+=getNode(i).toString();
        else s+="Empty\n";
        s+="->End of SimpleCircularLinked_List.\n";
        return s;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void printAsArray() {
        String s = "SimpleCircularLinked_List: ";
        if(start!=null)s+="["+join(",",(T[])toArray())+"] (size:"+size+")";
        else s+="Empty";
        System.out.println(s);
    }
    //End of Overrides. 
}