#ifndef __POINT_H
#define __POINT_H
#include "../AType.h"
#include <iostream>
using namespace std;


class Point:AType{

    double* coords;
    int dimension;

public:

    Point(const double* coords);

    double getCoord(const int dim);
    int getDimension();
    void setCoord(const double coord,const int dim);
    void setDimension(const int dimension);

    double distanceToOrigin();
    double distanceToOther(const Point* p);

    string toString() override;
    bool equalsTo(const void* other) override;

    ~Point();
};

#endif