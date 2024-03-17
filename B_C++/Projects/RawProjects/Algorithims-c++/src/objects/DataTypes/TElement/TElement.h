#ifndef __TELEMENT_H
#define __TELEMENT_H
#include <iostream>
using namespace std;

template <typename T>
class TElement:AType{

    T element;

public:

    TElement(const T value);
    T getElement();
    void setElement(const T element);

    string toString() override;
    bool equalsTo(const void* other) override;

};

#endif