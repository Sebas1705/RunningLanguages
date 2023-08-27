#include "iostream"

using namespace std;

int fibonacci(int n);

int main(){
    
    int n;
    cout << "Introuduce n para hacer su fibonacci: ";
    cin >> n;

    fprintf(stdout, "El fibonacci de %d es: %d", n, fibonacci(n));
    return 0;
}

int fibonacci(int n){
    //Caso trivial:
    if(n == 0 || n == 1) return n;
    //Caso recursivo:
    else{
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
