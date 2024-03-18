#ifndef __STACK_LIST
#define __STACK_LIST

#include "../SimpleLinked/simpleLinkedList.h"

typedef struct
{
    SimpleLinkedList* list;
}
StackList;

StackList* constructorStack();

void push(StackList* list,int value);

int pop(StackList* list);

int seeTop(StackList* list);

int isEmpty(StackList* list);

void destructorStack(StackList* list);

#endif