#ifndef __DOUBLE_LINKED_LIST
#define __DOUBLE_LINKED_LIST

struct Node
{
    int value;
    struct Node* nextNode;
    struct Node* prevNode;
};

typedef struct
{
    struct Node* firstNode;
    int n;
}
DoubleLinkedList;

struct Node* getNode(DoubleLinkedList* list,int index);

DoubleLinkedList* constructor();

void setValue(DoubleLinkedList* list,int index,int value);

int getValue(DoubleLinkedList* list,int index);

void insert(DoubleLinkedList* list,int index,int value);

void insertLast(DoubleLinkedList* list,int value);

void removeAtIndex(DoubleLinkedList* list,int index);

void removeLast(DoubleLinkedList* list);

void destructor(DoubleLinkedList* list);

void print(DoubleLinkedList* list);

#endif