#include "Rational.h"
#include <cassert>
#include <iostream>
using namespace std;

int Rational::calcGDC(int a, int b)
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

Rational::Rational(int a,int b)
{
    this->numerator = a;
    this->denominator = b;
}

Rational Rational::sum_rational(Rational r)
{
    return Rational(
        this->numerator*r.denominator+this->denominator*r.numerator,
        this->denominator*r.denominator
    );
}

Rational Rational::mult_rational(Rational r)
{
    return Rational(
        this->numerator*r.numerator,
        this->denominator*r.denominator
    );
}

void Rational::simplify_rational()
{
    int gcd = calcGDC(this->numerator,this->denominator);
    this->numerator/=gcd;
    this->denominator/=gcd;
}

void Rational::print()
{
    if(this->numerator==0)
    {
        cout << "0" << endl;
    }
    else if (this->denominator==1)
    {
        cout << this->numerator << endl;
    }
    else
    {
        cout << this->numerator << "/" << this->denominator;
    }
}