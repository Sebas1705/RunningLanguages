#ifndef __LINKED_LIST
#define __LINKED_LIST
#include "../../DataTypes/Node/Node.h"
#include "../LinkedList/linkedList.h"

template <typename T>
class OrderedList:AList{
    
    const ArrayList<T>* list;
    
    const Node<T>* getNode(const int index);

public:

    OrderedList();

    const int getN();

    const bool isOrdered();
    const T getValue(const int index);

    const int searchPosition(const T value,const int first,const int nList)
    const int searchInOrder(const T value)
    void insertInOrder(const T value)
    void removeInOrder(const T value)

    const bool isEmpty() override;
    const string toString() override;

    ~OrderedList();
};


#endif