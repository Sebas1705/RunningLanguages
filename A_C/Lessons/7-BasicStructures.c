#include <stdio.h>

int main(){

    //if:
    printf("---------If-----------\n");
    int a=3;
    if(a==2){
        printf("Twice\n");
    }else if(a==1){
        printf("Once\n");
        goto switch_t; //Go to the next switch_t
    }else{
        printf("a is %d\n",a);
    }

    switch_t:
    //Switch:
    printf("-------SWITCH--------\n");
    switch(a){
        case 1:
            printf("a is 1\n");
            break;//Break out actual struct.
        case 2:
            printf("a is 2\n");
        default:
            printf("a is %d\n",a);
    }

    //While:
    printf("--------WHILE---------\n");
    while(a<6){
        a++;
        if(a==5)continue; //Jump to next repetition of loop
        printf("%d\n",a);
    }

    //Do_While:
    printf("-------DO_WHILE--------\n");
    do{
        a++;
        if(a==9)continue;
        if(a==13)break;
        printf("%d\n",a);
    }while(a<=14);

    //For:
    printf("---------FOR----------\n");
    for(int i=0;i<3;i++){
        printf("%d\n",a);
    }

    return 0;
}