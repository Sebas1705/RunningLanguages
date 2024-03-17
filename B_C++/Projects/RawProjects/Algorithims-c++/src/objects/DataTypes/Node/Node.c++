#include "Node.h"

template<typename T> Node<T>::Node(const T value){
    this->e = value;
    this->next = NULL;
}

template<typename T> T Node<T>::getElement(){return this->e;}
template<typename T> Node<T>* Node<T>::getNext(){return this->next;}

template<typename T> void Node<T>::setElement(const T value){this->element = value;}
template<typename T> void Node<T>::setNext(const Node<T>* next){this->next = next;}

template<typename T> string Node<T>::toString(){
    ostringstream oss;
    oss << "{["<< &this->element << "|" << this->element << "]-" << this->next << "->}";
    return oss.str();
}

template<typename T> bool Node<T>::equalsTo(const void* other){
    Node<T>* t = (Node<T>*)other;
    return this->e==t->e&&this->next==t->next;
}