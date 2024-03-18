#ifndef __DOUBLE_LINKED_LIST
#define __DOUBLE_LINKED_LIST
#include "../../DataTypes/DoubleNode/DoubleNode.h"

template <typename T>
class DoubleLinkedList:AList{
    
    DoubleNode<T>* first;
    int n;
    
    const DoubleNode<T>* getNode(const int index);

public:

    DoubleLinkedList();

    const int getN();

    void setValue(const int index,const T value);
    const T getValue(const int index);

    void insert(const int index,const T value);
    void insertLast(const T value);
    void removeAtIndex(const int index);
    void removeLast();

    const bool isEmpty() override;
    const string toString() override;

    ~DoubleLinkedList();
};

#endif