#ifndef __ATYPE_H
#define __ATYPE_H
#include "iostream"

class AType{
    virtual std::string toString()=0;
    virtual bool equalsTo(const void* other)=0;
};

#endif