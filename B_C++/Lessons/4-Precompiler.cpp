//Inclusion and imports:
#include "stdio.h" //Local search first
#include <string.h> //Compiler search first

//Constants:
#define PI 3.141592653589793
#define HELLO "Hello, world!"
#define IS true
#define NUM 12

//Definition Condition:
#ifdef _WIN32 //Windows specific
/*
    code if DEBUG is defined
*/
#endif

#ifndef __linux__ //Linux specific
/*
    code if DEBUG is undefined
*/
#endif

//Condition only integer:
#if NUM > 12
/* code */
#else
/* code */
#endif

//Macros:
#define SWAP(a, b) typeof(a) temp = (a); (a) = (b); (b) = temp; 
#define MAX(x, y) ((x) > (y) ? (x) : (y))
#define ARRAY_SIZE(arr) (sizeof(arr) / sizeof((arr)[0]))
#define PRINT_LOCATION printf("File: %s, Line: %d\n", __FILE__, __LINE__)

//Chance archive name and line:
#line 23 "we.c"

//Pragmas:
#pragma warning(disable: 123) //Deactivated warning that code is 123
#pragma warning(default: all) //Set all warnings to default
#pragma message("Compiler message") //Compiler message
#pragma once //Include once this program


int main(int argc, char const *argv[])
{
    PRINT_LOCATION;
    return 0;
}
