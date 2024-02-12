#include "./Array/arrayList.h"
#include <stdio.h>

int main() 
{

	ArrayList list = constructor();

	printf("New array list created:\n");
	print(&list);

	printf("Charging list:\n");
	for (int i=0;i<=11;i++)
    {
		insertLast(&list,i);
        print(&list);
	}

    printf("Insert at first number from 100 to 104: \n");
	for (int i=100;i<=104;i++) 
    {
		insert(&list,0,i);
		print(&list);
	}

    printf("Insert 200 at third: \n");
    insert(&list,3,200);

    printf("Removes 5 lasts: \n");
    for(int i=0;i<=5;i++)
    {
        removeLast(&list);
        print(&list);
    }

    printf("Removes 5 firsts: \n");
    for(int i=0;i<=5;i++)
    {
        removeInList(&list,0);
        print(&list);
    }

    destructor(&list);

	return 0;
}


