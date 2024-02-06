#include "./arrayList.h"
#include <stdlib.h>
#include <cassert>
#include <iostream>
using namespace std;

#define INCREMENT 2

ArrayList::ArrayList()
{
    this->array = NULL;
    this->capacity = 0;
    this->n = 0;
}

ArrayList::~ArrayList()
{
    free(this->array);
    this->array = NULL;
    this->capacity = 0;
    this->n = 0;
}

int ArrayList::isFull()
{
    return this->n==this->capacity;
}

void ArrayList::set(int index, int value)
{
    assert(index<this->n&&index>=0);
    this->array[index] = value;
}

void ArrayList::amply(int increment)
{
    this->array = (int*)realloc(this->array,(this->capacity+increment)*sizeof(int));
    this->capacity += increment;
}

int ArrayList::get(int index)
{
    assert(index<this->n&&index>=0);
    return this->array[index];
}

void ArrayList::insert(int index,int value)
{
    assert(index<=this->n&&index>=0);
    if(isFull())
    {
        amply(INCREMENT);
    }
    memmove(&this->array[index+1],&this->array[index],sizeof(int)*(this->n-index));
    this->n++;
    set(index,value);
}

void ArrayList::insertLast(int value)
{
    insert(this->n,value);
}

void ArrayList::remove(int index)
{
    assert(index<this->n&&index>=0);
    memmove(&this->array[index],&this->array[index+1],sizeof(int)*(n-index-1));
    this->n--;
    if(this->capacity-this->n>=INCREMENT*2)
    {
        amply(-INCREMENT);
    }
}

void ArrayList::removeLast()
{
    remove(this->n-1);
}

void ArrayList::concat(ArrayList* other)
{
    this->array=(int*)realloc(this->array,sizeof(int)*(this->capacity+other->n));
    this->capacity+=other->n;
    for(int i=0;i<other->n;i++)
    {
        insertLast(other->array[i]);
    }
}

int ArrayList::search(int value)
{
    for(int i=0;i<this->n;i++)
    {
        if(this->array[i]==value)
        {
            return i;
        }
    }
    return -1;
}

void ArrayList::print()
{
    printf("->List (n=%d)(capacity=%d): ",this->n,this->capacity);
    if(this->n==0)
    {
        printf("Empty\n");
    }
    else
    {
        for(int i=0;i<this->n-1;i++)
        {
            printf("%d,",this->array[i]);
        }
        printf("%d\n",this->array[this->n-1]);
    }
}