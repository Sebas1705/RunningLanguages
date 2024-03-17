#include "./doubleLinkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

template <typename T> const DoubleNode<T>* DoubleLinkedList<T>::getNode(const int index){
    assert(index<this->n&&index>=0);
    DoubleNode<T>* n = this->firstNode;
    for(int i=0;i<index;i++)
        n = n->nextNode;
    return n;
}

template <typename T> DoubleLinkedList<T>::DoubleLinkedList(){
    this->first = NULL;
    this->n = 0;
}

template <typename T> void DoubleLinkedList<T>::setValue(const int index,const T value){
    getNode(index)->value = DoubleNode<T>(value);
}

template<typename T> const T DoubleLinkedList<T>::getValue(const int index){
    return getNode(index)->value;
}

template<typename T> void DoubleLinkedList<T>::insert(const int index,const T value){
    assert(index<=this->n&&index>=0);
    DoubleNode<T>* n = &DoubleNode<T>(value);
    if(this->n==0) this->firstNode = n;
    else{
        if(index==0){
            n->nextNode = this->firstNode;
            this->firstNode = n;
        }else if(index==this->n){
            DoubleNode<T>* last = getNode(list,index-1);
            last->nextNode = n;
            n->prevNode = last;
        }
        else
        {
            DoubleNode<T>* prev = getNode(list,index-1);
            DoubleNode<T>* next = prev->nextNode;
            prev->nextNode = n;
            next->prevNode = n;
            n->nextNode = next;
            n->prevNode = prev;
        }
    }  
    this->n++;
}

template<typename T> void DoubleLinkedList<T>::insertLast(const T value){
    insert(this->n,value);
}

template<typename T> void DoubleLinkedList<T>::removeAtIndex(const int index){
    assert(index<this->n&&index>=0);
    DoubleNode<T>* eleminated;
    if(index==0){
        eleminated = this->firstNode;
        DoubleNode<T>* next = eleminated->nextNode;
        this->firstNode = next;
        if(next!=NULL) next->prevNode = NULL;
    }else if(index==this->n-1){
        DoubleNode<T>* newLast = getNode(index-1);
        eleminated = newLast->nextNode;
        newLast->nextNode = NULL;
    }else{
        DoubleNode<T>* prev = getNode(index-1);
        eleminated = prev->nextNode;
        DoubleNode<T>* next = eleminated->nextNode;
        prev->nextNode = next;
    }
    free(eleminated);
    this->n--;
}

template<typename T> void DoubleLinkedList<T>::removeLast(){
    removeAtIndex(this->n-1);
}

template<typename T> const bool DoubleLinkedList<T>::isEmpty(){
    return this->n==0;
}

template<typename T> const string DoubleLinkedList<T>::toString(){
    ostringstream oss;
    oss << "DoubleLinkedList::(";
    for(int i=0;i<this->n;i++)
        oss << this->array[i].toString() << (i==this->n-1)?")":",";
    return oss.str();
}

template<typename T> DoubleLinkedList<T>::~DoubleLinkedList(){
    while(this->n>0) removeAtIndex(0);
}
