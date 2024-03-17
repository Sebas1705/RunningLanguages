#ifndef __ORDERED_ARRAY_LIST
#define __ORDERED_ARRAY_LIST

#include "../Array/arrayList.h"

typedef struct
{
    ArrayList *list;
}
OrderedArrayList;

int isOrdered(OrderedArrayList *list);

OrderedArrayList* constructorOrder();

int searchPosition(OrderedArrayList *list,int value,int first,int last);

int searchInOrder(OrderedArrayList *list,int value);

void insertInOrder(OrderedArrayList *list,int value);

void removeInOrder(OrderedArrayList *list,int value);

void destructorOrder(OrderedArrayList *list);

#endif