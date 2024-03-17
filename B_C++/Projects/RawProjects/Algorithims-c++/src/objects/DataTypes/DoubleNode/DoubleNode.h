#ifndef __DOUBLE_NODE_H
#define __DOUBLE_NODE_H
#include <iostream>
#include "../AType.h"
using namespace std;

template<typename T>
class DoubleNode:AType{

    T e;
    DoubleNode<T> *next, *prev; 

public:

    DoubleNode(const T value);

    T getElement();
    DoubleNode<T>* getNext();
    DoubleNode<T>* getPrev();

    void setElement(const T value);
    void setNext(const DoubleNode<T>* next);
    void setNext(const DoubleNode<T>* prev);

    string toString() override;
    bool equalsTo(const void* other) override;
};

#endif