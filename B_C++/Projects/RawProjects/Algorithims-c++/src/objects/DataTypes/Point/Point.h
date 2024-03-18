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

    const double getCoord(const int dim);
    const int getDimension();
    void setCoord(const double coord,const int dim);
    void setDimension(const int dimension);

    const double distanceToOrigin();
    const double distanceToOther(const Point* p);

    const string toString() override;
    const bool equalsTo(const void* other) override;

    ~Point();
};

#endif