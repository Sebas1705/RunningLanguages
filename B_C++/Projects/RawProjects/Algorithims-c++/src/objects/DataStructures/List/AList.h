#ifndef __ALIST_H
#define __ALIST_H
#include <iostream>
using namespace std;

class AList{
    virtual bool isFull()=0;
    virtual bool isEmpty()=0;
    virtual string toString()=0;
};

#endif