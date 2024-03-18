#include "./TElement.h"
#include <sstream>

template <typename T> TElement<T>::TElement(const T value){
    this->element=value;
}

template <typename T> const T TElement<T>::getElement(){
    return this->element;
}

template <typename T> void TElement<T>::setElement(const T value){
    this->element=value;
}

template <typename T> const string TElement<T>::toString(){
    ostringstream oss;
    oss << "["<< &this->element << "|" << this->element << "]";
    return oss.str();
}

template <typename T> const bool TElement<T>::equalsTo(const void* other){
    return this->element==(TElement<T>*)other->element;
}