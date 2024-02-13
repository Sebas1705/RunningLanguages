#ifndef __CICLE_LINKED_LIST
#define __CICLE_LINKED_LIST

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
DoubleCicleLinkedList;

struct Node* getNode(DoubleCicleLinkedList* list,int index);

DoubleCicleLinkedList* constructor();

void setValue(DoubleCicleLinkedList* list,int index,int value);

int getValue(DoubleCicleLinkedList* list,int index);

void insert(DoubleCicleLinkedList* list,int index,int value);

void insertLast(DoubleCicleLinkedList* list,int value);

void removeAtIndex(DoubleCicleLinkedList* list,int index);

void removeLast(DoubleCicleLinkedList* list);

void destructor(DoubleCicleLinkedList* list);

void print(DoubleCicleLinkedList* list);

#endif