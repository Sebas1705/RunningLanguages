#include "Point.h"
#include "math.h"
#include "iostream"

Point::Point(double x, double y)
{
    this->x=x;
    this->y=y;
}

double Point::getX()
{
    return x;
}

double Point::getY()
{
    return y;
}

double Point::module(double disX, double disY)
{
    return sqrt(disX*disX+disY*disY);
}

double Point::distance(Point other)
{
    return module(other.x-this->x,other.y-this->y);
}

double Point::distance_from_origin()
{
    return module(this->x,this->y);
}

bool Point::are_aligned(Point otherA,Point otherB)
{
    double pendientA = (otherA.getY() - y)/(otherA.getX() - x);
    double pendientB = (otherB.getY() - y)/(otherB.getX() - x);
    double pendientAB = (otherA.getY() - otherB.getY())/(otherA.getX() - otherB.getX());
    return pendientA==pendientB==pendientAB;
}

void Point::print()
{
    std::cout << "->Point(" << x << "," << y << ")" << std::endl;
}