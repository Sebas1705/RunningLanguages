#include <stdio.h>

int main(){
    //Scanf:
    // int num;
    // char buffer[1024];
    // printf("Teclea sin espacios");
    // scanf("%s", buffer);//to space
    // printf("%s:\t", buffer);
    // scanf("%d", &num);
    // printf("%d\n", num);


    //fgets:
    char buffer[1024];
    fgets(buffer, 1024, stdin);//Wait 1024 chars or line jump
    printf("%s\n", buffer);
    return 0;
}