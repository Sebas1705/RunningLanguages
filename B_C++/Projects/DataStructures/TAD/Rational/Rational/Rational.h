#ifndef __RATIONAL
#define __RATIONAL

typedef struct {
    int numerator;
    int denominator;
} rational;


int calcGDC(int a, int b);

rational create_rational(int a,int b);

rational sum_rational(rational a,rational b);

rational mult_rational(rational a,rational b);

void simplify_rational(rational* a);

#endif