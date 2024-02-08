#include "./SimpleLinked/simpleLinkedList.h"
#include <stdio.h>

int main() 
{

	SimpleLinkedList list = constructor();
	printf("New Linked list:\n");
	print(&list);

	printf("Insert 10: \n");
	insert(&list,0,10);
	print(&list);

	printf("Insert 20 and 21 at last:\n");
	insertLast(&list,20);
    print(&list);
	insertLast(&list,21);
	print(&list);

	printf("Insert 30 at first:\n");
	insert(&list,0,30);
	print(&list);

	printf("Insert 40 at 2 position:\n");
	insert(&list,2,40);
	print(&list);

	printf("Remove first:\n");
	removeAtIndex(&list,0);
	print(&list);

	printf("Remove last:\n");
	removeLast(&list);
	print(&list);

	printf("Remove middle:\n");
	removeAtIndex(&list,1);
	print(&list);

	printf("Remove 20 and 10 for empty list:\n");
	removeLast(&list); print(&list);
	removeLast(&list); print(&list);

	printf("Repeat firsts insertions:\n");

	printf("Insert 10: \n");
	insert(&list,0,10);
	print(&list);

	printf("Insert 20 and 21 at last:\n");
	insertLast(&list,20);
    print(&list);
	insertLast(&list,21);
	print(&list);

	printf("Insert 30 at first:\n");
	insert(&list,0,30);
	print(&list);

	printf("Insert 40 at 2 position:\n");
	insert(&list,2,40);
	print(&list);

	printf("Insert 50 and 60 at lasts:\n");
	insertLast(&list,50);
    insertLast(&list,60);
	print(&list);

	printf("Value 0 is: %d\n",getValue(&list,0));
	printf("Value 4 is: %d\n",getValue(&list,4));
	printf("Value 2 is: %d\n",getValue(&list,2));
	printf("Value 6 is: %d\n",getValue(&list,6));

	printf("Change values 0, 4, 2 y 6 by theirs inverses:\n");
	setValue(&list,0,-30);
	setValue(&list,4,-21);
	setValue(&list,2,-40);
	setValue(&list,6,-60);
	print(&list);

	destructor(&list);

	return 0;
}