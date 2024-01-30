#include "../Rational/Rational.h"
#include "iostream"


using namespace std;

void print_rational(rational a)
{
    if(a.numerator==0)
    {
        cout << "0";
    }
    else if (a.denominator==1)
    {
        cout << a.numerator;
    }
    else
    {
        cout << a.numerator << "/" << a.denominator;
    }
}