#include "iostream"
#include "time.h"

#define NUM 10

template <int N> struct vectorN{
    double v_[N];
};

typedef struct vectorN<NUM> vectorNUM;

int main(){

    srand(time(NULL));
    vectorNUM a;
    
    for(int i=0;i<NUM;i++) a.v_[i]=rand()%1000;
    for(int x : a.v_) std::cout<<x<<std::endl;
    return 0;
}

