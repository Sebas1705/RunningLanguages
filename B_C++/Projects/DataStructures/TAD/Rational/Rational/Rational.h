#ifndef __RATIONAL
#define __RATIONAL

class Rational
{

    int numerator,denominator;

    int calcGDC(int a,int b);

public:

    Rational(int a,int b);

    Rational sum_rational(Rational r);

    Rational mult_rational(Rational r);

    void simplify_rational();
    
    void print();
};

#endif