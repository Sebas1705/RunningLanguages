#include <iostream>
using namespace std;

template<typename T>
T max(T x, T y){
    return (x>y)?x:y;
}

template<typename T,typename U>
auto max2(T x, U y){
    return (x>y)?x:y;
}

template<typename T> 
struct example{
    T x;
    double serial;
};


int main()
{
    return 0;
}
