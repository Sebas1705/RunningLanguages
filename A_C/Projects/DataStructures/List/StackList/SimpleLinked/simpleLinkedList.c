#include "./simpleLinkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

struct Node* getNode(SimpleLinkedList* list,int index)
{
    assert(index<list->n&&index>=0);
    struct Node* n = list->firstNode;
    for(int i=0;i<index;i++)
    {
        n = n->nextNode;
    }
    return n;
}

SimpleLinkedList* constructor()
{
    SimpleLinkedList* list =(SimpleLinkedList*)malloc(sizeof(SimpleLinkedList));
    list->firstNode = NULL;
    list->n = 0;
    return list;
}

void setValue(SimpleLinkedList* list,int index,int value)
{
    getNode(list,index)->value = value;
}

int getValue(SimpleLinkedList* list,int index)
{
    return getNode(list,index)->value;
}

void insert(SimpleLinkedList* list,int index,int value)
{
    assert(index<=list->n&&index>=0);
    struct Node* n = (struct Node*)malloc(sizeof(struct Node));
    n->value = value;
    n->nextNode = NULL;
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
        }
        else
        {
            struct Node* prev = getNode(list,index-1);
            n->nextNode = prev->nextNode;
            prev->nextNode = n;
        }
    }  
    list->n++;
}

void insertLast(SimpleLinkedList* list,int value)
{
    insert(list,list->n,value);
}

int removeAtIndex(SimpleLinkedList* list,int index)
{
    assert(index<list->n&&index>=0);
    struct Node* eleminated;
    if(index==0)
    {
        eleminated = list->firstNode;
        struct Node* first = eleminated->nextNode;
        list->firstNode = first;
    }
    else if(index==list->n-1)
    {
        struct Node* eleminatedPrev = getNode(list,index-1);
        eleminated = eleminatedPrev->nextNode;
        eleminatedPrev->nextNode = NULL;
    }
    else
    {
        struct Node* prev = getNode(list,index-1);
        eleminated = prev->nextNode;
        struct Node* next = eleminated->nextNode;
        prev->nextNode = next;
    }
    int value = eleminated->value;
    free(eleminated);
    list->n--;
    return value;
}

int removeLast(SimpleLinkedList* list)
{
    return removeAtIndex(list,list->n-1);
}

void destructor(SimpleLinkedList* list)
{
    while(list->n>0) removeAtIndex(list,0);
}

void print(SimpleLinkedList* list)
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