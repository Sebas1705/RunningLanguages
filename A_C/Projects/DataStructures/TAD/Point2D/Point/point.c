#include "./point.h"
#include <stdio.h>
#include <math.h>

double module(double disX, double disY)
{
    return sqrt(disX*disX+disY*disY);
}

Point createPoint(double x,double y)
{
    Point p;
    p.x = x;
    p.y = y;
    return p;
}

void move(Point* point,double moveX,double moveY)
{
    point->x+=moveX;
    point->y+=moveY;
}
    
double distance(Point a,Point b)
{
    return module(a.x-b.x,a.y-b.y);
}

double distance_from_origin(Point p)
{
    return module(p.x,p.y);
}

int are_aligned(Point a,Point b,Point c)
{
    double pendientAB = (b.y-a.y)/(b.x-a.x);
    double pendientBC = (c.y-b.y)/(c.x-b.x);
    return pendientAB==pendientBC;
}

void print(Point p)
{
    printf("->Point(%.3lf,%.3lf)\n",p.x,p.y);
}