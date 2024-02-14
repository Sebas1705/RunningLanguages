#include "./OrderedArray/orderedArrayList.h"
#include "./Array/arrayList.h"
#include <stdio.h>
#include <time.h>
#include <stdlib.h>



int main() 
{

	OrderedArrayList* list = constructorOrder();

    srand(time(NULL));
    for(int i=0;i<30;i++) insertInOrder(list,(int)rand()%101);
    print(list->list);
    printf("Ordered: %d\n",isOrdered(list));
    for(int i=0;i<5;i++){
        int toSearch = (int)rand()%101;
        printf("Pos (%d): %d\n",toSearch,searchInOrder(list,toSearch));
    }
    
    destructorOrder(list);

	return 0;
}


