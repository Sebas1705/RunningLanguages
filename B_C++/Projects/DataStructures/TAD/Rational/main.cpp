#include "Rational/Rational.h"
#include "PrintRational/PrintRational.h"
#include <iostream>
using namespace std;

int main()
{
    rational a;
    do
    {
        cout << "Introduce a's numerator and denominator (split with spaces)." << endl;
        cout << "Denominator not equal to zero: ";
        cin >> a.numerator >> a.denominator; 
    }
    while(a.denominator==0);
    print_rational(a);
    cout << endl;
    
    rational b;
    do
    {
        cout << "Introduce b's numerator and denominator (split with spaces)." << endl;
        cout << "Denominator not equal to zero: ";
        cin >> b.numerator >> b.denominator; 
    }
    while(b.denominator==0);
    print_rational(b);
    cout << endl;

    rational a_plus_b = sum_rational(a,b);
    cout << "Rational a+b: ";
    print_rational(a_plus_b);
    cout << endl;

    simplify_rational(&a_plus_b);
    cout << "Rational a+b simplify: ";
    print_rational(a_plus_b);
    cout << endl;


    rational a_mult_b = mult_rational(a,b);
    cout << "Rational a*b: ";
    print_rational(a_mult_b);
    cout << endl;

    simplify_rational(&a_mult_b);
    cout << "Rational a*b simplify: ";
    print_rational(a_mult_b);
    cout << endl;

    return 0;
}