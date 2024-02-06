#include "./Point/point.h"
#include <stdio.h>

int main(int argc, char const *argv[])
{
    Point a = createPoint(1,1);
    print(a);
    Point b = createPoint(2,2);
    print(b);
    Point c = createPoint(3,3);
    print(c);

    printf("Are aligned: %s\n",(are_aligned(a,b,c))?"True":"False");
    return 0;
}
