#include "./ArrayList/arrayList.h"
#include <stdio.h>

int main() 
{

	ArrayList list = ArrayList();

	printf("New array list created:\n");
	list.print();

	printf("Charging list:\n");
	for (int i=0;i<=11;i++)
    {
		list.insertLast(i);
        list.print();
	}

    printf("Insert at first number from 100 to 104: \n");
	for (int i=100;i<=104;i++) 
    {
		list.insert(0,i);
		list.print();
	}

    printf("Insert 200 at third: \n");
    list.insert(3,200);

    printf("Removes 5 lasts: \n");
    for(int i=0;i<=5;i++)
    {
        list.removeLast();
        list.print();
    }

    printf("Removes 5 firsts: \n");
    for(int i=0;i<=5;i++)
    {
        list.remove(0);
        list.print();
    }

	return 0;
}


