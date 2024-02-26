#ifndef __POINT
#define __POINT

class Point
{
    double x,y;

    double module(double disX, double disY);

public:

    Point(double x,double y);
    
    double distance(Point other);

    double distance_from_origin();

    bool are_aligned(Point otherA,Point otherB); 

    double getX();

    double getY();

    void print();

};

#endif