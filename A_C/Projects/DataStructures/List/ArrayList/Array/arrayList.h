#ifndef __ARRAY_LIST
#define __ARRAY_LIST

typedef struct
{
    int* array;
    int n;
    int capacity;
}
ArrayList;

ArrayList constructor();

void destructor(ArrayList *array);

int isFull(ArrayList *array);

void set(ArrayList *array,int index, int value);

void amply(ArrayList *array,int addCapacity);

int get(ArrayList *array,int index);

void insert(ArrayList *array,int index,int value);

void insertLast(ArrayList *array,int value);

void removeInList(ArrayList *array,int index);

void removeLast(ArrayList *array);

void concat(ArrayList *array1,ArrayList *array2);

int search(ArrayList *array,int value);

void print(ArrayList *array);

#endif