#include "Rational/rational.h"
#include <stdio.h>

int main()
{
    Rational a;
    do
    {
        printf("Introduce a's numerator and denominator (split with spaces).\n");
        printf("Denominator not equal to zero: ");
        scanf("%d %d",&a.numerator,&a.denominator); 
    }
    while(a.denominator==0);
    print_rational(a);
    printf("\n");
    
    Rational b;
    do
    {
        printf("Introduce a's numerator and denominator (split with spaces).\n");
        printf("Denominator not equal to zero: ");
        scanf("%d %d",&b.numerator,&b.denominator); 
    }
    while(b.denominator==0);
    print_rational(b);
    printf("\n");

    Rational a_plus_b = sum_rational(a,b);
    printf("Rational a+b: ");
    print_rational(a_plus_b);
    printf("\n");

    simplify_rational(&a_plus_b);
    printf("Rational a+b simplify: ");
    print_rational(a_plus_b);
    printf("\n");


    Rational a_mult_b = mult_rational(a,b);
    printf("Rational a*b: ");
    print_rational(a_mult_b);
    printf("\n");

    simplify_rational(&a_mult_b);
    printf("Rational a*b simplify: ");
    print_rational(a_mult_b);
    printf("\n");

    return 0;
}