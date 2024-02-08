#include "./simpleLinkedList.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

Node* getNode(SimpleLinkedList* list,int index)
{
    assert(index<list->n&&index>=0);
    Node* n = list->firstNode;
    for(int i=0;i<index;i++)
    {
        n = n->nextNode;
    }
    return n;
}

SimpleLinkedList constructor()
{
    SimpleLinkedList list;
    list.firstNode = NULL;
    list.n = 0;
    return list;
}

void setValue(SimpleLinkedList* list,int index,int value)
{
    Node* n = getNode(list,index);
    n->value = value;
}

int getValue(SimpleLinkedList* list,int index)
{
    Node* n = getNode(list,index);
    return n->value;
}

void insert(SimpleLinkedList* list,int index,int value)
{
    assert(index<=list->n&&index>=0);
    Node n;
    n.value = value;
    n.nextNode = NULL;
    if(list->n==0)
    {
        list->firstNode=&n;
    }
    else
    {
        if(index==0)
        {
            n.nextNode = list->firstNode;
            list->firstNode = &n;
        }
        else if(index==list->n)
        {
            n.nextNode = NULL;
            Node* last = getNode(list,list->n-1);
            last->nextNode = &n;
        }
        else
        {
            Node* prev = getNode(list,index-1);
            n.nextNode = prev->nextNode;
            prev->nextNode = &n;
        }
    }  
    list->n++;
}

void insertLast(SimpleLinkedList* list,int value)
{
    insert(list,list->n,value);
}

void removeAtIndex(SimpleLinkedList* list,int index)
{
    assert(index<list->n&&index>=0);
    Node* eleminated;
    if(index==list->n-1)
    {
        Node* eleminatedPrev = getNode(list,index-1);
        eleminated = eleminatedPrev->nextNode;
        eleminatedPrev->nextNode = NULL;
    }
    else if(index==0)
    {
        Node* newFirst = getNode(list,1);
        eleminated = list->firstNode;
        list->firstNode = newFirst;
    }
    else
    {
        Node* prev = getNode(list,index-1);
        eleminated = prev->nextNode;
        Node* next = eleminated->nextNode;
        prev->nextNode = next;
    }
    free(eleminated);
    list->n--;
}

void removeLast(SimpleLinkedList* list)
{
    removeAtIndex(list,list->n-1);
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
        Node* n = list->firstNode;
        for(int i=0;i<list->n-1;i++)
        {
            printf("%d,",n->value);
            n = n->nextNode;
        }
        printf("%d\n",n->value);
    }
}