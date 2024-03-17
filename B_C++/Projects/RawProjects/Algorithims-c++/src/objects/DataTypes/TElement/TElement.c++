#include "./TElement.h"
#include <sstream>

template <typename T> TElement<T>::TElement(const T value){
    this->element=value;
}

template <typename T> T TElement<T>::getElement(){
    return this->element;
}

template <typename T> void TElement<T>::setElement(const T value){
    this->element=value;
}

template <typename T> string TElement<T>::toString(){
    ostringstream oss;
    oss << "["<< &this->element << "|" << this->element << "]";
    return oss.str();
}

template <typename T> bool TElement<T>::equalsTo(const void* other){
    TElement<T>* t = (TElement<T>*)other;
    return this->element==t->element;
}