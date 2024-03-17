#include "./linkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

template <typename T> const Node<T>* LinkedList<T>::getNode(const int index){
    assert(index<this->n&&index>=0);
    Node<T>* n = this->firstNode;
    for(int i=0;i<index;i++)
        n = n->nextNode;
    return n;
}

template <typename T> LinkedList<T>::LinkedList(){
    this->first = NULL;
    this->n = 0;
}

template <typename T> void LinkedList<T>::setValue(const int index,const T value){
    getNode(index)->value = Node<T>(value);
}

template<typename T> const T LinkedList<T>::getValue(const int index){
    return getNode(index)->value;
}

template<typename T> void LinkedList<T>::insert(const int index,const T value){
    assert(index<=this->n&&index>=0);
    Node<T>* n = &Node<T>(value);
    if(this->n==0) this->firstNode = n;
    else{
        if(index==0){
            n->nextNode = this->firstNode;
            this->firstNode = n;
        }else if(index==this->n){
            Node<T>* last = getNode(index-1);
            last->nextNode = n;
        }else{
            Node<T>* prev = getNode(index-1);
            n->nextNode = prev->nextNode;
            prev->nextNode = n;
        }
    }  
    this->n++;
}

template<typename T> void LinkedList<T>::insertLast(const T value){
    insert(this->n,value);
}

template<typename T> void LinkedList<T>::removeAtIndex(const int index){
    assert(index<this->n&&index>=0);
    Node<T>* eleminated;
    if(index==0){
        eleminated = this->firstNode;
        Node<T>* first = eleminated->nextNode;
        this->firstNode = first;
    }else if(index==this->n-1){
        Node<T>* eleminatedPrev = getNode(index-1);
        eleminated = eleminatedPrev->nextNode;
        eleminatedPrev->nextNode = NULL;
    }else{
        Node<T>* prev = getNode(index-1);
        eleminated = prev->nextNode;
        Node<T>* next = eleminated->nextNode;
        prev->nextNode = next;
    }
    free(eleminated);
    this->n--;
}

template<typename T> void LinkedList<T>::removeLast(){
    removeAtIndex(this->n-1);
}

template<typename T> const bool LinkedList<T>::isEmpty(){
    return this->n==0;
}

template<typename T> const string LinkedList<T>::toString(){
    ostringstream oss;
    oss << "LinkedList::(";
    for(int i=0;i<this->n;i++)
        oss << this->array[i].toString() << (i==this->n-1)?")":",";
    return oss.str();
}

template<typename T> LinkedList<T>::~LinkedList(){
    while(this->n>0) removeAtIndex(0);
}
