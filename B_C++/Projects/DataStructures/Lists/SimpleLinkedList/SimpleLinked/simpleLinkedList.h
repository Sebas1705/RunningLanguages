#ifndef __SIMPLE_LINKED_LIST
#define __SIMPLE_LINKED_LIST

typedef struct
{
    int value;
    Node* nextNode;
}
Node;

typedef struct
{
    Node* firstNode;
    int n;
}
SimpleLinkedList;

void getNode(int index);

void constructor();

void setValue(int index,int value);

int getValue(int index);

void insert(int index,int value);

void remove(int index);

void destructor();

void print();

#endif