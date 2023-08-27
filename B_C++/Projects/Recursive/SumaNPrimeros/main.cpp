#include "iostream"

using namespace std;

int sumaN(int n);

int main(){

    int n;
    cout << "Introduce n para hacer la suma de los n primeros numero:" << endl;
    cin >> n;

    fprintf(stdout, "La suma de los %d primeros numero es: %d", n, sumaN(n));
    return 0;
}

int sumaN(int n){
    //Caso trivial:
    if(n == 1 || n == 0) return n;
    //Caso recursivo:
    else{
        return sumaN(n-1) + n;
    }
}
