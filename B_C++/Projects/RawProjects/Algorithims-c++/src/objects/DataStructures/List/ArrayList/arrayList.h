#ifndef __ARRAY_LIST
#define __ARRAY_LIST
#include "../AList.h"
#include "../../../DataTypes/TElement/TElement.h"

template<typename T>
class ArrayList:AList{
    
    TElement<T>* array;
    int n;
    int capacity;

public:

    ArrayList();

    int getN();
    int getCapacity();

    void set(const int index,const T value);
    void amply(const int increment);
    T get(const int index);
    void insert(const int index,const T value);
    void insertLast(const T value);
    void removeInList(const int index);
    void removeLast();
    void concat(const ArrayList<T> *array);
    int search(const T value);

    bool isFull() override;
    bool isEmpty() override;
    string toString() override;

    ~ArrayList();
};
#endif