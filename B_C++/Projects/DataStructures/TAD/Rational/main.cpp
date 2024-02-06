#include "Rational/rational.h"
#include <iostream>
using namespace std;

int main()
{
    int num,den;
    do
    {
        cout << "Introduce a's numerator and denominator (split with spaces)." << endl;
        cout << "Denominator not equal to zero: ";
        cin >> num >> den; 
    }
    while(den==0);
    Rational a = Rational(num,den);
    a.print();
    cout << endl;
    
    do
    {
        cout << "Introduce b's numerator and denominator (split with spaces)." << endl;
        cout << "Denominator not equal to zero: ";
        cin >> num >> den; 
    }
    while(den==0);
    Rational b = Rational(num,den);
    b.print();
    cout << endl;

    Rational a_plus_b = a.sum_rational(b);
    cout << "Rational a+b: ";
    a_plus_b.print();
    cout << endl;

    a_plus_b.simplify_rational();
    cout << "Rational a+b simplify: ";
    a_plus_b.print();
    cout << endl;


    Rational a_mult_b = a.mult_rational(b);
    cout << "Rational a*b: ";
    a_mult_b.print();
    cout << endl;

    a_mult_b.simplify_rational();
    cout << "Rational a*b simplify: ";
    a_mult_b.print();
    cout << endl;

    return 0;
}