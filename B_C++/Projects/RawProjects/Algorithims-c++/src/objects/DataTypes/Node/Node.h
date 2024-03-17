#ifndef __DOUBLE_NODE_H
#define __DOUBLE_NODE_H
#include <iostream>
#include "../AType.h"
using namespace std;

template<typename T>
class Node:AType{

    T e;
    Node<T> *next; 

public:

    Node(const T value);

    T getElement();
    Node<T>* getNext();
    Node<T>* getPrev();

    void setElement(const T value);
    void setNext(const Node<T>* next);
    void setNext(const Node<T>* prev);

    string toString() override;
    bool equalsTo(const void* other) override;
};

#endif