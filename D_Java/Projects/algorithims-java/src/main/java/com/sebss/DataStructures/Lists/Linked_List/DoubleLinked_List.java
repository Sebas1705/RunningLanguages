package com.sebss.DataStructures.Lists.Linked_List;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.Linked_List.Nodes.DNode;

public class DoubleLinked_List<T> implements ListS<T>{
    //Atributtes:
    protected DNode<T> start;
    protected DNode<T> last;
    protected int size;
    //End of Atributes.

    //Constructor:
    public DoubleLinked_List(){
        size=0;
        start=null;
        last=null;
    }
    public DoubleLinked_List(int defaultSize, T defaultValue) {
        this();
        for(int i=0;i<defaultSize;i++)add(defaultValue);
    }
    @SuppressWarnings("unchecked")
    public DoubleLinked_List(CollectionS<T> c){
        this();
        for(T e : (T[]) c.toArray())add(e);
    }
    @SuppressWarnings("unchecked")
    public DoubleLinked_List(T...e){
        this();
        for(T x : e)add(x);
    }
    //End of constructor.

    //Publics:
    public DNode<T> getStart(){return start;}
    public DNode<T> getLast(){return last;}
    //End of publics.

    //Privates:
    protected int search(T e,DNode<T> n,int nI){
        if(n==null)return -1;
        if(n.getElement().equals(e)) return nI;
        else return (n.getNextNode()==null)?-1:search(e,n.getNextNode(),nI+1);
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

    //Publics:
    public int lastIndexOf(T e) {
        for(int i=size-1;i>=0;i--)if(e.equals(getNode(i).getElement())) return i;
        return -1;
    }
    //End of publics.

    //Overrides:
    @Override
    public boolean add(T e) {
        if(size==0){
            start=new DNode<T>(e,null,null);
            size++;
            last=start;
            return true;
        }else{
            DNode<T> node = new DNode<T>(e,null,last);
            last.setNextNode(node);
            last=node;
            size++;
            return true;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(CollectionS<T> c) {
        for(T e : (T[]) c.toArray())add(e);
        return true;
    }
    @Override
    public void clear() {
        if(start!=null) for(int i=0;i<size;i++) remove(last.getElement());
    }
    @Override
    public boolean contains(T e) {
        if(start==null) return false;
        return search(e,start,0)!=-1;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(CollectionS<T> c) {
        for(T e : (T[]) c.toArray()) if(!contains(e)) return false;
        return true;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public boolean remove(T e) {
        int index = search(e,start,0);
        if(index==-1)return false;
        else if(index==0){
            start=start.getNextNode();
            start.setLastNode(null);
            size--;
        }else if(index==size-1){
            last=getNode(index-1);
            last.setNextNode(null);
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
    @SuppressWarnings("unchecked")
    @Override
    public boolean removeAll(CollectionS<T> c) {
        boolean removedAll=true;
        for(T e : (T[]) c.toArray()) if(!remove(e))removedAll=false;
        return removedAll;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(CollectionS<T> c) {
        if(start==null) return false;
        for(T e : (T[]) this.toArray()) if(!c.contains(e)) remove(e);
        return true;
    } 
    @Override
    public int size() {
        return size;
    }
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for(int i=0;i<size;i++) array[i] = get(i);
        return array;
    }
    @Override
    public void print() {
        System.out.println(this);
    }
    @Override
    public void add(int i, T e) {
        if(i<0||i>size||e==null) throw new IllegalArgumentException("IllegalArguments: add(int i, T e) from SimpleLinked_List");
        if(i==0){
            DNode<T> t = start;
            start = new DNode<T>(e,t,null);
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
        if(i<0||i>size) throw new IllegalArgumentException("IllegalArguments: addAll(int i, CollectionS<? extends T> c) from DoubleLinked_List");
        DoubleLinked_List<T> l = new DoubleLinked_List<T>(c);
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
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: get(int i) from DoubleLinked_List");
        DNode<T> l=getNode(i);
        return l.getElement();
    }
    @Override
    public int indexOf(T e) {
        return search(e,start,0);
    }
    @Override
    public T removeAt(int i) {
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: remove(int i) from DoubleLinked_List");
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
    public T set(int i, T e) {
        getNode(i).setElement(e);
        return e;
    }
    @Override
    public ListS<T> subList(int fi, int ti) {
        ListS<T> t = new DoubleLinked_List<T>();
        for(int i=fi;i<=ti;i++) t.add(getNode(i).getElement());
        return t;
    }
    @Override
    public String toString() {
        String s = "->DoubleLinked_List("+size+"):\n";
        if(start!=null) for(int i=0;i<size;i++)s+=getNode(i).toString();
        else s+="Empty\n";
        s+="->End of DoubleLinked_List.\n";
        return s;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void printAsArray() {
        String s = "DoubleLinked_List: ";
        if(start!=null)s+="["+join(",",(T[])toArray())+"] (size:"+size+")";
        else s+="Empty";
        System.out.println(s);
    }
    //End of Overrides. 
}
