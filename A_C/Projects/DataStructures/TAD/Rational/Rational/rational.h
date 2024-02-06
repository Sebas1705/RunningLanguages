#ifndef __RATIONAL
#define __RATIONAL

typedef struct {
    int numerator;
    int denominator;
} Rational;


int calcGDC(int a, int b);

Rational create_rational(int a,int b);

Rational sum_rational(Rational a,Rational b);

Rational mult_rational(Rational a,Rational b);

void simplify_rational(Rational* r);

void print_rational(Rational r);

#endif