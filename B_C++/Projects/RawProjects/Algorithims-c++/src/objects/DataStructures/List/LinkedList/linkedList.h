#ifndef __LINKED_LIST
#define __LINKED_LIST
#include "../../DataTypes/Node/Node.h"

template <typename T>
class LinkedList:AList{
    
    Node<T>* first;
    int n;
    
    const Node<T>* getNode(const int index);

public:

    LinkedList();

    const int getN();

    void setValue(const int index,const T value);
    const T getValue(const int index);

    void insert(const int index,const T value);
    void insertLast(const T value);
    void removeAtIndex(const int index);
    void removeLast();

    const bool isEmpty() override;
    const string toString() override;

    ~LinkedList();
};


#endif