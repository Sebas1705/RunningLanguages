#include "./arrayList.h"
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include <stdio.h>

#define INCREMENT 2

ArrayList constructor()
{
    ArrayList list;
    list.array = NULL;
    list.capacity = 0;
    list.n = 0;
    return list;
}

void destructor(ArrayList *array)
{
    free(array->array);
    free(array);
}

int isFull(ArrayList *array)
{
    return array->n==array->capacity;
}

void set(ArrayList *array,int index, int value)
{
    assert(index<array->n&&index>=0);
    array->array[index] = value;
}

void amply(ArrayList *array,int increment)
{
    array->array = (int*)realloc(array->array,(array->capacity+increment)*sizeof(int));
    array->capacity += increment;
}

int get(ArrayList *array,int index)
{
    assert(index<array->n&&index>=0);
    return array->array[index];
}

void insert(ArrayList *array,int index,int value)
{
    assert(index<=array->n&&index>=0);
    if(isFull(array))
    {
        amply(array,INCREMENT);
    }
    memmove(&array->array[index+1],&array->array[index],sizeof(int)*(array->n-index));
    array->n++;
    set(array,index,value);
}

void insertLast(ArrayList *array,int value)
{
    insert(array,array->n,value);
}

void removeInList(ArrayList *array,int index)
{
    assert(index<array->n&&index>=0);
    memmove(&array->array[index],&array->array[index+1],sizeof(int)*(array->n-index-1));
    array->n--;
    if(array->capacity-array->n>=INCREMENT*2)
    {
        amply(array,-INCREMENT);
    }
}

void removeLast(ArrayList *array)
{
    removeInList(array,array->n-1);
}

void concat(ArrayList *array1,ArrayList *array2)
{
    array1->array=(int*)realloc(array1->array,sizeof(int)*(array1->capacity+array2->n));
    array1->capacity+=array2->n;
    for(int i=0;i<array2->n;i++)
    {
        insertLast(array1,array2->array[i]);
    }
}

int search(ArrayList *array,int value)
{
    for(int i=0;i<array->n;i++)
    {
        if(array->array[i]==value)
        {
            return i;
        }
    }
    return -1;
}

void print(ArrayList *array)
{
    printf("->List (n=%d)(capacity=%d): ",array->n,array->capacity);
    if(array->n==0)
    {
        printf("Empty\n");
    }
    else
    {
        for(int i=0;i<array->n-1;i++)
        {
            printf("%d,",array->array[i]);
        }
        printf("%d\n",array->array[array->n-1]);
    }
}