package com.sebss.DataStructures.Lists.Linked_List;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.Nodes.DNode;

public class DoubleCircularLinked_List<T> extends DoubleLinked_List<T> {
    
    //Constructor:
    public DoubleCircularLinked_List(){
        super();
    }
    public DoubleCircularLinked_List(int defaultSize, T defaultValue) {
        super(defaultSize, defaultValue);
    }
    public DoubleCircularLinked_List(CollectionS<T> c){
        super(c);
    }
    @SuppressWarnings("unchecked")
    public DoubleCircularLinked_List(T...e){
        super(e);
    }
    //End of constructor.

    //Publics:
    public DNode<T> getStart(){return start;}
    public DNode<T> getLast(){return last;}
    //End of publics.

    //Privates:
    protected int search(T e,DNode<T> n,int nI){
        if(n==null)return -1;
        DNode<T> n1 = n;
        for(int i=0;i<size;i++) {
            if(n1.getElement().equals(e)) return nI;
            n1=n1.getNextNode();
            nI++;
        }
        return -1;
    }
    protected DNode<T> getNode(int index){
        if(index==0)return start;
        if(index==size-1)return last;
        if(index<size/2){
            DNode<T> node = start;
            for(int i=0;i<index;i++) node=node.getNextNode();
            return node;
        }else{
            DNode<T> node = last;
            for(int i=size;i>index;i--) node=node.getLastNode();
            return node;
        }
    }
    protected String join(String join, T[] array){
        String s = "";
        for(int i=0;i<array.length;i++){
            if(i==array.length-1) s+=String.valueOf(array[i]);
            else s+=String.valueOf(array[i])+join;
        }
        return s;
    }
    //End of Privates.

    //Overrides:
    @Override
    public boolean add(T e) {
        if(size==0){
            start=new DNode<T>(e,start,start);
            size++;
            last=start;
            return true;
        }else{
            DNode<T> node = new DNode<T>(e,start,last);
            last.setNextNode(node);
            last=node;
            size++;
            return true;
        }
    }
    @Override
    public boolean remove(T e) {
        int index = search(e,start,0);
        if(index==-1)return false;
        else if(index==0){
            start=start.getNextNode();
            start.setLastNode(last);
            size--;
        }else if(index==size-1){
            last=getNode(index-1);
            last.setNextNode(start);
            size--;
        }else{
            DNode<T> l=getNode(index-1),a=getNode(index+1);
            l.setNextNode(a);
            a.setLastNode(l);
            size--;
        }
        if(contains(e))return remove(e);
        return true;
    }
    @Override
    public void add(int i, T e) {
        if(i<0||i>size||e==null) throw new IllegalArgumentException("IllegalArguments: add(int i, T e) from DoubleCircularLinked_List");
        if(i==0){
            DNode<T> t = start;
            start = new DNode<T>(e,t,last);
            size++;
        }else if(i==size) add(e);
        else{
            DNode<T> l=getNode(i-1),a=getNode(i);
            DNode<T> n = new DNode<T>(e,a,l);
            l.setNextNode(n);
            a.setLastNode(n);
            size++;
        }
    }
    @Override
    public boolean addAll(int i, CollectionS<T> c) {
        if(i<0||i>size) throw new IllegalArgumentException("IllegalArguments: addAll(int i, CollectionS<? extends T> c) from DoubleCircularLinked_List");
        DoubleCircularLinked_List<T> l = new DoubleCircularLinked_List<T>(c);
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
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: get(int i) from DoubleCircularLinked_List");
        DNode<T> l=getNode(i);
        return l.getElement();
    }
    @Override
    public T removeAt(int i) {
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: remove(int i) from DoubleCircularLinked_List");
        if(i==0){
            T e = getNode(i).getElement();
            start = getNode(i+1);
            start.setLastNode(null);
            size--;
            return e;
        }else if(i==size-1){
            T e = getNode(i).getElement();
            getNode(i-1).setNextNode(null);
            size--;
            return e;
        }else{
            T e = getNode(i).getElement();
            DNode<T> l=getNode(i-1),a=getNode(i+1);
            l.setNextNode(a);
            a.setLastNode(l);
            size--;
            return e;
        }
    }
    @Override
    public String toString() {
        String s = "->DoubleCircularLinked_List("+size+"):\n";
        if(start!=null) for(int i=0;i<size;i++)s+=getNode(i).toString();
        else s+="Empty\n";
        s+="->End of DoubleCircularLinked_List.\n";
        return s;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void printAsArray() {
        String s = "DoubleCircularLinked_List: ";
        if(start!=null)s+="["+join(",",(T[])toArray())+"] (size:"+size+")";
        else s+="Empty";
        System.out.println(s);
    }
    //End of Overrides. 
}
