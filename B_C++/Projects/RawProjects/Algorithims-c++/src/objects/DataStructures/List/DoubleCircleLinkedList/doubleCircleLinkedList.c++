#include "doubleCircleLinkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

template <typename T> const DoubleNode<T>* DoubleCircleLinkedList<T>::getNode(const int index){
    assert(index<this->n&&index>=0);
    DoubleNode* node = NULL;
    if (index<=this->n/2){
        n = this->firstNode;
        for(int i=0;i<index;i++)
            n = n->nextNode;
    }else{
        n = this->firstNode->prev;
        for (int i=this->n-1;i>index;i--) 
            n = n->prevNode;
    }
    return n;
}

template <typename T> DoubleCircleLinkedList<T>::DoubleCircleLinkedList(){
    this->first = NULL;
    this->n = 0;
}

template <typename T> void DoubleCircleLinkedList<T>::setValue(const int index,const T value){
    getNode(list,index)->value = DoubleNode<T>(value);
}

template<typename T> const T DoubleCircleLinkedList<T>::getValue(const int index){
    return getNode(index)->value;
}

template<typename T> void DoubleCircleLinkedList<T>::insert(const int index,const T value){
    assert(index<=this->n&&index>=0);
    DoubleNode<T>* n = &DoubleNode<T>(value);
    if(this->n==0){
        this->firstNode = n;
        n->nextNode = n;
        n->prevNode = n;
    }else{
        if(index==0){
            n->nextNode = this->firstNode;
            n->prevNode = this->firstNode->prevNode;
            this->firstNode->prevNode = n;
            this->firstNode = n;
        }else if(index==list->n){
            DoubleNode<T>* last = getNode(index-1);
            last->nextNode = n;
            n->prevNode = last;
            n->nextNode = this->firstNode;
            this->firstNode->prevNode = n;
        }else{
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

template<typename T> void DoubleCircleLinkedList<T>::insertLast(const T value){
    insert(this->n,value);
}

template<typename T> void DoubleCircleLinkedList<T>::removeAtIndex(const int index){
    assert(index<this->n&&index>=0);
    DoubleNode<T>* eleminated;
    if(index==0){
        eleminated = this->firstNode;
        DoubleNode<T>* next = eleminated->nextNode;
        this->firstNode = next;
        if(next!=NULL) next->prevNode = eleminated->prevNode;
    }else if(index==this->n-1){
        DoubleNode<T>* newLast = getNode(index-1);
        eleminated = newLast->nextNode;
        newLast->nextNode = this->firstNode;
        this->firstNode->prevNode = newLast;
    }else{
        DoubleNode<T>* prev = getNode(index-1);
        eleminated = prev->nextNode;
        DoubleNode<T>* next = eleminated->nextNode;
        prev->nextNode = next;
        next->prevNode = prev;
    }
    free(eleminated);
    this->n--;
}

template<typename T> void DoubleCircleLinkedList<T>::removeLast(){
    removeAtIndex(this->n-1);
}

template<typename T> const bool DoubleCircleLinkedList<T>::isEmpty(){
    return this->n==0;
}

template<typename T> const string DoubleCircleLinkedList<T>::toString(){
    ostringstream oss;
    oss << "DoubleCircleLinkedList::(";
    for(int i=0;i<this->n;i++)
        oss << this->array[i].toString() << (i==this->n-1)?")":",";
    return oss.str();
}

template<typename T> DoubleCircleLinkedList<T>::~DoubleCircleLinkedList(){
    while(this->n>0) removeAtIndex(0);
}