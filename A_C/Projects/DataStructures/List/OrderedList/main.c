#include "./OrderedArray/orderedArrayList.h"
#include "./Array/arrayList.h"
#include <stdio.h>

int main() 
{

	OrderedArrayList* list = constructorOrder();

    for(int i=0;i<30;i++) insertLast(list->list,i);
    print(list->list);
    printf("Ordered: %d\n",isOrdered(list));
    printf("Pos (223): %d\n",searchInOrder(list,223));
    printf("___________\n");

    destructorOrder(list);

	return 0;
}


