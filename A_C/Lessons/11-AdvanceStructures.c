#include <stdio.h>
#include <string.h>

//typedef:
typedef long long int size8_t; //Alias for variables types
typedef int (*Operation)(int,int);//Alias for functions
int sum(int a,int b){return a+b;}


//enums:
typedef enum {
    MONDAY=28,TUESDAY,WEDNESDAY,THURSDAY=1,FRIDAY,SATURDAY,SUNDAY
} weekend;

//structs (different memory spaces and more variables):
typedef struct{
    char name[20];
    int age;
}Character;

//unions (same memory space and only one value per time):
typedef union{
    int integer;
    char character;
    double doubles;
} Value;

int main(int argc, char const *argv[])
{
    size8_t number=19191911919191919;
    printf("size8_t: %llu\n",number);   
    
    Operation operation=sum;
    printf("Operation(4,5): %d\n",operation(4,5)); 
    
    weekend day = MONDAY;
    printf("Weekend day: %d\n",day);
    
    Character p;
    p.age=19;
    strcpy(p.name,"Pepe");
    
    Character *pointer=&p;
    printf("Name: %s\n",pointer->name);//To access a component with a pointer do ->
    printf("Age: %d\n",pointer->age);

    Value v;
    v.integer=8;
    v.character='c';
    printf("%d\n",v.integer);
}
