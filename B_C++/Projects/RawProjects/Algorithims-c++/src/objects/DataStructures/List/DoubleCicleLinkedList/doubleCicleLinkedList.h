#ifndef __CICLE_LINKED_LIST
#define __CICLE_LINKED_LIST
#include "../AList.h"
#include "../../DataTypes/DoubleNode/DoubleNode.h"

template <typename T>
class DoubleCircleLinkedList:AList{
    
    DoubleNode<T>* first;
    int n;
    
    DoubleNode<T>* getNode(const int index);

public:

    DoubleCircleLinkedList();

    int getN();

    void setValue(const int index,const T value);
    T getValue(const int index);

    void insert(const int index,const T value);
    void insertLast(const T value);
    void removeAtIndex(const int index);
    void removeLast();

    bool isFull() override;
    bool isEmpty() override;
    string toString() override;

    ~DoubleCicleLinkedList();
};

#endif