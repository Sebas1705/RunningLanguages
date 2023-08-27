#include <stdio.h>

int main(){

    int a = 4;//Normal variable
    printf("Address a:%p\n",&a);//Address access
    
    int *b=&a;//Pointer to a address 
    printf("Value in memory: %d\n",*b);//Memory access 

    *b=10000;//Memory change
    printf("A: %d\n",a);
    return 0;
}