#include "./doubleLinkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

struct Node* getNode(DoubleLinkedList* list,int index)
{
    assert(index<list->n&&index>=0);
    struct Node* n = list->firstNode;
    for(int i=0;i<index;i++)
    {
        n = n->nextNode;
    }
    return n;
}

DoubleLinkedList* constructor()
{
    DoubleLinkedList* list =(DoubleLinkedList*)malloc(sizeof(DoubleLinkedList));
    list->firstNode = NULL;
    list->n = 0;
    return list;
}

void setValue(DoubleLinkedList* list,int index,int value)
{
    getNode(list,index)->value = value;
}

int getValue(DoubleLinkedList* list,int index)
{
    return getNode(list,index)->value;
}

void insert(DoubleLinkedList* list,int index,int value)
{
    assert(index<=list->n&&index>=0);
    struct Node* n = (struct Node*)malloc(sizeof(struct Node));
    n->value = value;
    n->nextNode = NULL;
    n->prevNode = NULL;
    if(list->n==0)
    {
        list->firstNode = n;
    }
    else
    {
        if(index==0)
        {
            n->nextNode = list->firstNode;
            list->firstNode = n;
        }
        else if(index==list->n)
        {
            struct Node* last = getNode(list,index-1);
            last->nextNode = n;
            n->prevNode = last;
        }
        else
        {
            struct Node* prev = getNode(list,index-1);
            struct Node* next = prev->nextNode;
            prev->nextNode = n;
            next->prevNode = n;
            n->nextNode = next;
            n->prevNode = prev;
        }
    }  
    list->n++;
}

void insertLast(DoubleLinkedList* list,int value)
{
    insert(list,list->n,value);
}

void removeAtIndex(DoubleLinkedList* list,int index)
{
    assert(index<list->n&&index>=0);
    struct Node* eleminated;
    if(index==0)
    {
        eleminated = list->firstNode;
        struct Node* next = eleminated->nextNode;
        list->firstNode = next;
        if(next!=NULL)
        {
            next->prevNode = NULL;
        }
    }
    else if(index==list->n-1)
    {
        struct Node* newLast = getNode(list,index-1);
        eleminated = newLast->nextNode;
        newLast->nextNode = NULL;
    }
    else
    {
        struct Node* prev = getNode(list,index-1);
        eleminated = prev->nextNode;
        struct Node* next = eleminated->nextNode;
        prev->nextNode = next;
    }
    free(eleminated);
    list->n--;
}

void removeLast(DoubleLinkedList* list)
{
    removeAtIndex(list,list->n-1);
}

void destructor(DoubleLinkedList* list)
{
    while(list->n>0) removeAtIndex(list,0);
}

void print(DoubleLinkedList* list)
{
    printf("->List (n=%d): ",list->n);
    if(list->n==0)
    {
        printf("Empty\n");
    }
    else
    {
        struct Node* n = list->firstNode;
        for(int i=0;i<list->n-1;i++)
        {
            printf("%d,",n->value);
            n = n->nextNode;
        }
        printf("%d\n",n->value);
    }
}