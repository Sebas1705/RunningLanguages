#include "./stackList.h"
#include <stdlib.h>

StackList* constructorStack()
{
    StackList* stackList = (StackList*)malloc(sizeof(StackList));
    stackList->list = constructor();
    return stackList;
}

void push(StackList* list,int value)
{
    insert(list->list,0,value);
}

int pop(StackList* list)
{
    return removeAtIndex(list->list,0);
}

int seeTop(StackList* list)
{
    return getValue(list->list,0);
}

int isEmpty(StackList* list)
{
    return list->list->n==0;
}

void destructorStack(StackList* list)
{
    destructor(list->list);
    free(list);
}