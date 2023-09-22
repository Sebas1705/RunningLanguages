package com.sebss.DataStructures.Lists.Array_List;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.ListS;

public class Array_List<T> implements ListS<T>{

    //Atributtes: 
    private final int CAP_GROWTH;
    private Object array[];
    private int size; 
    private int capacity;
    //End of atributes.

    //Constructor:
    public Array_List(){
        CAP_GROWTH=4;
        array=new Object[CAP_GROWTH];
        size=0;
        capacity=CAP_GROWTH;
    }
    public Array_List(int defaultSize, T defaultValue) {
        this();
        for(int i=0;i<defaultSize;i++)add(defaultValue);
    }
    @SuppressWarnings("unchecked")
    public Array_List(CollectionS<T> c){
        this();
        for(T e : (T[]) c.toArray()) add(e);
    }
    @SuppressWarnings("unchecked")
    public Array_List(T ...e){
        this();
        for(T t : e) add(t);
    }
    //End of constructor.

    //Privates:
    private Object[] reverse(Object[] arr){
        Object[] temp = new Object[arr.length];
        for(int i=0;i<arr.length;i++) temp[i]=arr[arr.length-1-i];
        return temp;
    }
    private int search(T e,int start){
        for(int i=start;i<size;i++){
            if(array[i]==null) continue;
            if(array[i].equals(e)) return i;
        }
        return -1;
    }
    private void growCapacity(){
        Object a[] = new Object[capacity+CAP_GROWTH];
        capacity+=CAP_GROWTH;
        for(int i=0;i<capacity-CAP_GROWTH;i++) a[i]=array[i];
        array=a;
    }
    private void reduceCapacity(){
        Object a[] = new Object[capacity-CAP_GROWTH];
        capacity-=CAP_GROWTH;
        for(int i=0;i<capacity;i++) a[i]=array[i];
        array=a;
    }
    private void reallocArrayMinus(int toIndex, int fromIndex){        
        for(int i=toIndex,j=fromIndex; i<size&&j<size;i++,j++){
            array[i]=array[j];
        }
    }
    private void reallocArrayPlus(int toIndex, int fromIndex){
        Object temp[] = new Object[size-fromIndex];
        for(int i=fromIndex;i<size;i++) temp[i-fromIndex]=array[i];
        for(int i=toIndex;i<size;i++) array[i]=temp[i-toIndex];
    }
    //End of privates.

    //Publics:
    public int lastIndexOf(T e) {
        if(search(e,0)==-1)return -1;
        int index=0,x=0;
        do{
            index=x;
            x=search(e,index+1);
        }while(x!=-1);
        return index;
    }
    //End of publics.

    //Overrides:
    @Override
    public boolean add(T e) {
        if(size==capacity) growCapacity();
        array[size]=e;
        size++;
        return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(CollectionS<T> c) {
        for(T e : (T[]) c.toArray()) add(e);
        return true;
    }
    @Override
    public void clear() {
        array=new Object[CAP_GROWTH];
        capacity=0;
        size=0;
    }
    @Override
    public boolean contains(T e) {
        return search(e,0)!=-1;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(CollectionS<T> c) {
        boolean allFind = true;
        for(T x : (T[]) c.toArray()) if(!contains(x)) allFind=false;
        return allFind;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public boolean remove(T e) {
        int index=search(e,0);
        if(index!=-1){
            reallocArrayMinus(index,index+1);
            size--;
            if(size==capacity-CAP_GROWTH) reduceCapacity();
            if(contains(e)) return remove(e);
            return true;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean removeAll(CollectionS<T> c) {
        if(containsAll(c)){
            for(T e : (T[]) c.toArray()) remove(e);
            return true;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(CollectionS<T> c) {
        for(T e : (T[]) array){
            if(!c.contains(e)) remove(e);
        }
        return true;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Object[] toArray() {
        return array;
    }
    @Override
    public void print() {
        System.out.println(this);
    }
    @SuppressWarnings("unchecked")
    @Override
    public void add(int i, T e) {
        if(i<0||i>size) throw new IllegalArgumentException("IllegalArguments: add(int i, T e) from Array_List");
        if(i==size)add(e);
        else{
            T x = (T) array[size-1];
            if(size==capacity)growCapacity();
            reallocArrayPlus(i+1,i);
            array[i]=e;
            array[size]=x;
            size++;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(int i, CollectionS<T> c) {
        if(i<0||i>size) throw new IllegalArgumentException("IllegalArguments: addAll(int i, CollectionS<? extends T> c) from Array_List");
        Object[] arr=c.toArray();
        arr=reverse(arr);
        for(T e : (T[]) arr) add(i, e);
        return true;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T get(int i) {
        if(i<0||i>size) throw new IllegalArgumentException("IllegalArguments: get(int i) from Array_List");
        return (T)array[i];
    }
    @Override
    public int indexOf(T e) {
        return search(e,0);
    }
    @SuppressWarnings("unchecked")
    @Override
    public T removeAt(int i) {
        if(i<0||i>=size) throw new IllegalArgumentException("IllegalArguments: removeAt(int i) from Array_List");
        T e = (T) array[i];
        remove(e);
        return e;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T set(int i, T e) {
        T x = (T) array[i];
        array[i]=e;
        return x;
    }
    @SuppressWarnings("unchecked")
    @Override
    public ListS<T> subList(int fi, int ti) {
        if(fi<0||fi>=size||ti<0||ti>=size) throw new IllegalArgumentException("IllegalArguments: subList(int fi, int ti) from Array_List");
        ListS<T> t = new Array_List<>();
        for(int i=fi;i<=ti;i++) t.add((T)array[i]);
        return t;
    }
    @Override
    public void printAsArray() {
        String s = "Array_List: [";
        if(size!=0) for(int i=0;i<size;i++)s+=(i!=size-1)?array[i]+",":array[i];
        else s+="Empty";
        s+="] size("+size+")\n";
        System.out.println(s);
    }
    @Override
    public String toString(){
        String s = "->Array_List("+size+"):\n[";
        if(size!=0) for(int i=0;i<size;i++)s+=(i!=size-1)?array[i]+",":array[i];
        else s+="Empty";
        s+="]\n->End of Array_List.\n";
        return s;
    }
    //End of Overrides.
}
