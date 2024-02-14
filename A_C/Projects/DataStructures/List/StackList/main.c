#include "./Stack/stackList.h"
#include "./SimpleLinked/simpleLinkedList.h"
#include <stdio.h>

int main() 
{

	StackList *stackList = constructorStack();

	push(stackList,1);
	push(stackList,5);
	push(stackList,3);
	push(stackList,2);
	print(stackList->list);

	printf("Top: %d\n",seeTop(stackList));
	printf("Top: %d\n",seeTop(stackList));

	printf("Pop: %d\n",pop(stackList));
	printf("Pop: %d\n",pop(stackList));
	print(stackList->list);

	printf("Pop: %d\n",pop(stackList));
	printf("Pop: %d\n",pop(stackList));
	print(stackList->list);

	printf("IsEmpty: %d\n",isEmpty(stackList));

	destructorStack(stackList);

	return 0;
}