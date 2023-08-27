#include "iostream"
#define N 8
using namespace std;


int DYV_suma(int* array, int i, int f);

int main(){

    int array[N] = {0,10,2,3,40,5,6,7};

    cout << "Suma: " << DYV_suma(array, 0, N-1) << endl;
    return 0;
}



int DYV_suma(int* array, int i, int f){
    if(i == f) return array[i];
    else{
        int m = (i+f)/2;
        int sum1 = DYV_suma(array, i, m);
        int sum2 = DYV_suma(array, m+1, f);
        return sum1 + sum2;
    }
}