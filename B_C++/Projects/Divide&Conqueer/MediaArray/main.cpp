#include "iostream"
#define N 4
using namespace std;


double DYV_media(double* array, int i, int f);

int main(){

    //Array de numeros par, si no sale mal.
    double array[N] = {10.0,9.0,8.0,11.0};

    cout.precision(2);
    cout << "Media: " << DYV_media(array, 0, N-1) << endl;
    return 0;
}



double DYV_media(double* array, int i, int f){
    if(i == f) return array[i];
    else{
        int m = (i+f)/2;
        double med1 = DYV_media(array, i, m);
        double med2 = DYV_media(array, m+1, f);
        return (med1 + med2)/2;
    }
}