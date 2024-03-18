#include "./queueList.h"
#include <stdlib.h>

QueueList* constructorQueue()
{
    QueueList* stackList = (QueueList*)malloc(sizeof(QueueList));
    stackList->list = constructor();
    return stackList;
}

void inqueue(QueueList* list,int value)
{
    insert(list->list,list->list->n-1,value);
}

int unqueue(QueueList* list)
{
    return removeAtIndex(list->list,list->list->n-1);
}

int seeFirst(QueueList* list)
{
    return getValue(list->list,0);
}

int isEmpty(QueueList* list)
{
    return list->list->n==0;
}

void destructorQueue(QueueList* list)
{
    destructor(list->list);
    free(list);
}