#ifndef __CIRCLE_LINKED_LIST
#define __CIRCLE_LINKED_LIST
#include "../AList.h"
#include "../../DataTypes/DoubleNode/DoubleNode.h"

template <typename T>
class DoubleCircleLinkedList:AList{
    
    DoubleNode<T>* first;
    int n;
    
    const DoubleNode<T>* getNode(const int index);

public:

    DoubleCircleLinkedList();

    const int getN();

    void setValue(const int index,const T value);
    const T getValue(const int index);

    void insert(const int index,const T value);
    void insertLast(const T value);
    void removeAtIndex(const int index);
    void removeLast();
    
    const bool isEmpty() override;
    const string toString() override;

    ~DoubleCircleLinkedList();
};

#endif