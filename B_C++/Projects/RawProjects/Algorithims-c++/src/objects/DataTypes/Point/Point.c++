#include "Point.h"
#include <cassert>
#include <sstream>
#include <iostream>
#include <math.h>
using namespace std;

Point::Point(const double* coords){
    int d = sizeof(coords)/sizeof(double);
    assert(d>0);
    this->coords = (double*)malloc(d*sizeof(double));
    this->dimension = d;
    for(int i=0;i<this->dimension;i++)
        this->coords[i]=coords[i];
}

double Point::getCoord(const int dim){
    assert(dim>=0&&dim<dimension);
    return coords[dim];
}

int Point::getDimension(){
    return dimension;
}

void Point::setCoord(const double coord,const int dim){
    coords[dim]=coord;
}

void Point::setDimension(const int dimension){
    assert(dimension>0);
    this->dimension=dimension;
    this->coords=(double*)realloc(this->coords,sizeof(double)*dimension);
}

double Point::distanceToOrigin(){
    double coords[] = {0,0,0};
    return distanceToOther(&Point(coords));  
}

double Point::distanceToOther(const Point* p){
    double total = 0;
    for(int i=0;i<this->dimension;i++)
        total+=pow(coords[i]-p->coords[i],2);
    return sqrt(total);
}

string Point::toString(){
    ostringstream oss;
    oss << "(";
    for(int i=0;i<this->dimension;i++) 
        oss << coords[i] << (i==dimension-1)?")":",";
    return oss.str();
}

bool Point::equalsTo(const void* other){
    Point* r = (Point*)other;
    if(r->dimension!=dimension) 
        return false;
    for(int i=0;i<dimension;i++) 
        if(r->coords[i]!=coords[i]) 
            return false;
    return true;
}

Point::~Point(){
    free(coords);
}