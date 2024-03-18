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
    const int getDen();
    const int getNum();
    void setDen(int den);
    void setNum(int num);

    const Rational* sum(const Rational* a);
    const Rational* minus(const Rational* a);
    const Rational* mult(const Rational* a);
    const Rational* div(const Rational* a);

    void simplify();

    const string toString() override;
    const bool equalsTo(const void* other) override;
};

#endif