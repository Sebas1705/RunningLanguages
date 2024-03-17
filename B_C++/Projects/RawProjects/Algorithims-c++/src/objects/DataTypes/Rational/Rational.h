#ifndef __RATIONAL_H
#define __RATIONAL_H
#include <iostream>
using std::string;
#include "../AType.h"

class Rational:AType{
    
    int num,den;
    int gcd(int a, int b);

public:

    Rational(int a, int b);
    

    //Getters and Setters
    int getDen();
    int getNum();
    void setDen(int den);
    void setNum(int num);

    Rational* sum(const Rational* a);
    Rational* minus(const Rational* a);
    Rational* mult(const Rational* a);
    Rational* div(const Rational* a);

    void simplify();

    string toString() override;
    bool equalsTo(const void* other) override;
};

#endif