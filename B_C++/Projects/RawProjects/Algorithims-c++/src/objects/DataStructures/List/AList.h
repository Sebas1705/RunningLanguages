#ifndef __ALIST_H
#define __ALIST_H
#include <iostream>
using namespace std;

class AList{
    virtual const bool isEmpty()=0;
    virtual const string toString()=0;
};

#endif