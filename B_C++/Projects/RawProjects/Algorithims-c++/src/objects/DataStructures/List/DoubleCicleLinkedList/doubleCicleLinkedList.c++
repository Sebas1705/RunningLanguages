#include "doubleCicleLinkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

template <typename T> DoubleNode<T>* DoubleCircleLinkedList<T>::getNode(const int index){
    assert(index<this->n&&index>=0);
    DoubleNode* node = NULL;
    if (index<=this->n/2){
        n = this->firstNode;
        for(int i=0;i<index;i++)
            n = n->nextNode;
    }else{
        n = this->firstNode->prev;
        for (int i=this->n-1;i>index;i--) 
            n = n->prevNode;
    }
    return n;
}

template <typename T> DoubleCircleLinkedList<T>::DoubleCicleLinkedList(){
    DoubleCicleLinkedList* list =(DoubleCicleLinkedList*)malloc(sizeof(DoubleCicleLinkedList));
    list->firstNode = NULL;
    list->n = 0;
    return list;
}

void setValue(DoubleCicleLinkedList* list,int index,int value)
{
    getNode(list,index)->value = value;
}

int getValue(DoubleCicleLinkedList* list,int index)
{
    return getNode(list,index)->value;
}

void insert(DoubleCicleLinkedList* list,int index,int value)
{
    assert(index<=list->n&&index>=0);
    struct Node* n = (struct Node*)malloc(sizeof(struct Node));
    n->value = value;
    n->nextNode = NULL;
    n->prevNode = NULL;
    if(list->n==0)
    {
        list->firstNode = n;
        n->nextNode = n;
        n->prevNode = n;
    }
    else
    {
        if(index==0)
        {
            n->nextNode = list->firstNode;
            n->prevNode = list->firstNode->prevNode;
            list->firstNode->prevNode = n;
            list->firstNode = n;
        }
        else if(index==list->n)
        {
            struct Node* last = getNode(list,index-1);
            last->nextNode = n;
            n->prevNode = last;
            n->nextNode = list->firstNode;
            list->firstNode->prevNode = n;
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

void insertLast(DoubleCicleLinkedList* list,int value)
{
    insert(list,list->n,value);
}

void removeAtIndex(DoubleCicleLinkedList* list,int index)
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
            next->prevNode = eleminated->prevNode;
        }
    }
    else if(index==list->n-1)
    {
        struct Node* newLast = getNode(list,index-1);
        eleminated = newLast->nextNode;
        newLast->nextNode = list->firstNode;
        list->firstNode->prevNode = newLast;
    }
    else
    {
        struct Node* prev = getNode(list,index-1);
        eleminated = prev->nextNode;
        struct Node* next = eleminated->nextNode;
        prev->nextNode = next;
        next->prevNode = prev;
    }
    free(eleminated);
    list->n--;
}

void removeLast(DoubleCicleLinkedList* list)
{
    removeAtIndex(list,list->n-1);
}

void destructor(DoubleCicleLinkedList* list)
{
    while(list->n>0) removeAtIndex(list,0);
}

void print(DoubleCicleLinkedList* list)
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