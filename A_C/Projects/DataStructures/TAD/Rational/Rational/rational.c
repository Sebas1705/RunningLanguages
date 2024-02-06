#include "./rational.h"
#include <stdio.h>
#include <assert.h>

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

Rational create_Rational(int a,int b)
{
    Rational r;
    r.numerator = a;
    r.denominator = b;
    return r;
}

Rational sum_rational(Rational a,Rational b)
{
    Rational r;
    r.numerator = a.numerator*b.denominator + b.numerator*a.denominator;
    r.denominator = a.denominator*b.denominator;
    return r;
}

Rational mult_rational(Rational a,Rational b)
{
    Rational r;
    r.numerator = a.numerator*b.numerator;
    r.denominator = a.denominator*b.denominator;
    return r;
}

void simplify_rational(Rational* r)
{
    int gcd = calcGDC(r->numerator,r->denominator);
    r->numerator/=gcd;
    r->denominator/=gcd;
}

void print_rational(Rational r)
{
    if(r.numerator==0)
    {
        printf("0\n");
    }
    else if (r.denominator==1)
    {
        printf("%d\n",r.numerator);
    }
    else
    {
        printf("%d/%d\n",r.numerator,r.denominator);
    }
}