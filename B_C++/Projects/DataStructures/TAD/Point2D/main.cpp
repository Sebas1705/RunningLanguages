#include "Point/Point.h"
#include "iostream"
#include "stdbool.h"

int main()
{
    Point a = Point(1,1);
    a.print();
    Point b = Point(2,2);
    b.print();
    Point c = Point(3,3);
    c.print();

    std::cout << "Are aligned: " << a.are_aligned(b,c) << std::endl;

    return 0;
}
