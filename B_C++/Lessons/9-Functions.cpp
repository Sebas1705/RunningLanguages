#include <stdio.h>
#include <stdarg.h>
#include "9-Functions.h"

int error=0;//bool to false

int main()
{
    hola();
    printSum(10,9);
    printf("AnyError: %c\n",anyError());
    save5(&error);
    printf("error: %d\n",error);
    executer(hola);
    printf("%d\n",sum(2,20,20));
    return 0;
}

void hola(){ //function initialize
    printf("Hola\n");
}

char anyError(){
    return (error)?'T':'F'; //Trinary Operator.
}

void printSum(int a, int b=0){ //function with parameters and b is optional
    printf("Sum: %d\n",a+b);
}

void save5(int* a){
    *a=5;
}

void executer(void (*function)()){
    function();
}

int sum(int count,...){
    int total=0;
    va_list args;
    va_start(args,&count);
    for(int i=0;i<count;i++){
        int temp=va_arg(args,int);
        total+=temp;
    }
    va_end(args);
    return total;
}