#ifndef __POINT
#define __POINT

typedef struct
{
    double x,y;
}
Point;

double module(double disX, double disY);

Point createPoint(double x,double y);

void move(Point* point,double moveX,double moveY);
    
double distance(Point a,Point b);

double distance_from_origin(Point p);

int are_aligned(Point a,Point b,Point c); 

void print(Point p);

#endif