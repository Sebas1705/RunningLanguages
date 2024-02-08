#ifndef __SIMPLE_LINKED_LIST
#define __SIMPLE_LINKED_LIST

typedef struct Node
{
    int value;
    struct Node* nextNode;
}Node;

typedef struct
{
    Node* firstNode;
    int n;
}
SimpleLinkedList;

Node* getNode(SimpleLinkedList* list,int index);

SimpleLinkedList constructor();

void setValue(SimpleLinkedList* list,int index,int value);

int getValue(SimpleLinkedList* list,int index);

void insert(SimpleLinkedList* list,int index,int value);

void insertLast(SimpleLinkedList* list,int value);

void removeAtIndex(SimpleLinkedList* list,int index);

void removeLast(SimpleLinkedList* list);

void destructor(SimpleLinkedList* list);

void print(SimpleLinkedList* list);

#endif