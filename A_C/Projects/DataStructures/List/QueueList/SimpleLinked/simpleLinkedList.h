#ifndef __SIMPLE_LINKED_LIST
#define __SIMPLE_LINKED_LIST

struct Node
{
    int value;
    struct Node* nextNode;
};

typedef struct
{
    struct Node* firstNode;
    int n;
}
SimpleLinkedList;

struct Node* getNode(SimpleLinkedList* list,int index);

SimpleLinkedList* constructor();

void setValue(SimpleLinkedList* list,int index,int value);

int getValue(SimpleLinkedList* list,int index);

void insert(SimpleLinkedList* list,int index,int value);

void insertLast(SimpleLinkedList* list,int value);

int removeAtIndex(SimpleLinkedList* list,int index);

int removeLast(SimpleLinkedList* list);

void destructor(SimpleLinkedList* list);

void print(SimpleLinkedList* list);

#endif