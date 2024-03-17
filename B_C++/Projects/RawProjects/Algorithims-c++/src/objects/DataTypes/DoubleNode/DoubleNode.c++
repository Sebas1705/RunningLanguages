#include "DoubleNode.h"

template<typename T> DoubleNode<T>::DoubleNode(const T value){
    this->e = value;
    this->next = NULL;
    this->prev = NULL;
}

template<typename T> const T DoubleNode<T>::getElement(){return this->e;}
template<typename T> const DoubleNode<T>* DoubleNode<T>::getNext(){return this->next;}
template<typename T> const DoubleNode<T>* DoubleNode<T>::getPrev(){return this->prev;}

template<typename T> void DoubleNode<T>::setElement(const T value){this->element = value;}
template<typename T> void DoubleNode<T>::setNext(const DoubleNode<T>* next){this->next = next;}
template<typename T> void DoubleNode<T>::setNext(const DoubleNode<T>* prev){this->prev = prev;}

template<typename T> const string DoubleNode<T>::toString(){
    ostringstream oss;
    oss << "{<-" << this->prev <<"-["<< &this->element << "|" << this->element << "]-" << this->next << "->}";
    return oss.str();
}

template<typename T> const bool DoubleNode<T>::equalsTo(const void* other){
    DoubleNode<T>* t = (DoubleNode<T>*)other;
    return this->e==t->e&&this->next==t->next&&this->prev==t->prev;
}