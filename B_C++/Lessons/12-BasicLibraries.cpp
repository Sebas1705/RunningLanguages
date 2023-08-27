#include <cstdio>
#include <cmath>
#include <cstring>
#include <ctime>
#include <cstdlib>
#include <ctype.h>

int main()
{

    //stdio.h:
    // printf("\n------------STDIO.H------------\n");
    // printf("Hola %d-%s-%c\n",1,"hola",'c');
    //int c; scanf("%d",&c); //Save an input to a variable
    //printf("%c\n",getchar()); //Scan a char
    //putchar('\n'); //Write a char
    //char line[100];fgets(line,sizeof(line),stdin);//gets a line in a buffer from a input
    //fputs(line,stdout);//puts a buffer into an output
    //sprintf(line,"Number: %d\n",5); //Format and save a string
    //int num1,num2;sscanf("50 20","%d %d",&num1,&num2);
    
    //Read an write files:
    FILE *f = fopen("file.txt","w"); //r -> read, w -> write, x -> execute
    if(f!=NULL){
        fprintf(f,"hello world");
        //fgets(NULL,100,f);
        fclose(f);
    }else printf("Don't know file\n");
    f=fopen("file.txt","r");
    if(f!=NULL){
        char line[100];
        while (fgets(line,sizeof(line),f) != NULL) printf("%s", line);
        fclose(f);
    }else printf("Don't know file\n");
    
    
    //math.h:
    printf("\n------------MATH.H------------\n");
    double a=189.22,b=12.23;
    printf("acos(a)=%lf\n",acos(a));
    printf("asin(a)=%lf\n",asin(a)); 
    printf("atan(a)=%lf\n",atan(a));
    printf("atan2(a,b)=%lf\n",atan2(a,b));
    printf("cos(a)=%lf\n",cos(a));
    printf("sin(a)=%lf\n",sin(a));
    printf("tan(a)=%lf\n",tan(a));
    printf("cosh(a)=%lf\n",cosh(a));
    printf("sinh(a)=%lf\n",sinh(a));
    printf("tanh(a)=%lf\n",tanh(a));
    printf("exp(a)=%lf\n",exp(a));
    printf("log(a)=%lf\n",log(a));
    printf("sqrt(a)=%lf\n",sqrt(a));
    printf("log10(a)=%lf\n",log10(a));
    printf("floor(a)=%lf\n",floor(a));
    printf("ceil(a)=%lf\n",ceil(a));
    printf("trunc(a)=%lf\n",trunc(a));
    
    //string.h:
    printf("\n------------STRING.H------------\n");
    char str[]="Hola";
    char str2[]="Byes";
    //if i<0 then str is less than str2, if i>0 then str2 is less than str, if 0 there are equal
    printf("memcmp(str,str2,4)=%d\n",memcmp(str,str2,4)); //Same as strcmp
    memcpy(str,str2,4);
    printf("memcpy(str,str2,4)=%s\n",str); //Same as strcpy
    memset(str,'c',2);
    printf("memset(str,'c',2)=%s\n",str);
    char *str3=strcat(str,str2);
    printf("strcat(str,str2)=%s\n",str3);
    str3=strncat(str,str2,2);
    printf("strncat(str,str2,2)=%s\n",str3);
    str3=strchr(str,'e');
    printf("strchr(str,'e')=%s\n",str3);
    printf("strlen(str)=%d\n",(int)strlen(str));
    strcpy(str,str2);
    printf("str after strcpy=%s\n",str);

    //time.h:
    printf("\n------------TIME.H------------\n");
    const struct tm newTime={
        10,//Seconds 0-59
        20,//Minutes 0-59
        23,//Hours 0-23
        17,//Month's day 1-31
        5,//month, range 0 to 11            
        2002,//The number of years since 1900   
        4,//day of the week, range 0 to 6    
        134,//day in the year, range 0 to 365  
        22//daylight saving time             
    };
    const time_t timer=1290202;
    const time_t timer2=1292921;
    printf("CLOCKS_PER_SEC=%ld\n",CLOCKS_PER_SEC);//This macro represents the number of processor clocks per second.
    printf("asctime(newTime)=%s",asctime(&newTime));//Returns a pointer to a string which represents the day and time of the structure timeptr.
    printf("clock()=%ld\n",clock());//Returns the processor clock time used since the beginning of an implementation defined era (normally the beginning of the program).
    printf("ctime(&timer)=%s",ctime(&timer));//Returns a string representing the localtime based on the argument timer.
    printf("difftime(timer,timer2)=%f\n",difftime(timer,timer2));

    //stdlib.h:
    printf("\n------------STDLIB.H------------\n");
    int* list=(int*)malloc(sizeof(int)*4); //Saved a personalized space of memory (bytes)
    list=(int*)realloc(list,sizeof(int)*8); //Changed a space of memory (pointer, bytes)
    list=(int*)calloc(8,sizeof(int)); //Same as malloc, but you pass nº blocks and tam of blocks (nº blocks, bytes per block)
    free(list); //free a space of memory (pointer)
    //abort(); //finish the program abruptly
    //exit(0); //finish the program with S.O. codes
    printf("%d\n",atoi("9")); //str -> int
    printf("%ld\n",atol("9222828228")); //str -> long
    //see more: atoll, atof, strtod, strtol, strtoll, strtoul, strtoull
    srand(time(NULL));//Initialized seed from random number generator
    int rand_number=rand();//Rand number from 0 to RAND_MAX
    printf("->%d (0-%d)\n",rand_number,RAND_MAX);
    system("ls"); //Do a system command, that share with console where is program running

    //ctype.h:
    printf("\n------------CTYPE.H------------\n");
    printf("%d\n",isalnum('%'));//if is a number or letter
    printf("%d\n",isalpha('a'));//if is a letter
    printf("%d\n",isdigit('9'));//if is a number
    printf("%d\n",isxdigit('f'));//if is a hexadecimal number
    printf("%d\n",islower('a'));//if is lower
    printf("%d\n",isupper('A'));//if is upper
    printf("%d\n",isspace(' '));//if is a space
    printf("%d\n",iscntrl('\n'));//if is a control char
    printf("%d\n",ispunct('.'));//if is a punctuation char
    printf("%d\n",isprint('s'));//if is a printable char
    printf("%d\n",isgraph('9'));//if it have a graphical representation
    printf("%c\n",tolower('9'));//transform to lower
    printf("%c\n",toupper('9'));//transform to upper

    printf("\n--------------------------------\n");


    return 0;
}
