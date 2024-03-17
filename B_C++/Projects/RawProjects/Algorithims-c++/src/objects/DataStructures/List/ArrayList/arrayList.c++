#include "./arrayList.h"
#include <stdlib.h>
#include <assert.h>
#include <sstream>

#define INCREMENT 2

template<typename T> ArrayList<T>::ArrayList(){
    this->array = NULL;
    this->capacity = 0;
    this->n = 0;
}

template<typename T> ArrayList<T>::~ArrayList(){
    free(this->array);
}

template<typename T> int ArrayList<T>::getN(){
    return this->n;
}

template<typename T> int ArrayList<T>::getCapacity(){
    return this->capacity;
}

template<typename T> void ArrayList<T>::set(const int index,const T value){
    assert(index<this->n&&index>=0);
    TElement e = TElement(value);
    this->array[index] = value;
}

template<typename T> void ArrayList<T>::amply(const int increment){
    this->array = (T*)realloc(this->array,(this->capacity+increment)*sizeof(T));
    this->capacity += increment;
}

template<typename T> T ArrayList<T>::get(const int index){
    assert(index<this->n&&index>=0);
    return this->array[index];
}

template<typename T> void ArrayList<T>::insert(const int index,const T value){
    assert(index<=array->n&&index>=0);
    if(isFull()) amply(INCREMENT);
    memmove(&this->array[index+1],&this->array[index],sizeof(T)*(this->n-index));
    this->n++;
    set(index,value);
}

template<typename T> void ArrayList<T>::insertLast(const T value){
    insert(this->n,value);
}

template<typename T> void ArrayList<T>::removeInList(const int index){
    assert(index<array->n&&index>=0);
    memmove(&array->array[index],&array->array[index+1],sizeof(T)*(array->n-index-1));
    this->n--;
    if(this->capacity-this->n>=INCREMENT*2) amply(-INCREMENT);
}

template<typename T> void ArrayList<T>::removeLast(){
    removeInList(this->n-1);
}

template<typename T> void ArrayList<T>::concat(const ArrayList *array){
    this->array=(int*)realloc(this->array,sizeof(T)*(this->capacity+array->n));
    this->capacity+=array->n;
    for(int i=0;i<array->n;i++) insertLast(this->array[i]);
}

template<typename T> int ArrayList<T>::search(const T value){
    for(int i=0;i<this->n;i++)
        if(this->array[i].getElement()==value)
            return i;
    return -1;
}


template<typename T> bool ArrayList<T>::isFull(){
    return this->n==this->capacity;
}

template<typename T> bool ArrayList<T>::isEmpty(){
    return this->n==0;
}

template<typename T> string ArrayList<T>::toString(){
    ostringstream oss;
    oss << "(";
    for(int i=0;i<this->n;i++)
        oss << this->array[i].toString() << (i==this->n-1)?")":",";
    return oss.str();
}
