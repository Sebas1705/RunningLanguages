#include "Rational.h"
#include "cassert"

int calcGDC(int a, int b)
{
    assert(a>=0);
    if(b==0)
    {
        return a;
    }
    else
    {
       return calcGDC(b,a%b); 
    }
}

rational create_rational(int a,int b)
{
    rational r;
    r.numerator = a;
    r.denominator = b;
    return r;
}

rational sum_rational(rational a,rational b)
{
    rational r;
    r.numerator = a.numerator*b.denominator + b.numerator*a.denominator;
    r.denominator = a.denominator*b.denominator;
    return r;
}

rational mult_rational(rational a,rational b)
{
    rational r;
    r.numerator = a.numerator*b.numerator;
    r.denominator = a.denominator*b.denominator;
    return r;
}

void simplify_rational(rational* a)
{
    int gcd = calcGDC(a->numerator,a->denominator);
    a->numerator/=gcd;
    a->denominator/=gcd;
}
