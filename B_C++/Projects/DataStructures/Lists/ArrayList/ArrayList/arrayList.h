#ifndef __ARRAY_LIST
#define __ARRAY_LIST

class ArrayList
{
    
    int* array;
    int n;
    int capacity;

public:

    ArrayList();

    int isFull();

    void set(int index, int value);

    void amply(int addCapacity);

    int get(int index);

    void insert(int index,int value);

    void insertLast(int value);

    void remove(int index);

    void removeLast();

    void concat(ArrayList* other);

    int search(int value);

    void print();

    ~ArrayList();

};

#endif