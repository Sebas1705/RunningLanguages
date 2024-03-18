#include "./orderedList.h"
#include <assert.h>
#include <stdlib.h>
#include <stdio.h>

template <typename T> OrderedList<T>::OrderedList(){
    this->list = ArrayList<T>();
}

template <typename T> const bool OrderedList<T>::isOrdered(){
    for(int i=1;i<this->list.size();i++)
        if(this->list.get(i-1)>this->list.get(i))
            return false;
    return true;
}

template<typename T> const T OrderedList<T>::getValue(const int index){
    return this->list.get(index);
}

template<typename T> const int OrderedList<T>::searchPosition(const T value,const int first,const int nList){
    assert(nList >= 1);
	int n=this->list->n;
	int nListPos=first+(nList-1); // Posici�n de fin de la sublista
	assert(first>=0&&first<n);
	assert(nListPos>=0&&nListPos<n);
	assert(first<=nListPos);
    int mid = (first+nListPos)/2;
    T valueMid = getValue(mid);
    if(valueMid==value) return mid;
    else if(value > valueMid){
        int nSubList = nListPos-(mid+1)+1;
        if(nSubList==0) return nListPos+1;
        else return searchPosition(value,mid+1,nSubList);
    }else{
        int nSubList = (mid-1)-first+1;
        if(nSubList==0) return first;
        else return searchPosition(value,first,nSubList);
    }
}

template<typename T> const int OrderedList<T>::searchInOrder(const T value){
    if(this->list->n==0) return -1;
    else {
        int pos = searchPosition(value,0,this->list->n);
        if(pos==this->list->n) return -1;
        else if(getValue(pos).equals(value)) return pos;
        else return -1;
    }
}

template<typename T> void OrderedList<T>::insertInOrder(const T value){
    if(this->list->n==0) insert(0,value);
    else{
        int pos = searchPosition(value,0,this->list->n);
        insert(pos,value);
    }
}

template<typename T> void OrderedList<T>::removeInOrder(const T value){
    assert(searchInOrder(value)!=-1);
    int pos = searchPosition(value,0,this->list->n);
    removeInList(pos);
}

template<typename T> const bool OrderedList<T>::isEmpty(){
    return this->list.isEmpty();
}

template<typename T> const string OrderedList<T>::toString(){
    ostringstream oss;
    oss << "LinkedList::(";
    for(int i=0;i<this->n;i++)
        oss << this->array[i].toString() << (i==this->n-1)?")":",";
    return oss.str();
}

template<typename T> OrderedList<T>::~OrderedList(){
    while(this->n>0) removeAtIndex(0);
}