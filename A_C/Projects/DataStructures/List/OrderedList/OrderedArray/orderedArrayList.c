#include "./orderedArrayList.h"
#include <assert.h>
#include <stdlib.h>
#include <stdio.h>

OrderedArrayList* constructorOrder()
{
    OrderedArrayList *list = (OrderedArrayList*)malloc(sizeof(OrderedArrayList));
    list->list = constructor();
    return list;
}

int isOrdered(OrderedArrayList *list)
{
    for (int i=1;i<list->list->n;i++)
    {
        if(get(list->list,i)<get(list->list,i-1))
        {
            return 0;
        }
    }
    return 1;
}

int searchPosition(OrderedArrayList *list,int value,int first,int nList)
{
    assert(nList >= 1);
	int n=list->list->n;
	int nListPos=first+(nList-1); // Posici�n de fin de la sublista
	assert(first>=0&&first<n);
	assert(nListPos>=0&&nListPos<n);
	assert(first<=nListPos);
    int mid = (first+nListPos)/2;
    int valueMid = get(list->list,mid);
    if(valueMid==value)
    {
        return mid;
    }
    else if(value > valueMid)
    {
        int nSubList = nListPos-(mid+1)+1;
        if(nSubList==0)
        {
            return nListPos+1;
        }
        else
        {
            return searchPosition(list,value,mid+1,nSubList);
        }
    }
    else
    {
        int nSubList = (mid-1)-first+1;
        if(nSubList==0)
        {
            return first;
        }
        else
        {
            return searchPosition(list,value,first,nSubList);
        }
    }
}

int searchInOrder(OrderedArrayList *list,int value)
{
    if(list->list->n==0)
    {
        return -1;
    } 
    else 
    {
        int pos = searchPosition(list,value,0,list->list->n);
        if(pos==list->list->n)
        {
            return -1;
        }
        else if(get(list->list,pos)==value)
        {
            return pos;
        }
        else
        {
            return -1;
        }
    }
    
}

void insertInOrder(OrderedArrayList *list,int value){
    if(list->list->n==0)
    {
        insert(list->list,0,value);
    }
    else
    {
        int pos = searchPosition(list,value,0,list->list->n);
        insert(list->list,pos,value);
    }
}

void removeInOrder(OrderedArrayList *list,int value){
    assert(searchInOrder(list,value)!=-1);
    int pos = searchPosition(list,value,0,list->list->n);
    removeInList(list->list,pos);
}

void destructorOrder(OrderedArrayList *list){
    destructor(list->list);
}