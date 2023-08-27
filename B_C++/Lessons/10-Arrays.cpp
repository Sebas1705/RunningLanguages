#include <stdio.h>
#include <stdlib.h>

#define TAM_ARR 10

int main(){

    int array[] = {0,10,20,302,201,0};//Array declarator and initialize
    int array2[10];//Array declarator

    array[1]=1;//Access to element i from array

    //Look into an array:
    for(int i=0;i<(sizeof(array)/sizeof(int));i++)
        printf("array[i]=%d\n",array[i]);

    
    int array2D[][4]={//you have to put a max size of 2D
        {102,21,22,32},
        {1203929,29292,1929,1020}
    };

    printf("array2D[0][1]=%d\n",array2D[0][1]);

    //Reserve memory in compilation time:
    int* array_reserve=(int*)malloc(TAM_ARR*sizeof(int));

    return 0;
}