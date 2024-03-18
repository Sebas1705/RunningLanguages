#ifndef __STACK_LIST
#define __STACK_LIST

#include "../SimpleLinked/simpleLinkedList.h"

typedef struct
{
    SimpleLinkedList* list;
}
QueueList;

QueueList* constructorQueue();

void inqueue(QueueList* list,int value);

int unqueue(QueueList* list);

int seeFirst(QueueList* list);

int isEmpty(QueueList* list);

void destructorQueue(QueueList* list);

#endif