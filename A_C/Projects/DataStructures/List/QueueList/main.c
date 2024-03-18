#include "./Queue/queueList.h"
#include "./SimpleLinked/simpleLinkedList.h"
#include <stdio.h>

int main() 
{

	QueueList *queueList = constructorQueue();

	inqueue(queueList,1);
	inqueue(queueList,5);
	inqueue(queueList,3);
	inqueue(queueList,2);
	print(queueList->list);

	printf("First: %d\n",seeFirst(queueList));
	printf("First: %d\n",seeFirst(queueList));

	printf("Unqueue: %d\n",unqueue(queueList));
	printf("Unqueue: %d\n",unqueue(queueList));
	print(queueList->list);

	printf("Unqueue: %d\n",unqueue(queueList));
	printf("Unqueue: %d\n",unqueue(queueList));
	print(queueList->list);

	printf("IsEmpty: %d\n",isEmpty(queueList));

	destructorQueue(queueList);

	return 0;
}