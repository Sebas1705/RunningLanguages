#include <stdio.h>

//If the variables are global declared outside the main function
int a,b;//Declaration

//Types variables primitives:
char c; //1byte, -128 to 127, format: %c
unsigned char d; //1byte, 0 to 255, format: %c
short i; //2bytes, -32,768 to 32,767, format: %hd
unsigned short j; //2bytes, 0 to 65,535, format: %hu
int l; //4bytes, -2,147,483,648 to 2,147,483,647, format: %d
unsigned int k; //4bytes, 0 to 4,294,967,295, format: %u
long m; //4bytes, -2,147,483,648 to 2,147,483,647, format: %ld
unsigned long n; //4bytes, 0 to 4,294,967,295, format: %lu
long long o; //8bytes, -(2^63) to (2^63)-1, format: %lld
unsigned long long p; //8bytes, 0 to 18,446,744,073,709,551,615, format: %llu
float f=4444.44444; //4bytes, 1.2E-38 to 3.4E+38, format: %f
double du; //8bytes, 1.7E-308 to 1.7E+308, format: %lf
long double ld; //16bytes, 3.4E-4932 to 1.1E+4932, format: %Lf

int main(){
    a=2;//Initialization 
    b=3;
    printf("a=%d b=%d\n",a,b);

    //Operands(numbers):
    printf("a+b=%d\n",a+b);//Add
    printf("a-b=%d\n",a-b);//Sub
    printf("a*b=%d\n",a*b);//Mult
    printf("a/b=%d\n",a/b);//Div
    printf("a%%b=%d\n",a%b);//Rest
    printf("a^b=%d\n",a^b);//bitwise xor
    printf("a&b=%d\n",a&b);//bitwise and
    printf("a|b=%d\n",a|b);//bitwise or
    printf("~a=%d\n",~a);//bitwise complement
    printf("a<<b=%d\n",a<<b);//shift left
    printf("a>>b=%d\n",a>>b);//shift right
    printf("sizeof(a)=%d\n",sizeof(a));//sizeof

    //Conditionals(0 or not 0):
    printf("a&&b=%d\n",a&&b);//And
    printf("a||b=%d\n",a||b);//Or
    printf("!a=%d\n",!a);//Not
    printf("a==b=%d\n",a==b);//Equal
    printf("a!=b=%d\n",a!=b);//Not equal
    printf("a<b=%d\n",a<b);//Less than
    printf("a<=b=%d\n",a<=b);//Less than or equal
    printf("a>b=%d\n",a>b);//Greater than
    printf("a>=b=%d\n",a>=b);//Greater than or equal

    //Assignation operator
    a+=b;//a=a+b with al operators
    --a;//Predecrement
    a--;//Postdecrement
    ++a;//Preincrement
    a++;//Postincrement


    //Sizes:
    printf("sizeof(int)=%d\n",sizeof(int));//sizeof type

    //String in c:
    char str[]="Hello"; //X(longString)Bytes, format: %s
    printf("%s\n",str);

    d=10001020030;

    //format specifier
    //%1 minimum length
    //%.2 maximum decimal length
    //%- left align
    printf("address=%p\n",f);//memory address
    printf("hex=%x\n",d);//hexadecimal number
    printf("octal=%o\n",d);//octal number
    printf("exp=%e\n",f);//exponential number
    printf("%-20.1st\n",str);//Number of spaces(-20) and number of chars in string(1)
    printf("f=%.2f\n",f);//number of decimal part(2)



    //Consts:
    const float PI = 3.1415;
    //PI = 1.122323;//Error
    printf("%-10.4f\n",PI);

    //Parsers:
    int i = 101010110;
    long l = (long) i;

    return 0;
}