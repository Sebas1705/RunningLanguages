#include "Rational.h"
#include <cassert>
#include <iostream>
#include <sstream>
using namespace std;

Rational::Rational(int a,int b){
    assert(b!=0);
    this->num=a;
    this->den=b;
}

int Rational::gcd(int a,int b){
    assert(a>=0);
    if(b==0) return a;
    else return gcd(b,a%b); 
}

const int Rational::getDen(){return den;}
const int Rational::getNum(){return num;}
void Rational::setDen(int den){this->den=den;}
void Rational::setNum(int num){this->num=num;}

const Rational* Rational::sum(const Rational* a){
    Rational r = Rational(
        this->num*a->den+this->den*a->num,
        this->den*a->den
    );
    return &r;
}

const Rational* Rational::minus(const Rational* a){
    Rational r = Rational(
        this->num*a->den-this->den*a->num,
        this->den*a->den
    );
    return &r;
}

const Rational* Rational::mult(const Rational* a){
    Rational r = Rational(
        this->num*a->num,
        this->den*a->den
    );
    return &r;
}

const Rational* Rational::div(const Rational* a){
    Rational r = Rational(
        this->num*a->den,
        this->den*a->num
    );
    return &r;
}

void Rational::simplify(){
    int ngcd = gcd(this->num,this->den);
    this->den/=ngcd;
    this->num/=ngcd;
}

const string Rational::toString() {
    ostringstream oss;
    oss << this->num << "/" << this->den << "/" << this->den;
    return oss.str();
}

const bool Rational::equalsTo(const void* other) {
    Rational* r = (Rational*)other;
    int gcdR = gcd(r->num,r->den);
    int gcdP = gcd(this->num,this->den);
    return (this->num/gcdP==r->num/gcdR) && (this->den/gcdP==r->den/gcdR);
}